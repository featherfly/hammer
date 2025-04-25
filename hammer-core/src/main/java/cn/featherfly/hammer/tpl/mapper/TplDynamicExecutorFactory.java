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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.ParameterNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.ReflectUtils;

import cn.featherfly.common.asm.Asm;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.exception.ReflectException;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.GenericType;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.annotation.ParamType;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.ValidatorConfig;
import cn.featherfly.hammer.tpl.ExecutionType;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * TplMapperFactory.
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactory implements Opcodes {

    private enum TplDynamicExecutorFactoryInstance {

        INSTANCE(new TplDynamicExecutorFactory());

        private TplDynamicExecutorFactory factory;

        TplDynamicExecutorFactoryInstance(TplDynamicExecutorFactory factory) {
            this.factory = factory;
        }
    }

    /** The Constant HAMMER_FIELD_NAME. */
    public static final String HAMMER_FIELD_NAME = "hammer";

    /** The Constant TPLEXECUTOR_FIELD_NAME. */
    public static final String TPLEXECUTOR_FIELD_NAME = "tplExecutor";

    /** The Constant TPLID_PARSER_NAME. */
    public static final String TPLID_PARSER_NAME = "parser";

    /** The Constant CLASS_NAME_SUFFIX. */
    public static final String CLASS_NAME_SUFFIX = "$ImplByHammer";

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ClassLoader classLoader;

    private Set<Class<?>> types = new HashSet<>();

    private Map<Class<?>, Object> typeInstances = new HashMap<>();

    //    private final Method fileExecuteIdMethod;
    //
    //    private final String fileExecuteIdDescriptor;
    //
    //    private final Method mapperExecuteId;
    //
    //    private final String mapperExecuteIdDescriptor;

    // ----------------------------------------------------------------------------------------------------------------

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

    //    private final String hammerDescriptor;

    //    private final String hammerName;

    private final String tplExecutorDescriptor;

    private final String tplExecuteIdParserDescriptor;

    private final String tplExecutorName;

    private final String paramName;

    private final String paramChainName;

    private final String constructorDescriptor;

    /**
     */
    private TplDynamicExecutorFactory() {
        super();
        try {
            //            fileExecuteIdMethod = AbstractBasedHammer.class.getDeclaredMethod("fileExecuteId", String.class,
            //                    String.class);
            //            fileExecuteIdDescriptor = Type.getMethodDescriptor(fileExecuteIdMethod);
            //            mapperExecuteId = AbstractBasedHammer.class.getDeclaredMethod("mapperExecuteId", String.class,
            //                    String.class);
            //            mapperExecuteIdDescriptor = Type.getMethodDescriptor(mapperExecuteId);

            tplExecuteIdParserDescriptor = Type.getDescriptor(TplExecuteIdParser.class);

            putChainMethod = ChainMap.class.getMethod("putChain", Object.class, Object.class);

            executeMethod = TplExecutor.class.getMethod("execute", Object.class, Map.class);
            executeMethodDescriptor = Type.getMethodDescriptor(executeMethod);

            listTypeMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Map.class);
            listTypeMethodDescriptor = Type.getMethodDescriptor(listTypeMethod);

            listTypePageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Map.class, Page.class);
            listTypePageMethodDescriptor = Type.getMethodDescriptor(listTypePageMethod);

            listTypeLimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Map.class, int.class,
                int.class);
            listTypeLimitMethodDescriptor = Type.getMethodDescriptor(listTypeLimitMethod);

            listTuple2Method = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class, Map.class);
            listTuple2MethodDescriptor = Type.getMethodDescriptor(listTuple2Method);

            listTuple2PageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Map.class, Page.class);
            listTuple2PageMethodDescriptor = Type.getMethodDescriptor(listTuple2PageMethod);

            listTuple2LimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Map.class, int.class, int.class);
            listTuple2LimitMethodDescriptor = Type.getMethodDescriptor(listTuple2LimitMethod);

            listTuple3Method = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class, Class.class,
                Map.class);
            listTuple3MethodDescriptor = Type.getMethodDescriptor(listTuple3Method);

            listTuple3PageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Map.class, Page.class);
            listTuple3PageMethodDescriptor = Type.getMethodDescriptor(listTuple3PageMethod);

            listTuple3LimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Map.class, int.class, int.class);
            listTuple3LimitMethodDescriptor = Type.getMethodDescriptor(listTuple3LimitMethod);

            listTuple4Method = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class, Class.class,
                Class.class, Map.class);
            listTuple4MethodDescriptor = Type.getMethodDescriptor(listTuple4Method);

            listTuple4PageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Map.class, Page.class);
            listTuple4PageMethodDescriptor = Type.getMethodDescriptor(listTuple4PageMethod);

            listTuple4LimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Map.class, int.class, int.class);
            listTuple4LimitMethodDescriptor = Type.getMethodDescriptor(listTuple4LimitMethod);

            listTuple5Method = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class, Class.class,
                Class.class, Class.class, Map.class);
            listTuple5MethodDescriptor = Type.getMethodDescriptor(listTuple5Method);

            listTuple5PageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Map.class, Page.class);
            listTuple5PageMethodDescriptor = Type.getMethodDescriptor(listTuple5PageMethod);

            listTuple5LimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            listTuple5LimitMethodDescriptor = Type.getMethodDescriptor(listTuple5LimitMethod);

            listTuple6Method = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Map.class);
            listTuple6MethodDescriptor = Type.getMethodDescriptor(listTuple5Method);

            listTuple6PageMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Map.class, Page.class);
            listTuple6PageMethodDescriptor = Type.getMethodDescriptor(listTuple5PageMethod);

            listTuple6LimitMethod = TplExecutor.class.getMethod("list", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            listTuple6LimitMethodDescriptor = Type.getMethodDescriptor(listTuple5LimitMethod);

            listMapMethod = TplExecutor.class.getMethod("list", Object.class, Map.class);
            listMapMethodDescriptor = Type.getMethodDescriptor(listMapMethod);

            listMapPageMethod = TplExecutor.class.getMethod("list", Object.class, Map.class, Page.class);
            listMapPageMethodDescriptor = Type.getMethodDescriptor(listMapPageMethod);

            listMapLimitMethod = TplExecutor.class.getMethod("list", Object.class, Map.class, int.class, int.class);
            listMapLimitMethodDescriptor = Type.getMethodDescriptor(listMapLimitMethod);

            paginationTypeMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Map.class,
                Page.class);
            paginationTypeMethodDescriptor = Type.getMethodDescriptor(paginationTypeMethod);
            paginationTypeLimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Map.class,
                int.class, int.class);
            paginationTypeLimitMethodDescriptor = Type.getMethodDescriptor(paginationTypeLimitMethod);

            paginationMapMethod = TplExecutor.class.getMethod("pagination", Object.class, Map.class, Page.class);
            paginationMapMethodDescriptor = Type.getMethodDescriptor(paginationMapMethod);

            paginationMapLimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Map.class, int.class,
                int.class);
            paginationMapLimitMethodDescriptor = Type.getMethodDescriptor(paginationMapLimitMethod);

            paginationTuple2Method = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Class.class,
                Map.class, Page.class);
            paginationTuple2MethodDescriptor = Type.getMethodDescriptor(paginationTuple2Method);
            paginationTuple2LimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class,
                Class.class, Map.class, int.class, int.class);
            paginationTuple2LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple2LimitMethod);

            paginationTuple3Method = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Class.class,
                Class.class, Map.class, Page.class);
            paginationTuple3MethodDescriptor = Type.getMethodDescriptor(paginationTuple3Method);
            paginationTuple3LimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class,
                Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple3LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple3LimitMethod);

            paginationTuple4Method = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Class.class,
                Class.class, Class.class, Map.class, Page.class);
            paginationTuple4MethodDescriptor = Type.getMethodDescriptor(paginationTuple4Method);
            paginationTuple4LimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class,
                Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple4LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple4LimitMethod);

            paginationTuple5Method = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Map.class, Page.class);
            paginationTuple5MethodDescriptor = Type.getMethodDescriptor(paginationTuple5Method);
            paginationTuple5LimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple5LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple5LimitMethod);

            paginationTuple6Method = TplExecutor.class.getMethod("pagination", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Map.class, Page.class);
            paginationTuple6MethodDescriptor = Type.getMethodDescriptor(paginationTuple6Method);
            paginationTuple6LimitMethod = TplExecutor.class.getMethod("pagination", Object.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Class.class, Map.class, int.class, int.class);
            paginationTuple6LimitMethodDescriptor = Type.getMethodDescriptor(paginationTuple6LimitMethod);

            singleTypeMethod = TplExecutor.class.getMethod("single", Object.class, Class.class, Map.class);
            singleTypeMethodDescriptor = Type.getMethodDescriptor(singleTypeMethod);

            singleTuple2Method = TplExecutor.class.getMethod("single", Object.class, Class.class, Class.class,
                Map.class);
            singleTuple2MethodDescriptor = Type.getMethodDescriptor(singleTuple2Method);

            singleTuple3Method = TplExecutor.class.getMethod("single", Object.class, Class.class, Class.class,
                Class.class, Map.class);
            singleTuple3MethodDescriptor = Type.getMethodDescriptor(singleTuple3Method);

            singleTuple4Method = TplExecutor.class.getMethod("single", Object.class, Class.class, Class.class,
                Class.class, Class.class, Map.class);
            singleTuple4MethodDescriptor = Type.getMethodDescriptor(singleTuple4Method);

            singleTuple5Method = TplExecutor.class.getMethod("single", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Map.class);
            singleTuple5MethodDescriptor = Type.getMethodDescriptor(singleTuple5Method);

            singleTuple6Method = TplExecutor.class.getMethod("single", Object.class, Class.class, Class.class,
                Class.class, Class.class, Class.class, Class.class, Map.class);
            singleTuple6MethodDescriptor = Type.getMethodDescriptor(singleTuple5Method);

            singleMapMethod = TplExecutor.class.getMethod("single", Object.class, Map.class);
            singleMapMethodDescriptor = Type.getMethodDescriptor(singleMapMethod);

            stringMethod = TplExecutor.class.getMethod("string", Object.class, Map.class);
            stringMethodDescriptor = Type.getMethodDescriptor(stringMethod);

            numberMethod = TplExecutor.class.getMethod("number", Object.class, Class.class, Map.class);
            numberMethodDescriptor = Type.getMethodDescriptor(numberMethod);

            intValueMethod = TplExecutor.class.getMethod("intValue", Object.class, Map.class);
            intValueMethodDescriptor = Type.getMethodDescriptor(intValueMethod);

            longValueMethod = TplExecutor.class.getMethod("longValue", Object.class, Map.class);
            longValueMethodDescriptor = Type.getMethodDescriptor(longValueMethod);

            doubleValueMethod = TplExecutor.class.getMethod("doubleValue", Object.class, Map.class);
            doubleValueMethodDescriptor = Type.getMethodDescriptor(doubleValueMethod);

            //            hammerDescriptor = Type.getDescriptor(Hammer.class);
            //            hammerName = Type.getInternalName(Hammer.class);
            tplExecutorDescriptor = Type.getDescriptor(TplExecutor.class);
            tplExecutorName = Type.getInternalName(TplExecutor.class);
            paramName = Type.getInternalName(ChainMapImpl.class);
            paramChainName = Type.getInternalName(ChainMap.class);

            constructorDescriptor = Asm.getConstructorDescriptor(Hammer.class, HammerConfig.class);

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
        return TplDynamicExecutorFactoryInstance.INSTANCE.factory;
    }

    //    /**
    //     * remove the created type.
    //     *
    //     * @param type the type
    //     * @return true, if successful
    //     */
    //    public boolean remove(Class<?> type) {
    //        return types.remove(type);
    //    }
    // TODO 只删除这里没用，下次再生成，类名会和之前的一致，导致类重名错误，需要再处理重名的类

    /**
     * create mapper interface implemented class.
     *
     * @param type configuration interface class
     * @param hammerConfig the hammer config
     * @return implemented class name
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException the security exception
     */
    public String create(Class<?> type, HammerConfig hammerConfig)
        throws IOException, NoSuchMethodException, SecurityException {
        return create(type, hammerConfig, Thread.currentThread().getContextClassLoader());
    }

    /**
     * create mapper interface implemented class.
     *
     * @param type configuration interface class
     * @param hammerConfig the hammer config
     * @param classLoader the class loader
     * @return implemented class name
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException the security exception
     */
    public String create(Class<?> type, HammerConfig hammerConfig, ClassLoader classLoader)
        throws IOException, NoSuchMethodException, SecurityException {
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
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

        String implClassName = type.getName() + CLASS_NAME_SUFFIX;
        if (types.contains(type)) {
            return implClassName;
        }

        //        ClassReader classReader = new ClassReader(type.getName());
        ClassReader classReader;
        try (InputStream is = classLoader.getResourceAsStream(type.getName().replace('.', '/') + ".class")) {
            classReader = new ClassReader(is);
        }
        ClassWriter cw = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        String implClassByteCodeName = Asm.getName(implClassName);

        Class<?> parentHammer = null;

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

            MethodNode constructor =
                new MethodNode(ACC_PUBLIC, Asm.CONSTRUCT_METHOD, constructorDescriptor, null,
                    null);
            constructor.visitVarInsn(ALOAD, 0);
            constructor.visitVarInsn(ALOAD, 1);
            constructor.visitLdcInsn(Type.getType(genericType));
            constructor.visitVarInsn(ALOAD, 2);
            constructor.visitMethodInsn(INVOKESPECIAL, cn.superName, Asm.CONSTRUCT_METHOD,
                Asm.getConstructorDescriptor(Hammer.class, Class.class, HammerConfig.class), false);
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
            MethodNode constructor =
                new MethodNode(ASM9, ACC_PUBLIC, Asm.CONSTRUCT_METHOD, constructorDescriptor,
                    null, null);
            constructor.visitVarInsn(ALOAD, 0);
            constructor.visitVarInsn(ALOAD, 1);
            constructor.visitVarInsn(ALOAD, 2);
            constructor.visitMethodInsn(INVOKESPECIAL, cn.superName, Asm.CONSTRUCT_METHOD,
                constructorDescriptor,
                false);
            constructor.visitInsn(RETURN);
            constructor.visitMaxs(1, 1);
            constructor.visitEnd();
            cn.methods.add(constructor);
        }

        Set<Tuple2<Method, Integer>> validationMethods = new LinkedHashSet<>();
        addImplMethods(type, globalNamespace, cn, parentHammer, hammerConfig, validationMethods);
        setValidation(cn, validationMethods);
        cn.accept(cw);
        byte[] code = cw.toByteArray();
        // 定义类
        final ClassLoader cl = classLoader;
        ClassLoaderUtils.defineClass(cl, implClassName, code, type.getProtectionDomain(), () -> {
            try {
                return ReflectUtils.defineClass(implClassName, code, cl, type.getProtectionDomain(), type);
            } catch (Exception e) {
                throw new HammerException(e);
            }
        });
        types.add(type);
        return implClassName;
    }

    private void clear() {
        types.clear();
        typeInstances.clear();
    }

    private void addImplMethods(Class<?> type, String globalNamespace, ClassNode classNode, Class<?> parentHammer,
        HammerConfig hammerConfig, Set<Tuple2<Method, Integer>> validationMethods)
        throws NoSuchMethodException, SecurityException {
        Map<String,
            java.lang.reflect.Type> genericTypes = ClassUtils.getInterfaceGenericTypeMap(type, GenericHammer.class);
        int methodIndex = 0;
        for (Method method : type.getDeclaredMethods()) {
            boolean needValidation = needValidation(method, hammerConfig);
            if (method.isDefault() && !needValidation) {
                continue;
            }
            // $deserializeLambda
            if (method.getName().startsWith("$")) {
                continue;
            }
            int localeSize = method.getParameters().length + 1;
            AtomicInteger stackSize = new AtomicInteger(0);

            MethodNode methodNode = null;
            Method parentMethod = getMethodFromParent(parentHammer, method, genericTypes);
            if (parentMethod != null) {
                // override parent GenericHammer generic method
                methodNode =
                    forParentMethod(method, parentMethod, methodIndex, classNode, stackSize, localeSize, needValidation,
                        validationMethods, hammerConfig);
            } else if (method.isDefault()) {
                // default method only need validate can go here
                methodNode = validateForDefaultMethod(type, method, methodIndex, classNode, stackSize, localeSize,
                    validationMethods, hammerConfig);
            } else {
                // method for template execute (query, update, delete)
                methodNode =
                    templateMethod(type, method, methodIndex, classNode, stackSize, localeSize, globalNamespace,
                        needValidation, validationMethods, hammerConfig);
            }
            if (methodNode != null) {
                classNode.methods.add(methodNode);

                // for debug
                if (logger.isTraceEnabled()) {
                    StringBuilder javapString = new StringBuilder();
                    javapString.append(methodNode.access + " " + methodNode.name + methodNode.desc)
                        .append(Chars.NEW_LINE).append(Str.format("stack={0},locales={1}", stackSize, localeSize))
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
            }
            methodIndex++;
        }
    }

    private MethodNode forParentMethod(Method method, Method parentMethod, int methodIndex, ClassNode classNode,
        AtomicInteger stackSize, int localeSize, boolean needValidation, Set<Tuple2<Method, Integer>> validationMethods,
        HammerConfig hammerConfig) {
        String methodDescriptor = Type.getMethodDescriptor(method);
        String parentMethodDescriptor = Type.getMethodDescriptor(parentMethod);
        // TODO 未处理泛型
        MethodNode methodNode = new MethodNode(ACC_PUBLIC, method.getName(), methodDescriptor, null, null);
        setAnnotations(methodNode, method);
        if (needValidation) {
            setValidation(classNode, methodNode, method, methodIndex, hammerConfig, validationMethods, stackSize);
        }
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
            visitReturn(methodNode, method.getReturnType());
        } else {
            methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
            methodNode.visitInsn(ARETURN);
        }
        methodNode.visitMaxs(stackSize.intValue(), localeSize);
        methodNode.visitEnd();
        return methodNode;
    }

    private MethodNode validateForDefaultMethod(Class<?> type, Method method, int methodIndex, ClassNode classNode,
        AtomicInteger stackSize, int localeSize, Set<Tuple2<Method, Integer>> validationMethods,
        HammerConfig hammerConfig) {
        String methodDescriptor = Type.getMethodDescriptor(method);
        MethodNode methodNode = new MethodNode(ACC_PUBLIC, method.getName(), methodDescriptor, null, null);
        setAnnotations(methodNode, method);
        setValidation(classNode, methodNode, method, methodIndex, hammerConfig, validationMethods, stackSize);
        for (int i = 0; i < localeSize; i++) {
            methodNode.visitVarInsn(ALOAD, i);
            stackSize.incrementAndGet();
        }
        methodNode.visitMethodInsn(INVOKESPECIAL, Asm.getName(type), method.getName(),
            Type.getMethodDescriptor(method), true);
        methodNode.visitInsn(ARETURN);
        methodNode.visitMaxs(stackSize.intValue(), localeSize);
        methodNode.visitEnd();
        return methodNode;
    }

    private MethodNode templateMethod(Class<?> type, Method method, int methodIndex, ClassNode classNode,
        AtomicInteger stackSize, int localeSize, String globalNamespace, boolean needValidation,
        Set<Tuple2<Method, Integer>> validationMethods, HammerConfig hammerConfig)
        throws NoSuchMethodException, SecurityException {
        String namespace = getNamespace(method, globalNamespace);
        String name = getName(method);

        // TODO 未处理泛型
        MethodNode methodNode =
            new MethodNode(ACC_PUBLIC, method.getName(), Type.getMethodDescriptor(method), null, null);
        setAnnotations(methodNode, method);
        if (needValidation) {
            setValidation(classNode, methodNode, method, methodIndex, hammerConfig, validationMethods, stackSize);
        }
        methodNode.parameters = new ArrayList<>();
        methodNode.visitVarInsn(ALOAD, 0);
        stackSize.incrementAndGet();
        methodNode.visitFieldInsn(GETFIELD, classNode.name, TPLEXECUTOR_FIELD_NAME, tplExecutorDescriptor);
        ExecutionType tplType = getType(method);
        // String typeDescriptor = Type.getDescriptor(TplExecuteIdFileImpl.class);
        String executeIdType = Type.getInternalName(TplExecuteIdFileImpl.class);
        methodNode.visitTypeInsn(NEW, executeIdType);
        methodNode.visitInsn(DUP);
        methodNode.visitLdcInsn(name);
        methodNode.visitLdcInsn(namespace);
        methodNode.visitVarInsn(ALOAD, 0);
        stackSize.incrementAndGet();
        methodNode.visitFieldInsn(GETFIELD, classNode.name, TPLID_PARSER_NAME,
            tplExecuteIdParserDescriptor);
        methodNode.visitMethodInsn(INVOKESPECIAL, executeIdType, Asm.CONSTRUCT_METHOD,
            Asm.getConstructorDescriptor(String.class, String.class, TplExecuteIdParser.class), false);
        // YUFEI_TEST 这里的stackSize需要测试
        if (method.getReturnType() == void.class) {
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, executeMethod.getName(),
                executeMethodDescriptor, true);
            methodNode.visitInsn(POP);
            methodNode.visitInsn(RETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else if (method.getReturnType() == Integer.TYPE
            && (tplType == ExecutionType.AUTO || tplType == ExecutionType.EXECUTE)) {
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, executeMethod.getName(),
                executeMethodDescriptor, true);
            methodNode.visitInsn(IRETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else if (ClassUtils.isParent(List.class, method.getReturnType())) {
            GenericType<?> elementType = ClassUtils.Methods.getReturnTypeGenericParameterType(type, method);
            //                    String returnTypeName = getReturnTypeName(method);
            //                    if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
            if (ClassUtils.isParent(Map.class, elementType.getType())) {
                ParamPosition position = setParams(methodNode, method, stackSize);
                if (position.limitParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        listMapLimitMethod.getName(),
                        listMapLimitMethodDescriptor, true);
                } else if (position.pageParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        listMapPageMethod.getName(),
                        listMapPageMethodDescriptor, true);
                } else {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, listMapMethod.getName(),
                        listMapMethodDescriptor, true);
                }

                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else if (ClassUtils.isParent(Tuple.class, elementType.getType())) {
                for (GenericType<?> gt : elementType.getGenericTypes()) {
                    methodNode.visitLdcInsn(Type.getType(gt.getType()));
                }
                ParamPosition position =
                    setParams(methodNode, method, stackSize, elementType.getGenericTypes().size());
                if (ClassUtils.isParent(Tuple2.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple2LimitMethod.getName(), listTuple2LimitMethodDescriptor, true);
                    } else if (position.pageParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple2PageMethod.getName(), listTuple2PageMethodDescriptor, true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple2Method.getName(),
                            listTuple2MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple3.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple3LimitMethod.getName(), listTuple3LimitMethodDescriptor, true);
                    } else if (position.pageParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple3PageMethod.getName(), listTuple3PageMethodDescriptor, true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple3Method.getName(),
                            listTuple3MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple4.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple4LimitMethod.getName(), listTuple4LimitMethodDescriptor, true);
                    } else if (position.pageParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple4PageMethod.getName(), listTuple4PageMethodDescriptor, true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple4Method.getName(),
                            listTuple4MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple5.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple5LimitMethod.getName(), listTuple5LimitMethodDescriptor, true);
                    } else if (position.pageParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple5PageMethod.getName(), listTuple5PageMethodDescriptor, true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple5Method.getName(),
                            listTuple5MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple6.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple6LimitMethod.getName(), listTuple6LimitMethodDescriptor, true);
                    } else if (position.pageParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple6PageMethod.getName(), listTuple6PageMethodDescriptor, true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            listTuple6Method.getName(),
                            listTuple6MethodDescriptor, true);
                    }
                } else {
                    throw new HammerException("only support Tuple2...Tuple6");
                }
                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else {
                methodNode.visitLdcInsn(Type.getType(elementType.getType()));
                ParamPosition position = setParams(methodNode, method, stackSize);
                if (position.limitParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        listTypeLimitMethod.getName(),
                        listTypeLimitMethodDescriptor, true);
                } else if (position.pageParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        listTypePageMethod.getName(),
                        listTypePageMethodDescriptor, true);
                } else {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, listTypeMethod.getName(),
                        listTypeMethodDescriptor, true);
                }
                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            }
        } else if (ClassUtils.isParent(PaginationResults.class, method.getReturnType())) {
            GenericType<?> elementType = ClassUtils.Methods.getReturnTypeGenericParameterType(type, method);
            //                    String returnTypeName = getReturnTypeName(method);
            //                    if (ClassUtils.isParent(Map.class, ClassUtils.forName(returnTypeName))) {
            if (ClassUtils.isParent(Map.class, elementType.getType())) {
                ParamPosition position = setParams(methodNode, method, stackSize);
                if (position.limitParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        paginationMapLimitMethod.getName(), paginationMapLimitMethodDescriptor, true);
                } else {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        paginationMapMethod.getName(),
                        paginationMapMethodDescriptor, true);
                }
                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();

            } else if (ClassUtils.isParent(Tuple.class, elementType.getType())) {
                for (GenericType<?> gt : elementType.getGenericTypes()) {
                    methodNode.visitLdcInsn(Type.getType(gt.getType()));
                }
                ParamPosition position =
                    setParams(methodNode, method, stackSize, elementType.getGenericTypes().size());
                if (ClassUtils.isParent(Tuple2.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple2LimitMethod.getName(), paginationTuple2LimitMethodDescriptor,
                            true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple2Method.getName(), paginationTuple2MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple3.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple3LimitMethod.getName(), paginationTuple3LimitMethodDescriptor,
                            true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple3Method.getName(), paginationTuple3MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple4.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple4LimitMethod.getName(), paginationTuple4LimitMethodDescriptor,
                            true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple4Method.getName(), paginationTuple4MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple5.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple5LimitMethod.getName(), paginationTuple5LimitMethodDescriptor,
                            true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple5Method.getName(), paginationTuple5MethodDescriptor, true);
                    }
                } else if (ClassUtils.isParent(Tuple6.class, elementType.getType())) {
                    if (position.limitParamPosition > 0) {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple6LimitMethod.getName(), paginationTuple6LimitMethodDescriptor,
                            true);
                    } else {
                        methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                            paginationTuple6Method.getName(), paginationTuple6MethodDescriptor, true);
                    }
                } else {
                    throw new HammerException("only support Tuple2...Tuple6");
                }
                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else {
                //                        methodNode.visitLdcInsn(Type.getType(ClassUtils.forName(returnTypeName)));
                methodNode.visitLdcInsn(Type.getType(elementType.getType()));
                ParamPosition position = setParams(methodNode, method, stackSize);
                if (position.limitParamPosition > 0) {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        paginationTypeLimitMethod.getName(), paginationTypeLimitMethodDescriptor, true);
                } else {
                    methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName,
                        paginationTypeMethod.getName(),
                        paginationTypeMethodDescriptor, true);
                }
                methodNode.visitInsn(ARETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            }
        } else if (ClassUtils.isParent(Number.class, method.getReturnType())) {
            methodNode.visitLdcInsn(Type.getType(method.getReturnType()));
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, numberMethod.getName(),
                numberMethodDescriptor, true);
            methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
            methodNode.visitInsn(ARETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else if (method.getReturnType().isPrimitive()) {
            if (method.getReturnType() == Integer.TYPE) {
                setParams(methodNode, method, stackSize);
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, intValueMethod.getName(),
                    intValueMethodDescriptor, true);
                methodNode.visitInsn(IRETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else if (method.getReturnType() == Long.TYPE) {
                setParams(methodNode, method, stackSize);
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, longValueMethod.getName(),
                    longValueMethodDescriptor, true);
                methodNode.visitInsn(LRETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else if (method.getReturnType() == Double.TYPE) {
                setParams(methodNode, method, stackSize);
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, doubleValueMethod.getName(),
                    doubleValueMethodDescriptor, true);
                methodNode.visitInsn(DRETURN);
                methodNode.visitMaxs(stackSize.intValue(), localeSize);
                methodNode.visitEnd();
            } else {
                // ENHANCE 使用exception code
                throw new HammerException("unsupport query return type with primitive type "
                    + method.getReturnType() + ", you can use wrapper type instead");
            }
        } else if (String.class == method.getReturnType()) {
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, stringMethod.getName(),
                stringMethodDescriptor, true);
            methodNode.visitInsn(ARETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else if (ClassUtils.isParent(Map.class, method.getReturnType())) {
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleMapMethod.getName(),
                singleMapMethodDescriptor, true);
            methodNode.visitInsn(ARETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else if (ClassUtils.isParent(Tuple.class, method.getReturnType())) {
            List<GenericType<?>> gts = ClassUtils.Methods.getReturnTypeGenericParameterTypes(type, method);
            for (GenericType<?> gt : gts) {
                methodNode.visitLdcInsn(Type.getType(gt.getType()));
            }
            setParams(methodNode, method, stackSize, gts.size());
            if (ClassUtils.isParent(Tuple2.class, method.getReturnType())) {
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTuple2Method.getName(),
                    singleTuple2MethodDescriptor, true);
            } else if (ClassUtils.isParent(Tuple3.class, method.getReturnType())) {
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTuple3Method.getName(),
                    singleTuple3MethodDescriptor, true);
            } else if (ClassUtils.isParent(Tuple4.class, method.getReturnType())) {
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTuple4Method.getName(),
                    singleTuple4MethodDescriptor, true);
            } else if (ClassUtils.isParent(Tuple5.class, method.getReturnType())) {
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTuple5Method.getName(),
                    singleTuple5MethodDescriptor, true);
            } else if (ClassUtils.isParent(Tuple6.class, method.getReturnType())) {
                methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTuple6Method.getName(),
                    singleTuple6MethodDescriptor, true);
            } else {
                throw new HammerException("only support Tuple2...Tuple6");
            }
            methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
            methodNode.visitInsn(ARETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        } else {
            methodNode.visitLdcInsn(Type.getType(method.getReturnType()));
            setParams(methodNode, method, stackSize);
            methodNode.visitMethodInsn(INVOKEINTERFACE, tplExecutorName, singleTypeMethod.getName(),
                singleTypeMethodDescriptor, true);
            methodNode.visitTypeInsn(CHECKCAST, Type.getInternalName(method.getReturnType()));
            methodNode.visitInsn(ARETURN);
            methodNode.visitMaxs(stackSize.intValue(), localeSize);
            methodNode.visitEnd();
        }
        logger.debug("generate method {}", method.getName());
        return methodNode;
    }

    private static class ParamPosition {
        int pageParamPosition = -1;
        int offsetParamPosition = -1;
        int limitParamPosition = -1;
        //        int commonParamNum = 0;

        /**
         * Instantiates a new param position.
         */
        private ParamPosition() {
            super();
        }
    }

    private String getConstMethodName(Method method, int methodIndex) {
        //        StringBuilder name = new StringBuilder();
        //        name.append("$").append(method.getName());
        //        for (Class<?> parameterType : method.getParameterTypes()) {
        //            name.append("_").append(parameterType.getSimpleName());
        //        }
        //        return name.toString();
        return "$" + method.getName() + methodIndex;
    }

    private void setValidation(ClassNode classNode, Set<Tuple2<Method, Integer>> validationMethods) {
        for (Tuple2<Method, Integer> tuple : validationMethods) {
            Method validationMethod = tuple.get0();
            FieldVisitor fieldVisitor =
                classNode.visitField(ACC_PRIVATE | ACC_FINAL | ACC_STATIC,
                    getConstMethodName(validationMethod, tuple.get1()),
                    "Ljava/lang/reflect/Method;", null,
                    null);
            fieldVisitor.visitEnd();
        }
        MethodVisitor methodVisitor = classNode.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
        methodVisitor.visitCode();
        for (Tuple2<Method, Integer> tuple : validationMethods) {
            Method validationMethod = tuple.get0();
            methodVisitor.visitLdcInsn(Asm.getType(validationMethod.getDeclaringClass()));
            methodVisitor.visitLdcInsn(validationMethod.getName());
            visitInt(methodVisitor, validationMethod.getParameterCount());
            methodVisitor.visitTypeInsn(ANEWARRAY, "java/lang/Class");
            for (int i = 0; i < validationMethod.getParameterCount(); i++) {
                methodVisitor.visitInsn(DUP);
                visitInt(methodVisitor, i); // methodVisitor.visitInsn(ICONST_0);
                methodVisitor.visitLdcInsn(Asm.getType(validationMethod.getParameters()[i].getType())); // methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"));
                methodVisitor.visitInsn(AASTORE);
            }
            methodVisitor.visitMethodInsn(INVOKESTATIC, "cn/featherfly/common/lang/ClassUtils", "getMethod",
                "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
            methodVisitor.visitFieldInsn(PUTSTATIC, classNode.name, getConstMethodName(validationMethod, tuple.get1()),
                "Ljava/lang/reflect/Method;");
        }
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(6, 0);
        methodVisitor.visitEnd();
    }

    private void setValidation(ClassNode classNode, MethodNode methodNode, Method method, int methodIndex,
        HammerConfig config,
        Set<Tuple2<Method, Integer>> validationMethods, AtomicInteger stackSize) {
        int paramsCount = method.getParameters().length;

        methodNode.visitVarInsn(ALOAD, 0);
        stackSize.incrementAndGet();
        methodNode.visitFieldInsn(GETFIELD, classNode.name, "hammerConfig",
            Asm.getType(HammerConfig.class).getDescriptor());
        methodNode.visitMethodInsn(INVOKEINTERFACE, Asm.getName(HammerConfig.class), "getValidatorConfig",
            "()" + Asm.getType(ValidatorConfig.class).getDescriptor(), true);
        methodNode.visitVarInsn(ALOAD, 0);
        stackSize.incrementAndGet();
        // validation parameter Method
        methodNode.visitFieldInsn(GETSTATIC, classNode.name, getConstMethodName(method, methodIndex),
            "Ljava/lang/reflect/Method;");
        // validation parameter values
        visitInt(methodNode, paramsCount);
        methodNode.visitTypeInsn(ANEWARRAY, "java/lang/Object");
        for (int i = 0; i < paramsCount; i++) {
            methodNode.visitInsn(DUP);
            visitInt(methodNode, i);
            // TODO 处理自动装箱的问题
            methodNode.visitVarInsn(Asm.getLoadCode(method.getParameters()[i].getType()), i + 1);
            stackSize.incrementAndGet();
            methodNode.visitInsn(AASTORE);
        }
        // validation group parameter
        methodNode.visitInsn(ICONST_0);
        methodNode.visitTypeInsn(ANEWARRAY, "java/lang/Class");
        methodNode.visitMethodInsn(INVOKEINTERFACE, Asm.getName(ValidatorConfig.class), "validateParameters",
            "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;[Ljava/lang/Class;)V", true);
        validationMethods.add(Tuples.of(method, methodIndex));
    }

    private boolean needValidation(Method method, HammerConfig config) {
        for (Annotation[] parameterAnnotations : method.getParameterAnnotations()) {
            for (Annotation parameterAnnotation : parameterAnnotations) {
                if (config.getValidatorConfig().isConstraint(parameterAnnotation.annotationType())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setAnnotations(MethodNode methodNode, Method method) {
        Annotation[] annotations = method.getAnnotations();
        if (Lang.isEmpty(annotations)) {
            return;
        }
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

    private ParamPosition setParams(MethodNode methodNode, Method method, AtomicInteger stackSize)
        throws NoSuchMethodException, SecurityException {
        return setParams(methodNode, method, stackSize, 1);
    }

    private ParamPosition setParams(MethodNode methodNode, Method method, AtomicInteger stackSize, int commonParamIndex)
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
                    stackSize.incrementAndGet();
                    if (parameter.getType().isPrimitive()) {
                        methodNode.visitMethodInsn(INVOKESTATIC, Asm.getPrimitiveWrapperName(parameter.getType()),
                            Asm.PRIMITIVE_BOXING_METHOD,
                            Asm.getPrimitiveBoxingMethodDescriptor(parameter.getType()),
                            false);
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
        //        position.commonParamNum = commonParamIndex - 1;

        if (position.pageParamPosition > 0) {
            methodNode.visitVarInsn(ALOAD, position.pageParamPosition);
            stackSize.incrementAndGet();
        } else if (position.limitParamPosition > 0) {
            if (position.offsetParamPosition > 0) {
                methodNode.visitVarInsn(ILOAD, position.offsetParamPosition);
                methodNode.visitVarInsn(ILOAD, position.limitParamPosition);
                stackSize.addAndGet(2);
            } else {
                methodNode.visitInsn(ICONST_0);
                methodNode.visitVarInsn(ILOAD, position.limitParamPosition);
                stackSize.incrementAndGet();
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
     * @param <E> generic type
     * @param type mapper interface type
     * @param hammer hammer instance
     * @param hammerConfig the hammer config
     * @return new instance
     */
    @SuppressWarnings("unchecked")
    public <E> E newInstance(Class<E> type, Hammer hammer, HammerConfig hammerConfig) {
        try {
            return (E) ClassUtils.forName(create(type, hammerConfig)).getConstructor(Hammer.class, HammerConfig.class)
                .newInstance(hammer, hammerConfig);
        } catch (Exception e) {
            throw new HammerException(e);
        }
    }

    /**
     * return a singleton instance, every type only new one instance.
     *
     * @param <E> generic type
     * @param type mapper interface type
     * @param hammer hammer instance
     * @param hammerConfig the hammer config
     * @return instance
     */
    @SuppressWarnings("unchecked")
    public <E> E instance(Class<E> type, Hammer hammer, HammerConfig hammerConfig) {
        E e = null;
        e = (E) typeInstances.get(type);
        if (e == null) {
            e = newInstance(type, hammer, hammerConfig);
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

    private void visitReturn(MethodNode methodNode, Class<?> type) {
        if (type == Integer.TYPE) {
            methodNode.visitInsn(IRETURN);
        } else if (type == Byte.TYPE) {
            methodNode.visitInsn(IRETURN);
        } else if (type == Short.TYPE) {
            methodNode.visitInsn(IRETURN);
        } else if (type == Character.TYPE) {
            methodNode.visitInsn(IRETURN);
        } else if (type == Boolean.TYPE) {
            methodNode.visitInsn(IRETURN);
        } else if (type == Long.TYPE) {
            methodNode.visitInsn(LRETURN);
        } else if (type == Double.TYPE) {
            methodNode.visitInsn(DRETURN);
        } else if (type == Float.TYPE) {
            methodNode.visitInsn(FRETURN);
        } else if (type == Void.TYPE) {
            methodNode.visitInsn(RETURN);
        } else {
            methodNode.visitInsn(ARETURN);
        }
    }

    private void visitInt(MethodVisitor methodVisitor, int value) {
        switch (value) {
            case -1:
                methodVisitor.visitInsn(ICONST_M1);
                return;
            case 0:
                methodVisitor.visitInsn(ICONST_0);
                return;
            case 1:
                methodVisitor.visitInsn(ICONST_1);
                return;
            case 2:
                methodVisitor.visitInsn(ICONST_2);
                return;
            case 3:
                methodVisitor.visitInsn(ICONST_3);
                return;
            case 4:
                methodVisitor.visitInsn(ICONST_4);
                return;
            case 5:
                methodVisitor.visitInsn(ICONST_5);
                return;
            default:
                methodVisitor.visitVarInsn(ILOAD, value);
                return;
        }
    }

    private void visitInt(MethodNode methodNode, int value) {
        switch (value) {
            case -1:
                methodNode.visitInsn(ICONST_M1);
                return;
            case 0:
                methodNode.visitInsn(ICONST_0);
                return;
            case 1:
                methodNode.visitInsn(ICONST_1);
                return;
            case 2:
                methodNode.visitInsn(ICONST_2);
                return;
            case 3:
                methodNode.visitInsn(ICONST_3);
                return;
            case 4:
                methodNode.visitInsn(ICONST_4);
                return;
            case 5:
                methodNode.visitInsn(ICONST_5);
                return;
            default:
                methodNode.visitVarInsn(ILOAD, value);
                return;
        }
    }

    /**
     * Gets the class loader.
     *
     * @return the class loader
     */
    public ClassLoader getClassLoader() {
        return classLoader;
    }

}
