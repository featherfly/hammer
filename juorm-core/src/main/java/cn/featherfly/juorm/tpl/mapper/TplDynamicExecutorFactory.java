
package cn.featherfly.juorm.tpl.mapper;

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
import cn.featherfly.juorm.GenericJuorm;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.tpl.TplExecuteId;
import cn.featherfly.juorm.tpl.TplExecuteIdImpl;
import cn.featherfly.juorm.tpl.annotation.TplExecution;
import cn.featherfly.juorm.tpl.annotation.TplParam;
import cn.featherfly.juorm.tpl.annotation.TplParamType;
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
 * <p>
 * 2019-08-14
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

    public String create(Class<?> type)
            throws NotFoundException, CannotCompileException {
        String dynamicClassName = type.getPackage().getName() + "._"
                + type.getSimpleName() + "DynamicImpl";
        if (!types.contains(type)) {
            String globalNamespace = getNamespace(type);
            String juormFieldName = "juorm";

            ClassPool pool = ClassPool.getDefault();
            pool.insertClassPath(new ClassClassPath(this.getClass()));
            CtClass dynamicImplClass = pool.makeClass(dynamicClassName);
            dynamicImplClass.addInterface(pool.getCtClass(type.getName()));
            String constructorBody = null;
            if (ClassUtils.isParent(Juorm.class, type)) {
                dynamicImplClass.setSuperclass(
                        pool.getCtClass(BasedJuormTplExecutor.class.getName()));
                constructorBody = "{super($1);}";
                juormFieldName = "super." + juormFieldName;
            } else if (ClassUtils.isParent(GenericJuorm.class, type)) {
                String typeName = null;
                for (Type implType : type.getGenericInterfaces()) {
                    ParameterizedType parameterizedType = (ParameterizedType) implType;
                    if (parameterizedType.getRawType() == GenericJuorm.class) {
                        typeName = parameterizedType.getActualTypeArguments()[0]
                                .getTypeName();
                        break;
                    }
                }
                dynamicImplClass.setSuperclass(pool.getCtClass(
                        BasedGenericJuormTplExecutor.class.getName()));
                constructorBody = "{super($1, " + typeName + ".class);}";
                juormFieldName = "super." + juormFieldName;
            } else {
                constructorBody = "{this.juorm=$1;}";
            }

            // 加入juorm
            CtField nameField = new CtField(
                    pool.getCtClass(Juorm.class.getName()), "juorm",
                    dynamicImplClass);
            nameField.setModifiers(Modifier.PRIVATE);
            dynamicImplClass.addField(nameField);

            CtConstructor constraConstructor = new CtConstructor(
                    new CtClass[] { pool.getCtClass(Juorm.class.getName()) },
                    dynamicImplClass);
            constraConstructor.setModifiers(Modifier.PUBLIC);
            constraConstructor.setBody(constructorBody);
            dynamicImplClass.addConstructor(constraConstructor);
            // System.err.println(constraConstructor);

            addImplMethods(type, globalNamespace, pool, dynamicImplClass,
                    juormFieldName);

            dynamicImplClass.toClass();
            dynamicImplClass.detach();
            types.add(type);
        }
        return dynamicClassName;
    }

    /*
     * add implements methods
     */
    private void addImplMethods(Class<?> type, String globalNamespace,
            ClassPool pool, CtClass dynamicImplClass, String juormFieldName)
            throws NotFoundException, CannotCompileException {
        for (Method method : type.getDeclaredMethods()) {
            CtClass[] ctParamTypes = new CtClass[method
                    .getParameterTypes().length];
            String namespace = getNamespace(method, globalNamespace);
            String name = getName(method);
            TplExecuteId executeId = new TplExecuteIdImpl(name, namespace);
            int i = 0;
            String setParams = "";
            int pageParamPosition = -1;
            int offsetParamPosition = -1;
            int limitParamPosition = -1;
            for (Parameter parameter : method.getParameters()) {
                ctParamTypes[i] = pool
                        .getCtClass(parameter.getType().getName());
                i++;
                TplParamType paramType = getParamType(parameter);
                switch (paramType) {
                case QUERY:
                    setParams += ".putChain(\"" + getParamName(parameter)
                            + "\", $" + i + ")";
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
                    setParams += ", $" + offsetParamPosition + ", $"
                            + limitParamPosition;
                } else {
                    setParams += ", 0, $" + limitParamPosition;
                }
            }

            CtMethod ctMethod = new CtMethod(
                    pool.getCtClass(method.getReturnType().getTypeName()),
                    method.getName(), ctParamTypes, dynamicImplClass);
            String body = null;
            if (ClassUtils.isParent(List.class, method.getReturnType())) {
                String returnTypeName = method.getReturnType().getName();
                returnTypeName = getReturnTypeName(method, returnTypeName);
                if (ClassUtils.isParent(Map.class,
                        ClassUtils.forName(returnTypeName))) {
                    body = String.format(
                            "{return %s.list(\"%s\", new %s()%s);}",
                            juormFieldName, executeId.getId(),
                            HashChainMap.class.getName(), setParams);
                } else {
                    body = String.format(
                            "{return %s.list(\"%s\", %s.class, new %s()%s);}",
                            juormFieldName, executeId.getId(), returnTypeName,
                            HashChainMap.class.getName(), setParams);
                }
            } else if (ClassUtils.isParent(PaginationResults.class,
                    method.getReturnType())) {
                String returnTypeName = method.getReturnType().getName();
                returnTypeName = getReturnTypeName(method, returnTypeName);
                if (ClassUtils.isParent(Map.class,
                        ClassUtils.forName(returnTypeName))) {
                    body = String.format(
                            "{return %s.pagination(\"%s\", new %s()%s);}",
                            juormFieldName, executeId.getId(),
                            HashChainMap.class.getName(), setParams);
                } else {
                    body = String.format(
                            "{return %s.pagination(\"%s\", %s.class, new %s()%s);}",
                            juormFieldName, executeId.getId(), returnTypeName,
                            HashChainMap.class.getName(), setParams);
                }
            } else if (ClassUtils.isParent(Number.class,
                    method.getReturnType())) {
                body = String.format(
                        "{return (%3$s) %s.number(\"%s\", %s.class, new %s()%s);}",
                        juormFieldName, executeId.getId(),
                        method.getReturnType().getName(),
                        HashChainMap.class.getName(), setParams);
            } else if (String.class == method.getReturnType()) {
                body = String.format(
                        "{return  %s.stringValue(\"%s\", new %s()%s);}",
                        juormFieldName, executeId.getId(),
                        HashChainMap.class.getName(), setParams);
            } else if (ClassUtils.isParent(Map.class, method.getReturnType())) {
                body = String.format("{return  %s.single(\"%s\", new %s()%s);}",
                        juormFieldName, executeId.getId(),
                        HashChainMap.class.getName(), setParams);
            } else {
                body = String.format(
                        "{return (%3$s)  %s.single(\"%s\", %s.class, new %s()%s);}",
                        juormFieldName, executeId.getId(),
                        method.getReturnType().getName(),
                        HashChainMap.class.getName(), setParams);
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
     * @param returnTypeName
     * @return
     */
    private String getReturnTypeName(Method method, String returnTypeName) {
        if (method.getGenericReturnType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) method
                    .getGenericReturnType();
            Type objectType = getRawType(
                    parameterizedType.getActualTypeArguments()[0]);
            returnTypeName = objectType.getTypeName();
        }
        return returnTypeName;
    }

    public <E> E newInstance(Class<E> type, Juorm juorm) {
        return newInstance(type, juorm, true);
    }

    @SuppressWarnings("unchecked")
    public <E> E newInstance(Class<E> type, Juorm juorm, boolean cache) {
        E e = null;
        if (cache) {
            e = (E) typeInstances.get(type);
            if (e == null) {
                e = instance(type, juorm);
                typeInstances.put(type, e);
            }
            return e;
        } else {
            return instance(type, juorm);
        }
    }

    @SuppressWarnings("unchecked")
    public <E> E instance(Class<E> type, Juorm juorm) {
        try {
            return (E) ClassUtils.forName(create(type))
                    .getConstructor(Juorm.class).newInstance(juorm);
        } catch (Exception e) {
            throw new JuormException(e);
        }
    }

    private String getNamespace(Class<?> type) {
        TplExecution tplExecution = type.getAnnotation(TplExecution.class);
        if (tplExecution != null
                && LangUtils.isNotEmpty(tplExecution.namesapce())) {
            return tplExecution.namesapce();
        } else {
            return type.getSimpleName();
        }
    }

    private String getNamespace(Method method, String namespace) {
        TplExecution tplExecution = method.getAnnotation(TplExecution.class);
        if (tplExecution != null
                && LangUtils.isNotEmpty(tplExecution.namesapce())) {
            return tplExecution.namesapce();
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

    private Type getRawType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return parameterizedType.getRawType();
        } else {
            return type;
        }
    }
}
