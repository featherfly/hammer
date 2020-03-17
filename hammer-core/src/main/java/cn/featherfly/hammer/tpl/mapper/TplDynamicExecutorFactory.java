
package cn.featherfly.hammer.tpl.mapper;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdImpl;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.TplExecution;
import cn.featherfly.hammer.tpl.annotation.TplParam;
import cn.featherfly.hammer.tpl.annotation.TplParamType;
import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 * <p>
 * TplMapperFactory
 * </p>
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactory {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Set<Class<?>> types = new HashSet<>();

    private static final TplDynamicExecutorFactory INSTANCE = new TplDynamicExecutorFactory();

    private Map<Class<?>, Object> typeInstances = new HashMap<>();

    /**
     *
     */
    private TplDynamicExecutorFactory() {
        super();
    }

    /**
     * <p>
     * get DynamicTplMapperFactory Instance
     * </p>
     *
     * @return DynamicTplMapperFactory
     */
    public static TplDynamicExecutorFactory getInstance() {
        return INSTANCE;
    }

    public String create(Class<?> type) throws NotFoundException, CannotCompileException {
        String dynamicClassName = type.getPackage().getName() + "._" + type.getSimpleName() + "DynamicImpl";
        if (!types.contains(type)) {
            String globalNamespace = getNamespace(type);
            String hammerFieldName = "hammer";

            ClassPool pool = ClassPool.getDefault();
            pool.insertClassPath(new ClassClassPath(this.getClass()));
            CtClass dynamicImplClass = pool.makeClass(dynamicClassName);
            dynamicImplClass.addInterface(pool.getCtClass(type.getName()));
            String constructorBody = null;
            if (ClassUtils.isParent(Hammer.class, type)) {
                dynamicImplClass.setSuperclass(pool.getCtClass(BasedTplHammer.class.getName()));
                constructorBody = "{super($1);}";
                hammerFieldName = "super." + hammerFieldName;
            } else if (ClassUtils.isParent(GenericHammer.class, type)) {
                String typeName = null;
                for (Type implType : type.getGenericInterfaces()) {
                    ParameterizedType parameterizedType = (ParameterizedType) implType;
                    if (parameterizedType.getRawType() == GenericHammer.class) {
                        typeName = parameterizedType.getActualTypeArguments()[0].getTypeName();
                        break;
                    }
                }
                dynamicImplClass.setSuperclass(pool.getCtClass(BasedTplGenericHammer.class.getName()));
                constructorBody = "{super($1, " + typeName + ".class);}";
                hammerFieldName = "super." + hammerFieldName;
            } else {
                constructorBody = "{this.hammer=$1;}";
            }

            // 加入hammer
            CtField nameField = new CtField(pool.getCtClass(Hammer.class.getName()), "hammer", dynamicImplClass);
            nameField.setModifiers(Modifier.PRIVATE);
            dynamicImplClass.addField(nameField);

            CtConstructor constraConstructor = new CtConstructor(
                    new CtClass[] { pool.getCtClass(Hammer.class.getName()) }, dynamicImplClass);
            constraConstructor.setModifiers(Modifier.PUBLIC);
            constraConstructor.setBody(constructorBody);
            dynamicImplClass.addConstructor(constraConstructor);
            // System.err.println(constraConstructor);

            addImplMethods(type, globalNamespace, pool, dynamicImplClass, hammerFieldName);

            dynamicImplClass.toClass();
            dynamicImplClass.detach();
            types.add(type);
        }
        return dynamicClassName;
    }

    /*
     * add implements methods
     */
    private void addImplMethods(Class<?> type, String globalNamespace, ClassPool pool, CtClass dynamicImplClass,
            String hammerFieldName) throws NotFoundException, CannotCompileException {
        for (Method method : type.getDeclaredMethods()) {
            if (method.isDefault()) {
                continue;
            }
            // TODO 注解annotation要代理到实现类
            CtClass[] ctParamTypes = new CtClass[method.getParameterTypes().length];
            String namespace = getNamespace(method, globalNamespace);
            String name = getName(method);
            TplExecuteId executeId = new TplExecuteIdImpl(name, namespace);
            int i = 0;
            String setParams = "";
            int pageParamPosition = -1;
            int offsetParamPosition = -1;
            int limitParamPosition = -1;
            for (Parameter parameter : method.getParameters()) {
                ctParamTypes[i] = pool.getCtClass(parameter.getType().getName());
                i++;
                TplParamType paramType = getParamType(parameter);
                switch (paramType) {
                    case QUERY:
                        setParams += ".putChain(\"" + getParamName(parameter) + "\", $" + i + ")";
                        break;
                    case PAGE:
                        pageParamPosition = i;
                        break;
                    case PAGE_OFFSET:
                        offsetParamPosition = i;
                        break;
                    case PAGE_LIMIT:
                        limitParamPosition = i;
                        break;
                }
            }
            if (pageParamPosition > 0) {
                setParams += ", $" + pageParamPosition;
            } else if (limitParamPosition > 0) {
                if (offsetParamPosition > 0) {
                    setParams += ", $" + offsetParamPosition + ", $" + limitParamPosition;
                } else {
                    setParams += ", 0, $" + limitParamPosition;
                }
            }

            CtMethod ctMethod = new CtMethod(pool.getCtClass(method.getReturnType().getTypeName()), method.getName(),
                    ctParamTypes, dynamicImplClass);

            String body = null;
            if (ClassUtils.isParent(List.class, method.getReturnType())) {
                String returnTypeName = getReturnTypeName(method);
                if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
                    body = String.format("{return %s.list(\"%s\", new %s()%s);}", hammerFieldName, executeId.getId(),
                            HashChainMap.class.getName(), setParams);
                } else {
                    body = String.format("{return %s.list(\"%s\", %s.class, new %s()%s);}", hammerFieldName,
                            executeId.getId(), returnTypeName, HashChainMap.class.getName(), setParams);
                }
            } else if (ClassUtils.isParent(PaginationResults.class, method.getReturnType())) {
                String returnTypeName = getReturnTypeName(method);
                if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
                    body = String.format("{return %s.pagination(\"%s\", new %s()%s);}", hammerFieldName,
                            executeId.getId(), HashChainMap.class.getName(), setParams);
                } else {
                    body = String.format("{return %s.pagination(\"%s\", %s.class, new %s()%s);}", hammerFieldName,
                            executeId.getId(), returnTypeName, HashChainMap.class.getName(), setParams);
                }
            } else if (ClassUtils.isParent(Number.class, method.getReturnType())) {
                body = String.format("{return (%3$s) %s.number(\"%s\", %s.class, new %s()%s);}", hammerFieldName,
                        executeId.getId(), method.getReturnType().getName(), HashChainMap.class.getName(), setParams);
            } else if (String.class == method.getReturnType()) {
                body = String.format("{return  %s.string(\"%s\", new %s()%s);}", hammerFieldName, executeId.getId(),
                        HashChainMap.class.getName(), setParams);
            } else if (ClassUtils.isParent(Map.class, method.getReturnType())) {
                body = String.format("{return  %s.single(\"%s\", new %s()%s);}", hammerFieldName, executeId.getId(),
                        HashChainMap.class.getName(), setParams);
            } else {
                body = String.format("{return (%3$s)  %s.single(\"%s\", %s.class, new %s()%s);}", hammerFieldName,
                        executeId.getId(), method.getReturnType().getName(), HashChainMap.class.getName(), setParams);
            }
            // System.err.println(ctMethod);
            // System.err.println(body);
            logger.debug("method {} -> {}", method.getName(), body);
            ctMethod.setBody(body);
            dynamicImplClass.addMethod(ctMethod);
        }
    }

    /**
     * getReturnTypeName
     *
     * @param method
     * @return
     */
    private String getReturnTypeName(Method method) {
        if (method.getGenericReturnType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
            Type objectType = ClassUtils.getRawType(parameterizedType.getActualTypeArguments()[0]);
            return objectType.getTypeName();
        }
        return method.getName();
    }

    public <E> E newInstance(Class<E> type, Hammer hammer) {
        return newInstance(type, hammer, true);
    }

    @SuppressWarnings("unchecked")
    public <E> E newInstance(Class<E> type, Hammer hammer, boolean cache) {
        E e = null;
        if (cache) {
            e = (E) typeInstances.get(type);
            if (e == null) {
                e = instance(type, hammer);
                typeInstances.put(type, e);
            }
            return e;
        } else {
            return instance(type, hammer);
        }
    }

    @SuppressWarnings("unchecked")
    public <E> E instance(Class<E> type, Hammer hammer) {
        try {
            return (E) ClassUtils.forName(create(type)).getConstructor(Hammer.class).newInstance(hammer);
        } catch (Exception e) {
            throw new HammerException(e);
        }
    }

    private String getNamespace(Class<?> type) {
        Mapper mapper = type.getAnnotation(Mapper.class);
        if (mapper != null && LangUtils.isNotEmpty(mapper.namespace())) {
            return mapper.namespace();
        } else {
            return type.getSimpleName();
        }
    }

    private String getNamespace(Method method, String namespace) {
        TplExecution tplExecution = method.getAnnotation(TplExecution.class);
        if (tplExecution != null && LangUtils.isNotEmpty(tplExecution.namespace())) {
            return tplExecution.namespace();
        } else {
            return namespace;
        }
    }

    private String getName(Method method) {
        TplExecution tplExecution = method.getAnnotation(TplExecution.class);
        if (tplExecution != null && LangUtils.isNotEmpty(tplExecution.name())) {
            return tplExecution.name();
        } else {
            return method.getName();
        }
    }

    private String getParamName(Parameter parameter) {
        TplParam tplParam = parameter.getAnnotation(TplParam.class);
        if (tplParam != null && LangUtils.isNotEmpty(tplParam.value())) {
            return tplParam.value();
        } else {
            return parameter.getName();
        }
    }

    private TplParamType getParamType(Parameter parameter) {
        TplParam tplParam = parameter.getAnnotation(TplParam.class);
        if (tplParam != null) {
            return tplParam.type();
        } else if (ClassUtils.isParent(Page.class, parameter.getType())) {
            return TplParamType.PAGE;
        } else {
            return TplParamType.QUERY;
        }
    }
}
