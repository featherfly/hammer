
package cn.featherfly.hammer.tpl.mapper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.core.config.Configurator;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.ParamedExecutionExecutorEx;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilder;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * <p>
 * TplDynamicExecutorFactoryTest
 * </p>
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactoryByAsmTest {

    //    static TplDynamicExecutorFactoryByAsm factory = TplDynamicExecutorFactoryByAsm.getInstance();

    static TplDynamicExecutorFactory factory = TplDynamicExecutorFactory.getInstance();

    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @BeforeSuite
    public void init() throws IOException {
        Configurator.initialize("log4j2", "log4j2.xml");

        logger.debug("init");
    }

    @Test
    public void testNoExtends() throws Exception {
        Class<?> type = ClassUtils
            .forName(factory.create(TeMapper.class, Thread.currentThread().getContextClassLoader()));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    @Test
    public void testExtendsHammer() throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    @Test
    public void testExtendsGenericHammer() throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper2.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));
    }

    @Test
    public void testExtendsGenericHammer2() throws Exception {
        Class<?> c = TestMapper.class;
        Class<?> type = ClassUtils.forName(factory.create(c, Thread.currentThread().getContextClassLoader()));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericTypeMap(type));

        assertEquals(type.getSimpleName(), c.getSimpleName() + TplDynamicExecutorFactory.CLASS_NAME_SUFFIX);

        String id = "id";
        assertEquals(TestMapper.class.getMethod("get", Long.class).getParameters()[0].getName(), id);
        assertEquals(type.getMethod("get", Long.class).getParameters()[0].getName(), id);

        for (Method method : type.getMethods()) {
            if (method.getParameterCount() > 0) {
                System.out.println(type.getName() + "." + method.getName() + " " + method.getParameters()[0].getName()
                    + " " + method.getParameters()[0].getType().getName());
            }
        }
        assertEquals(type.getMethod("save", Object.class).getParameters()[0].getName(), "entity");
        assertEquals(type.getMethod("getByUsername", String.class).getParameters()[0].getName(), "username");

    }

    @Test
    public void testGenericHammerSupport() throws Exception {
        @SuppressWarnings("unchecked")
        Class<GenericHammerSupportMapper> type = (Class<GenericHammerSupportMapper>) ClassUtils
            .forName(factory.create(GenericHammerSupportMapper.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        Class<User> userClass = User.class;
        Long userId = 1L;

        GenericHammerSupportMapper mapper = ClassUtils.newInstance(type, getHammer(userId, userClass),
            new HammerConfigImpl(true));

        User u = mapper.get(userId);
        assertNull(u);
    }

    @Test
    public void testHammerSupport() throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper3.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));
    }

    @Test
    public void testHammerSupport2() throws Exception {
        @SuppressWarnings("unchecked")
        Class<HammerSupportMapper> type = (Class<HammerSupportMapper>) ClassUtils
            .forName(factory.create(HammerSupportMapper.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        Class<User> userClass = User.class;
        Long userId = 1L;

        HammerSupportMapper mapper = ClassUtils.newInstance(type, getHammer(userId, userClass),
            new HammerConfigImpl(true));

        User u = mapper.get(userId);
        assertNull(u);
    }

    @SuppressWarnings("unchecked")
    private Hammer getHammer(Long userId, Class<User> userClass) {
        return new Hammer() {

            @Override
            public <E> int save(E entity) {

                return 0;
            }

            @Override
            public <E> int[] save(List<E> entities) {

                return null;
            }

            @Override
            public <E> int[] save(List<E> entities, int batchSize) {

                return null;
            }

            @Override
            public <E> int update(E entity) {

                return 0;
            }

            @Override
            public <E> int update(E entity, IgnoreStrategy ignoreStrategy) {

                return 0;
            }

            @Override
            public <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator) {

                return null;
            }

            @Override
            public <E> E updateFetch(E entity, UnaryOperator<E> updateOperator) {

                return null;
            }

            @Override
            public <E> int[] update(E... entities) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, int batchSize) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {

                return null;
            }

            @Override
            public <E> int merge(E entity) {

                return 0;
            }

            @Override
            public <E> int[] merge(E... entities) {

                return null;
            }

            @Override
            public <E> int[] merge(List<E> entities) {

                return null;
            }

            @Override
            public <E> int saveOrUpdate(E entity) {

                return 0;
            }

            @Override
            public <E> int saveOrUpdate(E entity, Predicate<E> updatable) {

                return 0;
            }

            @Override
            public <E> int delete(E entity) {

                return 0;
            }

            @Override
            public <E> int delete(Serializable id, Class<E> entityType) {

                return 0;
            }

            @Override
            public <E> int[] delete(Serializable[] ids, Class<E> entityType) {

                return null;
            }

            @Override
            public <E, I extends Serializable> int[] delete(List<I> ids, Class<E> entityType) {

                return null;
            }

            @Override
            public <E> int[] delete(List<E> entities) {

                return null;
            }

            @Override
            public <E> E get(Serializable id, Class<E> type) {

                return null;
            }

            @Override
            public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, Serializable... ids) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, List<Serializable> ids) {

                return null;
            }

            @Override
            public <E> E get(E entity) {

                return null;
            }

            @Override
            public RepositoryQueryFetch query(String repository) {

                return null;
            }

            @Override
            public RepositoryQueryFetch query(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityQueryFetch<E> query(Class<E> entityType) {

                return null;
            }

            @Override
            public RepositoryUpdate update(String repository) {

                return null;
            }

            @Override
            public RepositoryUpdate update(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityUpdate<E> update(Class<E> entityType) {

                return null;
            }

            @Override
            public RepositoryDelete delete(String repository) {

                return null;
            }

            @Override
            public RepositoryDelete delete(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityDelete<E> delete(Class<E> entityType) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx dml(String execution, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx dml(String execution, Serializable... params) {

                return null;
            }

            @Override
            public TplExecutor template() {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(String templateContent, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
                Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(String tplExecuteId, Serializable... params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
                Serializable... params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Serializable... params) {

                return null;
            }

            @Override
            public <E> int[] update(E[] entities, int batchSize) {
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, Predicate<E> updatable) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, int batchSize) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, int batchSize, Predicate<E> updatable) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        //        Class<?> type = ClassUtils.forName(factory.create(TMapper.class));
        //        System.out.println(type.getName());
        ClassNode classNode = new ClassNode();
        // 1
        InputStream is = new FileInputStream(
            "D:\\workspace\\eclipse_workspace\\eclipse_ff\\featherfly-projects\\hammer\\hammer-core\\bin\\test\\cn\\featherfly\\hammer\\tpl\\mapper\\TMapperImpl.class");
        ClassReader classReader = new ClassReader(is); // 2
        classReader.accept(classNode, 0);
        for (MethodNode method : classNode.methods) {
            System.out.println(method.name + " " + method.desc);
        }
    }
}
