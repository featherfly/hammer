package cn.featherfly.hammer.tpl.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.ParameterNode;
import org.objenesis.instantiator.util.DefineClassHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.asm.Asm;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.exception.ReflectException;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.GenericType;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.annotation.ParamType;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.ExecutionType;

/**
 * TplMapperFactory.
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactory extends ClassLoader implements Opcodes {

    /** The Constant HAMMER_FIELD_NAME. */
    public static final String HAMMER_FIELD_NAME = "hammer";

    /** The Constant CLASS_NAME_SUFFIX. */
    public static final String CLASS_NAME_SUFFIX = "$ImplByHammer";

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ClassLoader classLoader;

    private Set<Class<?>> types = new HashSet<>();

    private static final TplDynamicExecutorFactory INSTANCE = new TplDynamicExecutorFactory();

    private Map<Class<?>, Object> typeInstances = new HashMap<>();

    private final Method putChainMethod;

    private final Method executeMethod;

    private final String executeMethodDescriptor;

    private final Method paginationTypeMethod;

    private final String paginationTypeMethodDescriptor;

    private final Method paginationTypeLimitMethod;

    private final String paginationTypeLimitMethodDescriptor;

    private final Method paginationMapMethod;

    private final String paginationMapMethodDescriptor;

    private final Method paginationMapLimitMethod;

    private final String paginationMapLimitMethodDescriptor;

    private final Method paginationTuple2Method;

    private final String paginationTuple2MethodDescriptor;

    private final Method paginationTuple2LimitMethod;

    private final String paginationTuple2LimitMethodDescriptor;

    private final Method paginationTuple3Method;

    private final String paginationTuple3MethodDescriptor;

    private final Method paginationTuple3LimitMethod;

    private final String paginationTuple3LimitMethodDescriptor;

    private final Method paginationTuple4Method;

    private final String paginationTuple4MethodDescriptor;

    private final Method paginationTuple4LimitMethod;

    private final String paginationTuple4LimitMethodDescriptor;

    private final Method paginationTuple5Method;

    private final String paginationTuple5MethodDescriptor;

    private final Method paginationTuple5LimitMethod;

    private final String paginationTuple5LimitMethodDescriptor;

    private final Method paginationTuple6Method;

    private final String paginationTuple6MethodDescriptor;

    private final Method paginationTuple6LimitMethod;

    private final String paginationTuple6LimitMethodDescriptor;

    private final Method listTypeMethod;

    private final String listTypeMethodDescriptor;

    private final Method listTypePageMethod;

    private final String listTypePageMethodDescriptor;

    private final Method listTypeLimitMethod;

    private final String listTypeLimitMethodDescriptor;

    private final Method listTuple2Method;

    private final String listTuple2MethodDescriptor;

    private final Method listTuple2LimitMethod;

    private final String listTuple2LimitMethodDescriptor;

    private final Method listTuple2PageMethod;

    private final String listTuple2PageMethodDescriptor;

    private final Method listTuple3Method;

    private final String listTuple3MethodDescriptor;

    private final Method listTuple3LimitMethod;

    private final String listTuple3LimitMethodDescriptor;

    private final Method listTuple3PageMethod;

    private final String listTuple3PageMethodDescriptor;

    private final Method listTuple4Method;

    private final String listTuple4MethodDescriptor;

    private final Method listTuple4LimitMethod;

    private final String listTuple4LimitMethodDescriptor;

    private final Method listTuple4PageMethod;

    private final String listTuple4PageMethodDescriptor;

    private final Method listTuple5Method;

    private final String listTuple5MethodDescriptor;

    private final Method listTuple5LimitMethod;

    private final String listTuple5LimitMethodDescriptor;

    private final Method listTuple5PageMethod;

    private final String listTuple5PageMethodDescriptor;

    private final Method listTuple6Method;

    private final String listTuple6MethodDescriptor;

    private final Method listTuple6LimitMethod;

    private final String listTuple6LimitMethodDescriptor;

    private final Method listTuple6PageMethod;

    private final String listTuple6PageMethodDescriptor;

    private final Method listMapMethod;

    private final String listMapMethodDescriptor;

    private final Method listMapPageMethod;

    private final String listMapPageMethodDescriptor;

    private final Method listMapLimitMethod;

    private final String listMapLimitMethodDescriptor;

    private final Method singleTypeMethod;

    private final String singleTypeMethodDescriptor;

    private final Method singleMapMethod;

    private final String singleMapMethodDescriptor;

    private final Method singleTuple2Method;

    private final String singleTuple2MethodDescriptor;

    private final Method singleTuple3Method;

    private final String singleTuple3MethodDescriptor;

    private final Method singleTuple4Method;

    private final String singleTuple4MethodDescriptor;

    private final Method singleTuple5Method;

    private final String singleTuple5MethodDescriptor;

    private final Method singleTuple6Method;

    private final String singleTuple6MethodDescriptor;

    private final Method stringMethod;

    private final String stringMethodDescriptor;

    private final Method numberMethod;

    private final String numberMethodDescriptor;

    private final Method intValueMethod;

    private final String intValueMethodDescriptor;

    private final Method longValueMethod;

    private final String longValueMethodDescriptor;

    private final Method doubleValueMethod;

    private final String doubleValueMethodDescriptor;

    private final String hammerDescriptor;

    private final String hammerName;

    private final String paramName;

    private final String paramChainName;

    private final String constructorDescriptor;

    /**
     */
    private TplDynamicExecutorFactory() {
        super();
        try {
            putChainMethod = ChainMap.class.getMethod("putChain", Object.class, Object.class);

            executeMethod = Hammer.class.getMethod("execute", TplExecuteId.class, Map.class);
            executeMethodDescriptor = Type.getMethodDescriptor(executeMethod);

            listTypeMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Map.class);
            listTypeMethodDescriptor = Type.getMethodDescriptor(listTypeMethod);

            listTypePageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Map.class, Page.class);
            listTypePageMethodDescriptor = Type.getMethodDescriptor(listTypePageMethod);

            listTypeLimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Map.class, int.class,
                    int.class);
            listTypeLimitMethodDescriptor = Type.getMethodDescriptor(listTypeLimitMethod);

            listTuple2Method = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class, Map.class);
            listTuple2MethodDescriptor = Type.getMethodDescriptor(listTuple2Method);

            listTuple2PageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Map.class, Page.class);
            listTuple2PageMethodDescriptor = Type.getMethodDescriptor(listTuple2PageMethod);

            listTuple2LimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Map.class, int.class, int.class);
            listTuple2LimitMethodDescriptor = Type.getMethodDescriptor(listTuple2LimitMethod);

            listTuple3Method = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class, Class.class,
                    Map.class);
            listTuple3MethodDescriptor = Type.getMethodDescriptor(listTuple3Method);

            listTuple3PageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Map.class, Page.class);
            listTuple3PageMethodDescriptor = Type.getMethodDescriptor(listTuple3PageMethod);

            listTuple3LimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Map.class, int.class, int.class);
            listTuple3LimitMethodDescriptor = Type.getMethodDescriptor(listTuple3LimitMethod);

            listTuple4Method = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class, Class.class,
                    Class.class, Map.class);
            listTuple4MethodDescriptor = Type.getMethodDescriptor(listTuple4Method);

            listTuple4PageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Map.class, Page.class);
            listTuple4PageMethodDescriptor = Type.getMethodDescriptor(listTuple4PageMethod);

            listTuple4LimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Map.class, int.class, int.class);
            listTuple4LimitMethodDescriptor = Type.getMethodDescriptor(listTuple4LimitMethod);

            listTuple5Method = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class, Class.class,
                    Class.class, Class.class, Map.class);
            listTuple5MethodDescriptor = Type.getMethodDescriptor(listTuple5Method);

            listTuple5PageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class, Page.class);
            listTuple5PageMethodDescriptor = Type.getMethodDescriptor(listTuple5PageMethod);

            listTuple5LimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            listTuple5LimitMethodDescriptor = Type.getMethodDescriptor(listTuple5LimitMethod);

            listTuple6Method = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class);
            listTuple6MethodDescriptor = Type.getMethodDescriptor(listTuple5Method);

            listTuple6PageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Map.class, Page.class);
            listTuple6PageMethodDescriptor = Type.getMethodDescriptor(listTuple5PageMethod);

            listTuple6LimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            listTuple6LimitMethodDescriptor = Type.getMethodDescriptor(listTuple5LimitMethod);

            listMapMethod = Hammer.class.getMethod("list", TplExecuteId.class, Map.class);
            listMapMethodDescriptor = Type.getMethodDescriptor(listMapMethod);

            listMapPageMethod = Hammer.class.getMethod("list", TplExecuteId.class, Map.class, Page.class);
            listMapPageMethodDescriptor = Type.getMethodDescriptor(listMapPageMethod);

            listMapLimitMethod = Hammer.class.getMethod("list", TplExecuteId.class, Map.class, int.class, int.class);
            listMapLimitMethodDescriptor = Type.getMethodDescriptor(listMapLimitMethod);

            paginationTypeMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Map.class,
                    Page.class);
            paginationTypeMethodDescriptor = Type.getMethodDescriptor(paginationTypeMethod);
            paginationTypeLimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Map.class,
                    int.class, int.class);
            paginationTypeLimitMethodDescriptor = Type.getMethodDescriptor(paginationTypeLimitMethod);

            paginationMapMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Map.class, Page.class);
            paginationMapMethodDescriptor = Type.getMethodDescriptor(paginationMapMethod);

            paginationMapLimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Map.class, int.class,
                    int.class);
            paginationMapLimitMethodDescriptor = Type.getMethodDescriptor(paginationMapLimitMethod);

            paginationTuple2Method = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Class.class,
                    Map.class, Page.class);
            paginationTuple2MethodDescriptor = Type.getMethodDescriptor(paginationTuple2Method);
            paginationTuple2LimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class,
                    Class.class, Map.class, int.class, int.class);
            paginationTuple2LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple2LimitMethod);

            paginationTuple3Method = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Map.class, Page.class);
            paginationTuple3MethodDescriptor = Type.getMethodDescriptor(paginationTuple3Method);
            paginationTuple3LimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class,
                    Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple3LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple3LimitMethod);

            paginationTuple4Method = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Map.class, Page.class);
            paginationTuple4MethodDescriptor = Type.getMethodDescriptor(paginationTuple4Method);
            paginationTuple4LimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple4LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple4LimitMethod);

            paginationTuple5Method = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class, Page.class);
            paginationTuple5MethodDescriptor = Type.getMethodDescriptor(paginationTuple5Method);
            paginationTuple5LimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple5LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple5LimitMethod);

            paginationTuple6Method = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Map.class, Page.class);
            paginationTuple6MethodDescriptor = Type.getMethodDescriptor(paginationTuple6Method);
            paginationTuple6LimitMethod = Hammer.class.getMethod("pagination", TplExecuteId.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple6LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple6LimitMethod);

            singleTypeMethod = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Map.class);
            singleTypeMethodDescriptor = Type.getMethodDescriptor(singleTypeMethod);

            singleTuple2Method = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Class.class,
                    Map.class);
            singleTuple2MethodDescriptor = Type.getMethodDescriptor(singleTuple2Method);

            singleTuple3Method = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Map.class);
            singleTuple3MethodDescriptor = Type.getMethodDescriptor(singleTuple3Method);

            singleTuple4Method = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Map.class);
            singleTuple4MethodDescriptor = Type.getMethodDescriptor(singleTuple4Method);

            singleTuple5Method = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Map.class);
            singleTuple5MethodDescriptor = Type.getMethodDescriptor(singleTuple5Method);

            singleTuple6Method = Hammer.class.getMethod("single", TplExecuteId.class, Class.class, Class.class,
                    Class.class, Class.class, Class.class, Class.class, Map.class);
            singleTuple6MethodDescriptor = Type.getMethodDescriptor(singleTuple5Method);

            singleMapMethod = Hammer.class.getMethod("single", TplExecuteId.class, Map.class);
            singleMapMethodDescriptor = Type.getMethodDescriptor(singleMapMethod);

            stringMethod = Hammer.class.getMethod("string", TplExecuteId.class, Map.class);
            stringMethodDescriptor = Type.getMethodDescriptor(stringMethod);

            numberMethod = Hammer.class.getMethod("number", TplExecuteId.class, Class.class, Map.class);
            numberMethodDescriptor = Type.getMethodDescriptor(numberMethod);

            intValueMethod = Hammer.class.getMethod("intValue", TplExecuteId.class, Map.class);
            intValueMethodDescriptor = Type.getMethodDescriptor(intValueMethod);

            longValueMethod = Hammer.class.getMethod("longValue", TplExecuteId.class, Map.class);
            longValueMethodDescriptor = Type.getMethodDescriptor(longValueMethod);

            doubleValueMethod = Hammer.class.getMethod("doubleValue", TplExecuteId.class, Map.class);
            doubleValueMethodDescriptor = Type.getMethodDescriptor(doubleValueMethod);

            hammerDescriptor = Type.getDescriptor(Hammer.class);
            hammerName = Type.getInternalName(Hammer.class);
            paramName = Type.getInternalName(ChainMapImpl.class);
            paramChainName = Type.getInternalName(ChainMap.class);

            constructorDescriptor = Asm.getConstructorDescriptor(Hammer.class);

        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /**
     * get DynamicTplMapperFactory Instance .
     *
     * @return DynamicTplMapperFactory
     */
    public static TplDynamicExecutorFactory getInstance() {
        return INSTANCE;
    }

    /**
     * create mapper interface implemented class.
     *
     * @param type configuration interface class
     * @return implemented class name
     * @throws IOException           Signals that an I/O exception has occurred.
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException     the security exception
     */
    public String create(Class<?> type) throws IOException, NoSuchMethodException, SecurityException {
        return create(type, this.getClass().getClassLoader());
    }

    /**
     * create mapper interface implemented class.
     *
     * @param type        configuration interface class
     * @param classLoader the class loader
     * @return implemented class name
     * @throws IOException           Signals that an I/O exception has occurred.
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException     the security exception
     */
    public String create(Class<?> type, ClassLoader classLoader)
            throws IOException, NoSuchMethodException, SecurityException {
        if (classLoader == null) {
            classLoader = this.getClass().getClassLoader();
        }
        if (this.classLoader == null) {
            // 第一次加载
            this.classLoader = classLoader;
        }
        if (this.classLoader != classLoader) {
            // 表示使用的classLoader没了，使用新的classLoader重新加载，一般出现在热部署时，如springboot-dev-tool的RestartClassLoader
            clear();
            this.classLoader = classLoader;
        }
        //        ClassReader classReader = new ClassReader(type.getName());
        ClassReader classReader;
        try (InputStream is = classLoader.getResourceAsStream(type.getName().replace('.', '/') + ".class")) {
            classReader = new ClassReader(is);
        }
        ClassWriter cw = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        String implClassName = type.getName() + CLASS_NAME_SUFFIX;
        String implClassByteCodeName = Asm.getName(implClassName);

        Class<?> parentHammer = null;
        if (!types.contains(type)) {
            String globalNamespace = getNamespace(type);

            ClassNode cn = new ClassNode();
            cn.version = V1_8;
            cn.access = ACC_PUBLIC;
            cn.name = implClassByteCodeName;
            cn.interfaces.add(Asm.getName(type));

            if (ClassUtils.isParent(GenericHammer.class, type)
                    || ClassUtils.isParent(GenericHammerSupport.class, type)) {
                if (ClassUtils.isParent(GenericHammer.class, type)) {
                    parentHammer = GenericHammer.class;
                    cn.superName = Type.getInternalName(BasedTplGenericHammer.class);
                } else {
                    parentHammer = GenericHammerSupport.class;
                    cn.superName = Type.getInternalName(BasedGenericMapper.class);
                }

                String typeName = null;
                Class<?> genericType = null;
                Class<?> idType = null;

                for (java.lang.reflect.Type implType : type.getGenericInterfaces()) {
                    ParameterizedType parameterizedType = (ParameterizedType) implType;
                    if (parameterizedType.getRawType() == GenericHammer.class
                            || parameterizedType.getRawType() == GenericHammerSupport.class) {
                        typeName = parameterizedType.getActualTypeArguments()[0].getTypeName();
                        genericType = ClassUtils.forName(typeName);
                        idType = ClassUtils.forName(parameterizedType.getActualTypeArguments()[1].getTypeName());
                        break;
                    }
                }
                //                parentHammer = GenericHammer.class;
                //                cn.superName = Type.getInternalName(BasedTplGenericHammer.class);
                SignatureWriter signature = new SignatureWriter();
                SignatureVisitor superVisitor = signature.visitSuperclass();
                superVisitor.visitClassType(cn.superName);
                SignatureVisitor typeVisitor = superVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF);
                typeVisitor.visitClassType(Type.getInternalName(genericType));
                typeVisitor.visitEnd();
                SignatureVisitor idVisitor = superVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF);
                idVisitor.visitClassType(Type.getInternalName(idType));
                idVisitor.visitEnd();
                superVisitor.visitEnd();

                cn.signature = signature.toString();

                MethodNode constructor = new MethodNode(ACC_PUBLIC, Asm.CONSTRUCT_METHOD, constructorDescriptor, null,
                        null);
                constructor.visitVarInsn(ALOAD, 0);
                constructor.visitVarInsn(ALOAD, 1);
                constructor.visitLdcInsn(Type.getType(genericType));
                constructor.visitMethodInsn(INVOKESPECIAL, cn.superName, Asm.CONSTRUCT_METHOD,
                        Asm.getConstructorDescriptor(Hammer.class, Class.class), false);
                constructor.visitInsn(RETURN);
                constructor.visitMaxs(1, 1);
                constructor.visitEnd();
                cn.methods.add(constructor);
            } else {
                if (ClassUtils.isParent(Hammer.class, type)) {
                    parentHammer = Hammer.class;
                    cn.superName = Type.getInternalName(BasedTplHammer.class);
                } else { // HammerSupport
                    parentHammer = BasedMapper.class;
                    cn.superName = Type.getInternalName(BasedMapper.class);
                }
                MethodNode constructor = new MethodNode(ASM9, ACC_PUBLIC, Asm.CONSTRUCT_METHOD, constructorDescriptor,
                        null, null);
                constructor.visitVarInsn(ALOAD, 0);
                constructor.visitVarInsn(ALOAD, 1);
                constructor.visitMethodInsn(INVOKESPECIAL, cn.superName, Asm.CONSTRUCT_METHOD, constructorDescriptor,
                        false);
                constructor.visitInsn(RETURN);
                constructor.visitMaxs(1, 1);
                constructor.visitEnd();
                cn.methods.add(constructor);
            }

            addImplMethods(type, globalNamespace, cn, parentHammer);
            cn.accept(cw);
            byte[] code = cw.toByteArray();
            // 定义类
            final ClassLoader cl = classLoader;
            ClassLoaderUtils.defineClass(cl, implClassName, code, type.getProtectionDomain(), () -> DefineClassHelper
                    .defineClass(implClassName, code, 0, code.length, type, cl, type.getProtectionDomain()));
            types.add(type);
        }
        return implClassName;
    }

    private void clear() {
        types.clear();
        typeInstances.clear();
    }

    private void addImplMethods(Class<?> type, String globalNamespace, ClassNode classNode, Class<?> parentHammer)
            throws NoSuchMethodException, SecurityException {
        Map<String,
                java.lang.reflect.Type> genericTypes = ClassUtils.getInterfaceGenericTypeMap(type, GenericHammer.class);
        for (Method method : type.getDeclaredMethods()) {
            if (method.isDefault()) {
                continue;
            }
            // $deserializeLambda
            if (method.getName().startsWith("$")) {
                continue;
            }
            int localeSize = method.getParameters().length + 1;
            int stackSize = 1;

            // TODO 注解annotation要代理到实现类
            MethodNode methodNode = null;
            Method parentMethod = getMethodFromParent(parentHammer, method, genericTypes);
            if (parentMethod != null) {
                stackSize = 2;
                // TODO 未处理泛型
                String methodDescriptor = Type.getMethodDescriptor(method);
                String parentMethodDescriptor = Type.getMethodDescriptor(parentMethod);
                methodNode = new MethodNode(ACC_PUBLIC, method.getName(), methodDescriptor, null, null);
                setAnnotations(methodNode, method);
                methodNode.parameters = new ArrayList<>();
                methodNode.visitVarInsn(ALOAD, 0);
                int size = method.getParameters().length + 1;
                for (int i = 1; i < size; i++) {
                    methodNode.visitVarInsn(ALOAD, i);
                    ParameterNode parameterNode = new ParameterNode(method.getParameters()[i - 1].getName(),
                            Opcodes.ACC_MANDATED);
                    methodNode.parameters.add(parameterNode);
                }
                methodNode.visitMethodInsn(INVOKESPECIAL, classNode.superName, parentMethod.getName(),
                        parentMethodDescriptor, false);
                if (method.getReturnType().isPrimitive()) {
                    // TODO 基本类型是否需要强制类型转换
                    if (method.getReturnType() == Integer.TYPE) {
                        methodNode.visitInsn(IRETURN);
                    } else if (method.getReturnType() == Byte.TYPE) {
                        methodNode.visitInsn(IRETURN);
                    } else if (method.getReturnType() == Short.TYPE) {
                        methodNode.visitInsn(IRETURN);
                    } else if (method.getReturnType() == Character.TYPE) {
                        methodNode.visitInsn(IRETURN);
                    } else if (method.getReturnType() == Boolean.TYPE) {
                        methodNode.visitInsn(IRETURN);
                    } else if (method.getReturnType() == Long.TYPE) {
                        methodNode.visitInsn(LRETURN);
                    } else if (method.getReturnType() == Double.TYPE) {
                        methodNode.visitInsn(DRETURN);
                    } else if (method.getReturnType() == Float.TYPE) {
                        methodNode.visitInsn(FRETURN);
                    } else {
                        methodNode.visitInsn(RETURN);
                    }
                } else {
                    methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
                    methodNode.visitInsn(ARETURN);
                }
                methodNode.visitMaxs(stackSize, localeSize);
                methodNode.visitEnd();
            } else {
                String namespace = getNamespace(method, globalNamespace);
                String name = getName(method);

                // TODO 未处理泛型
                methodNode = new MethodNode(ACC_PUBLIC, method.getName(), Type.getMethodDescriptor(method), null, null);
                setAnnotations(methodNode, method);
                methodNode.parameters = new ArrayList<>();
                methodNode.visitVarInsn(ALOAD, 0);
                methodNode.visitFieldInsn(GETFIELD, classNode.name, HAMMER_FIELD_NAME, hammerDescriptor);
                ExecutionType tplType = getType(method);

                //                    String typeDescriptor = Type.getDescriptor(TplExecuteIdFileImpl.class);
                String executeIdType = Type.getInternalName(TplExecuteIdFileImpl.class);
                methodNode.visitTypeInsn(NEW, executeIdType);
                methodNode.visitInsn(DUP);
                methodNode.visitLdcInsn(name);
                methodNode.visitLdcInsn(namespace);
                methodNode.visitMethodInsn(INVOKESPECIAL, executeIdType, Asm.CONSTRUCT_METHOD,
                        Asm.getConstructorDescriptor(String.class, String.class), false);
                stackSize = 5;

                if (method.getReturnType() == void.class) {
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, executeMethod.getName(),
                            executeMethodDescriptor, true);
                    methodNode.visitInsn(POP);
                    methodNode.visitInsn(RETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else if (method.getReturnType() == Integer.TYPE
                        && (tplType == ExecutionType.AUTO || tplType == ExecutionType.EXECUTE)) {
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, executeMethod.getName(),
                            executeMethodDescriptor, true);
                    methodNode.visitInsn(IRETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else if (ClassUtils.isParent(List.class, method.getReturnType())) {
                    GenericType<?> elementType = ClassUtils.Methods.getReturnTypeGenericParameterType(type, method);
                    //                    String returnTypeName = getReturnTypeName(method);
                    //                    if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
                    if (ClassUtils.isParent(Map.class, elementType.getType())) {
                        ParamPosition position = setParams(methodNode, method);
                        if (position.limitParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listMapLimitMethod.getName(),
                                    listMapLimitMethodDescriptor, true);
                        } else if (position.pageParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listMapPageMethod.getName(),
                                    listMapPageMethodDescriptor, true);
                        } else {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listMapMethod.getName(),
                                    listMapMethodDescriptor, true);
                        }

                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else if (ClassUtils.isParent(Tuple.class, elementType.getType())) {
                        for (GenericType<?> gt : elementType.getGenericTypes()) {
                            methodNode.visitLdcInsn(Type.getType(gt.getType()));
                        }
                        ParamPosition position = setParams(methodNode, method, elementType.getGenericTypes().size());
                        if (position.commonParamNum > 0) {
                            stackSize++;
                        }
                        if (ClassUtils.isParent(Tuple2.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple2LimitMethod.getName(),
                                        listTuple2LimitMethodDescriptor, true);
                            } else if (position.pageParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple2PageMethod.getName(),
                                        listTuple2PageMethodDescriptor, true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple2Method.getName(),
                                        listTuple2MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple3.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple3LimitMethod.getName(),
                                        listTuple3LimitMethodDescriptor, true);
                            } else if (position.pageParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple3PageMethod.getName(),
                                        listTuple3PageMethodDescriptor, true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple3Method.getName(),
                                        listTuple3MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple4.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple4LimitMethod.getName(),
                                        listTuple4LimitMethodDescriptor, true);
                            } else if (position.pageParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple4PageMethod.getName(),
                                        listTuple4PageMethodDescriptor, true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple4Method.getName(),
                                        listTuple4MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple5.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple5LimitMethod.getName(),
                                        listTuple5LimitMethodDescriptor, true);
                            } else if (position.pageParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple5PageMethod.getName(),
                                        listTuple5PageMethodDescriptor, true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple5Method.getName(),
                                        listTuple5MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple6.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple6LimitMethod.getName(),
                                        listTuple6LimitMethodDescriptor, true);
                            } else if (position.pageParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple6PageMethod.getName(),
                                        listTuple6PageMethodDescriptor, true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTuple6Method.getName(),
                                        listTuple6MethodDescriptor, true);
                            }
                        } else {
                            throw new HammerException("only support Tuple2...Tuple6");
                        }
                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else {
                        methodNode.visitLdcInsn(Type.getType(elementType.getType()));
                        ParamPosition position = setParams(methodNode, method);
                        if (position.commonParamNum > 0) {
                            stackSize++;
                        }
                        if (position.limitParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTypeLimitMethod.getName(),
                                    listTypeLimitMethodDescriptor, true);
                        } else if (position.pageParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTypePageMethod.getName(),
                                    listTypePageMethodDescriptor, true);
                        } else {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, listTypeMethod.getName(),
                                    listTypeMethodDescriptor, true);
                        }
                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    }
                } else if (ClassUtils.isParent(PaginationResults.class, method.getReturnType())) {
                    GenericType<?> elementType = ClassUtils.Methods.getReturnTypeGenericParameterType(type, method);
                    //                    String returnTypeName = getReturnTypeName(method);
                    //                    if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
                    if (ClassUtils.isParent(Map.class, elementType.getType())) {
                        ParamPosition position = setParams(methodNode, method);
                        if (position.limitParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, paginationMapLimitMethod.getName(),
                                    paginationMapLimitMethodDescriptor, true);
                        } else {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, paginationMapMethod.getName(),
                                    paginationMapMethodDescriptor, true);
                        }
                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();

                    } else if (ClassUtils.isParent(Tuple.class, elementType.getType())) {
                        for (GenericType<?> gt : elementType.getGenericTypes()) {
                            methodNode.visitLdcInsn(Type.getType(gt.getType()));
                        }
                        ParamPosition position = setParams(methodNode, method, elementType.getGenericTypes().size());
                        if (position.commonParamNum > 0) {
                            stackSize++;
                        }
                        if (ClassUtils.isParent(Tuple2.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple2LimitMethod.getName(), paginationTuple2LimitMethodDescriptor,
                                        true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple2Method.getName(), paginationTuple2MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple3.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple3LimitMethod.getName(), paginationTuple3LimitMethodDescriptor,
                                        true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple3Method.getName(), paginationTuple3MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple4.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple4LimitMethod.getName(), paginationTuple4LimitMethodDescriptor,
                                        true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple4Method.getName(), paginationTuple4MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple5.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple5LimitMethod.getName(), paginationTuple5LimitMethodDescriptor,
                                        true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple5Method.getName(), paginationTuple5MethodDescriptor, true);
                            }
                        } else if (ClassUtils.isParent(Tuple6.class, elementType.getType())) {
                            if (position.limitParamPosition > 0) {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple6LimitMethod.getName(), paginationTuple6LimitMethodDescriptor,
                                        true);
                            } else {
                                methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName,
                                        paginationTuple6Method.getName(), paginationTuple6MethodDescriptor, true);
                            }
                        } else {
                            throw new HammerException("only support Tuple2...Tuple6");
                        }
                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else {
                        //                        methodNode.visitLdcInsn(Type.getType(ClassUtils.forName(returnTypeName)));
                        methodNode.visitLdcInsn(Type.getType(elementType.getType()));
                        ParamPosition position = setParams(methodNode, method);
                        if (position.commonParamNum > 0) {
                            stackSize++;
                        }
                        if (position.limitParamPosition > 0) {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, paginationTypeLimitMethod.getName(),
                                    paginationTypeLimitMethodDescriptor, true);
                        } else {
                            methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, paginationTypeMethod.getName(),
                                    paginationTypeMethodDescriptor, true);
                        }
                        methodNode.visitInsn(ARETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    }
                } else if (ClassUtils.isParent(Number.class, method.getReturnType())) {
                    if (method.getParameters().length > 0) {
                        stackSize++;
                    }
                    methodNode.visitLdcInsn(Type.getType(method.getReturnType()));
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, numberMethod.getName(),
                            numberMethodDescriptor, true);
                    methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
                    methodNode.visitInsn(ARETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else if (method.getReturnType().isPrimitive()) {
                    if (method.getReturnType() == Integer.TYPE) {
                        setParams(methodNode, method);
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, intValueMethod.getName(),
                                intValueMethodDescriptor, true);
                        methodNode.visitInsn(IRETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else if (method.getReturnType() == Long.TYPE) {
                        setParams(methodNode, method);
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, longValueMethod.getName(),
                                longValueMethodDescriptor, true);
                        methodNode.visitInsn(LRETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else if (method.getReturnType() == Double.TYPE) {
                        setParams(methodNode, method);
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, doubleValueMethod.getName(),
                                doubleValueMethodDescriptor, true);
                        methodNode.visitInsn(DRETURN);
                        methodNode.visitMaxs(stackSize, localeSize);
                        methodNode.visitEnd();
                    } else {
                        // TODO 使用exception code
                        throw new HammerException("unsupport query return type with primitive type "
                                + method.getReturnType() + ", you can use wrapper type instead");
                    }
                } else if (String.class == method.getReturnType()) {
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, stringMethod.getName(),
                            stringMethodDescriptor, true);
                    methodNode.visitInsn(ARETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else if (ClassUtils.isParent(Map.class, method.getReturnType())) {
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleMapMethod.getName(),
                            singleMapMethodDescriptor, true);
                    methodNode.visitInsn(ARETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else if (ClassUtils.isParent(Tuple.class, method.getReturnType())) {
                    if (method.getParameters().length > 0) {
                        stackSize++;
                    }
                    List<GenericType<?>> gts = ClassUtils.Methods.getReturnTypeGenericParameterTypes(type, method);
                    for (GenericType<?> gt : gts) {
                        methodNode.visitLdcInsn(Type.getType(gt.getType()));
                    }
                    setParams(methodNode, method, gts.size());
                    if (ClassUtils.isParent(Tuple2.class, method.getReturnType())) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTuple2Method.getName(),
                                singleTuple2MethodDescriptor, true);
                    } else if (ClassUtils.isParent(Tuple3.class, method.getReturnType())) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTuple3Method.getName(),
                                singleTuple3MethodDescriptor, true);
                    } else if (ClassUtils.isParent(Tuple4.class, method.getReturnType())) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTuple4Method.getName(),
                                singleTuple4MethodDescriptor, true);
                    } else if (ClassUtils.isParent(Tuple5.class, method.getReturnType())) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTuple5Method.getName(),
                                singleTuple5MethodDescriptor, true);
                    } else if (ClassUtils.isParent(Tuple6.class, method.getReturnType())) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTuple6Method.getName(),
                                singleTuple6MethodDescriptor, true);
                    } else {
                        throw new HammerException("only support Tuple2...Tuple6");
                    }
                    methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
                    methodNode.visitInsn(ARETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                } else {
                    if (method.getParameters().length > 0) {
                        stackSize++;
                    }
                    methodNode.visitLdcInsn(Type.getType(method.getReturnType()));
                    setParams(methodNode, method);
                    methodNode.visitMethodInsn(INVOKEINTERFACE, hammerName, singleTypeMethod.getName(),
                            singleTypeMethodDescriptor, true);
                    methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
                    methodNode.visitInsn(ARETURN);
                    methodNode.visitMaxs(stackSize, localeSize);
                    methodNode.visitEnd();
                }
                logger.debug("generate method {}", method.getName());
            }
            if (methodNode != null) {
                if (logger.isTraceEnabled()) {
                    StringBuilder javapString = new StringBuilder();
                    javapString.append(methodNode.access + " " + methodNode.name + methodNode.desc)
                            .append(Chars.NEW_LINE)
                            .append(Strings.format("stack={0},locales={1}", stackSize, localeSize))
                            .append(Chars.NEW_LINE);
                    if (methodNode.visibleAnnotations != null) {
                        for (AnnotationNode annotation : methodNode.visibleAnnotations) {

                            javapString.append(annotation.desc).append(Chars.NEW_LINE).append(Chars.TAB)
                                    .append(ArrayUtils.toString(annotation.values)).append(Chars.NEW_LINE);
                        }
                    }
                    for (AbstractInsnNode node : methodNode.instructions) {
                        javapString.append("  ").append(Asm.javapString(node)).append(Chars.NEW_LINE);
                    }
                    logger.trace(javapString.toString());
                }
                classNode.methods.add(methodNode);
            }
        }
    }

    private static class ParamPosition {
        int pageParamPosition = -1;
        int offsetParamPosition = -1;
        int limitParamPosition = -1;
        int commonParamNum = 0;

        /**
         */
        public ParamPosition() {
        }
    }

    private void setAnnotations(MethodNode methodNode, Method method) {
        Annotation[] annotations = method.getAnnotations();
        if (Lang.isNotEmpty(annotations)) {
            for (Annotation annotation : annotations) {
                AnnotationVisitor visitor = methodNode.visitAnnotation(Type.getDescriptor(annotation.annotationType()),
                        true);
                for (Method annotationMethod : annotation.annotationType().getDeclaredMethods()) {
                    Object value = ClassUtils.invokeMethod(annotation, annotationMethod);
                    if (value.getClass().isArray()) {
                        AnnotationVisitor as = visitor.visitArray(annotationMethod.getName());
                        for (int i = 0; i < Array.getLength(value); i++) {
                            Object a = Array.get(value, i);
                            as.visit(annotationMethod.getName(), a);
                        }
                    } else if (value.getClass().isEnum()) {
                        visitor.visitEnum(annotationMethod.getName(), Type.getDescriptor(value.getClass()),
                                ((Enum<?>) value).name());
                    } else {
                        visitor.visit(annotationMethod.getName(), value);
                    }
                }
                visitor.visitEnd();
            }
        }
    }

    private ParamPosition setParams(MethodNode methodNode, Method method)
            throws NoSuchMethodException, SecurityException {
        return setParams(methodNode, method, 1);
    }

    private ParamPosition setParams(MethodNode methodNode, Method method, int commonParamIndex)
            throws NoSuchMethodException, SecurityException {
        ParamPosition position = new ParamPosition();

        methodNode.visitTypeInsn(NEW, paramName);
        methodNode.visitInsn(DUP);
        methodNode.visitMethodInsn(INVOKESPECIAL, paramName, Asm.CONSTRUCT_METHOD, Asm.NONE_PARAMETER_DESCRIPTOR,
                false);
        for (int paramIndex = 0; paramIndex < method.getParameters().length; paramIndex++) {
            Parameter parameter = method.getParameters()[paramIndex];
            ParamType paramType = getParamType(parameter);
            methodNode.parameters.add(new ParameterNode(parameter.getName(), Opcodes.ACC_MANDATED));

            switch (paramType) {
                case COMMON:
                    methodNode.visitLdcInsn(getParamName(parameter, paramIndex));
                    methodNode.visitVarInsn(Asm.getLoadCode(parameter.getType()), paramIndex + 1);
                    if (parameter.getType().isPrimitive()) {
                        methodNode.visitMethodInsn(INVOKESTATIC, Asm.getPrimitiveWrapperName(parameter.getType()),
                                Asm.PRIMITIVE_WRAPPER_METHOD,
                                Asm.getPrimitiveWrapperMethodDescriptor(parameter.getType()), false);
                    }
                    if (commonParamIndex == 1) {
                        methodNode.visitMethodInsn(INVOKEVIRTUAL, paramName, putChainMethod.getName(),
                                Type.getMethodDescriptor(putChainMethod), false);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, paramChainName, putChainMethod.getName(),
                                Type.getMethodDescriptor(putChainMethod), true);
                    }
                    commonParamIndex++;
                    break;
                case PAGE:
                    position.pageParamPosition = paramIndex + 1;
                    break;
                case PAGE_OFFSET:
                    position.offsetParamPosition = paramIndex + 1;
                    break;
                case PAGE_LIMIT:
                    position.limitParamPosition = paramIndex + 1;
                    break;
            }
        }
        position.commonParamNum = commonParamIndex - 1;

        if (position.pageParamPosition > 0) {
            methodNode.visitVarInsn(ALOAD, position.pageParamPosition);
        } else if (position.limitParamPosition > 0) {
            if (position.offsetParamPosition > 0) {
                methodNode.visitVarInsn(ILOAD, position.offsetParamPosition);
                methodNode.visitVarInsn(ILOAD, position.limitParamPosition);
            } else {
                methodNode.visitInsn(ICONST_0);
                methodNode.visitVarInsn(ILOAD, position.limitParamPosition);
            }
        }
        return position;
    }

    private Method getMethodFromParent(Class<?> parentHammer, Method method,
            Map<String, java.lang.reflect.Type> genericTypes) {
        // FIXME 这里还没有处理泛型参数问题
        if (parentHammer == null) {
            return null;
        }
        if (ClassUtils.isParent(GenericHammer.class, parentHammer)) {
            for (Method m : parentHammer.getMethods()) {
                if (isOverwrite(m, method, genericTypes)) {
                    return m;
                }
            }
            return null;
        } else {
            try {
                return parentHammer.getMethod(method.getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
                return null;
            }
        }
    }

    private boolean isOverwrite(Method method, Method overwriteMethod,
            Map<String, java.lang.reflect.Type> genericTypes) {
        if (method.getName().equals(overwriteMethod.getName())
                && method.getParameterCount() == overwriteMethod.getParameterCount()) {
            if (method.getParameterTypes().equals(overwriteMethod.getParameterTypes())) {
                return true;
            } else {
                return isSameParameter(method, overwriteMethod, genericTypes);
            }
        }
        return false;
    }

    private boolean isSameParameter(Method method, Method overwriteMethod,
            Map<String, java.lang.reflect.Type> genericTypes) {
        Class<?>[] types = new Class[method.getParameterCount()];
        int i = 0;
        for (java.lang.reflect.Type type : method.getGenericParameterTypes()) {
            if (type instanceof Class) {
                types[i] = (Class<?>) type;
            } else {
                java.lang.reflect.Type genericType = genericTypes.get(type.getTypeName());
                if (genericType == null) {
                    return false;
                }
                types[i] = (Class<?>) genericType;
            }
        }
        return true;
    }

    /**
     * always return a new instance.
     *
     * @param <E>    generic type
     * @param type   mapper interface type
     * @param hammer hammer instance
     * @return new instance
     */
    @SuppressWarnings("unchecked")
    public <E> E newInstance(Class<E> type, Hammer hammer) {
        try {
            return (E) ClassUtils.forName(create(type)).getConstructor(Hammer.class).newInstance(hammer);
        } catch (Exception e) {
            throw new HammerException(e);
        }
    }

    /**
     * return a singleton instance, every type only new one instance.
     *
     * @param <E>    generic type
     * @param type   mapper interface type
     * @param hammer hammer instance
     * @return instance
     */
    @SuppressWarnings("unchecked")
    public <E> E instance(Class<E> type, Hammer hammer) {
        E e = null;
        e = (E) typeInstances.get(type);
        if (e == null) {
            e = newInstance(type, hammer);
            typeInstances.put(type, e);
        }
        return e;
    }

    //    private String getReturnTypeName(Method method) {
    //        if (method.getGenericReturnType() instanceof ParameterizedType) {
    //            ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
    //            java.lang.reflect.Type objectType = ClassUtils.getRawType(parameterizedType.getActualTypeArguments()[0]);
    //            return objectType.getTypeName();
    //        }
    //        return method.getName();
    //    }

    private String getNamespace(Class<?> type) {
        Mapper mapper = type.getAnnotation(Mapper.class);
        if (mapper != null && Lang.isNotEmpty(mapper.namespace())) {
            return mapper.namespace();
        } else {
            return type.getSimpleName();
        }
    }

    private String getNamespace(Method method, String namespace) {
        Template tplExecution = method.getAnnotation(Template.class);
        if (tplExecution != null && Lang.isNotEmpty(tplExecution.namespace())) {
            return tplExecution.namespace();
        } else {
            return namespace;
        }
    }

    private ExecutionType getType(Method method) {
        Template template = method.getAnnotation(Template.class);
        if (template != null && Lang.isNotEmpty(template.type())) {
            return template.type();
        } else {
            return ExecutionType.AUTO;
        }
    }

    private String getName(Method method) {
        Template tplExecution = method.getAnnotation(Template.class);
        if (tplExecution != null && Lang.isNotEmpty(tplExecution.name())) {
            return tplExecution.name();
        } else {
            return method.getName();
        }
    }

    private String getParamName(Parameter parameter, int paramIndex) {
        Param tplParam = parameter.getAnnotation(Param.class);
        if (tplParam != null && Lang.isNotEmpty(tplParam.name())) {
            return tplParam.name();
        } else if (tplParam != null && Lang.isNotEmpty(tplParam.value())) {
            return tplParam.value();
        } else {
            // 在没有使用-parameter编译时，Asm也不能获取到接口和抽象类的方法参数名称
            //            try {
            //                String[] names = Asm.getParamNames(parameter.getDeclaringExecutable());
            //                if (names != null && names.length > paramIndex) {
            //                    return names[paramIndex];
            //                }
            //            } catch (Exception e) {
            //            }
            return parameter.getName();
        }
    }

    private ParamType getParamType(Parameter parameter) {
        Param tplParam = parameter.getAnnotation(Param.class);
        if (tplParam != null) {
            return tplParam.type();
        } else if (ClassUtils.isParent(Page.class, parameter.getType())) {
            return ParamType.PAGE;
        } else {
            return ParamType.COMMON;
        }
    }
}
