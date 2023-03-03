
package cn.featherfly.hammer.tpl.mapper;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.EntityDelete;
import cn.featherfly.hammer.dsl.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntity;
import cn.featherfly.hammer.tpl.TplExecuteId;

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
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", this.getClass()));

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

        GenericHammerSupportMapper mapper = ClassUtils.newInstance(type, getHammer(userId, userClass));

        User u = mapper.get(userId);
        assertNull(u);
    }

    @Test
    public void testHammerSupport() throws Exception {
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

        HammerSupportMapper mapper = ClassUtils.newInstance(type, getHammer(userId, userClass));

        User u = mapper.get(userId);
        assertNull(u);
    }

    private Hammer getHammer(Long userId, Class<User> userClass) {
        return new Hammer() {

            @Override
            public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params) {

                return null;
            }

            @Override
            public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {

                return null;
            }

            @Override
            public String string(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public String string(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {

                return null;
            }

            @Override
            public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {

                return null;
            }

            @Override
            public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
                    Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType,
                    Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
                    Map<String, Object> params, int offset, int limit) {

                return null;
            }

            @Override
            public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType,
                    Map<String, Object> params, int offset, int limit) {

                return null;
            }

            @Override
            public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId,
                    Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
                    Page page) {

                return null;
            }

            @Override
            public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId,
                    Map<String, Object> params, int offset, int limit) {

                return null;
            }

            @Override
            public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
                    int offset, int limit) {

                return null;
            }

            @Override
            public Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Long numberLong(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Integer numberInt(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public Double numberDouble(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType,
                    Map<String, Object> params) {

                return null;
            }

            @Override
            public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {

                return null;
            }

            @Override
            public long longValue(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public long longValue(String tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
                    Page page) {

                return null;
            }

            @Override
            public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {

                return null;
            }

            @Override
            public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
                    int offset, int limit) {

                return null;
            }

            @Override
            public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
                    int limit) {

                return null;
            }

            @Override
            public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
                    int limit) {

                return null;
            }

            @Override
            public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset,
                    int limit) {

                return null;
            }

            @Override
            public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {

                return null;
            }

            @Override
            public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {

                return null;
            }

            @Override
            public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {

                return null;
            }

            @Override
            public int intValue(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public int intValue(String tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public int execute(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public int execute(String tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public double doubleValue(String tplExecuteId, Map<String, Object> params) {

                return 0;
            }

            @Override
            public <E> EntityUpdate<E> update(Class<E> entityType) {

                return null;
            }

            @Override
            public Update update(String repository) {

                return null;
            }

            @Override
            public <E> int update(E entity, IgnorePolicy ignorePolicy) {

                return 0;
            }

            @Override
            public <E> int update(E entity) {

                return 0;
            }

            @Override
            public <E> EntityQueryEntity<E> query(Class<E> entityType) {

                return null;
            }

            @Override
            public QueryEntity query(String repository) {

                return null;
            }

            @Override
            public <E> int[] merge(List<E> entities) {

                return null;
            }

            @Override
            public <E> int[] merge(@SuppressWarnings("unchecked") E... entities) {

                return null;
            }

            @Override
            public <E> int merge(E entity) {

                return 0;
            }

            @Override
            public <E> E get(E entity) {

                return null;
            }

            @Override
            public <E> E load(E entity) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, List<Serializable> ids) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, Serializable... ids) {

                return null;
            }

            @Override
            public <E> E get(Serializable id, Class<E> type) {
                assertEquals(id, userId);
                assertEquals(type, userClass);
                return null;
            }

            @Override
            public <E> EntityDelete<E> delete(Class<E> entityType) {

                return null;
            }

            @Override
            public Delete delete(String repository) {

                return null;
            }

            @Override
            public <E> int delete(Serializable id, Class<E> entityType) {

                return 0;
            }

            @Override
            public <E> int delete(E entity) {

                return 0;
            }

            @Override
            public <E> int saveOrUpdate(E entity) {
                // YUFEI_TODO Auto-generated method stub
                return 0;
            }

            @Override
            public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> E getLockUpdate(Serializable id, Class<E> type, Function<E, E> updateFunction) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> E loadLockUpdate(E entity, Function<E, E> updateFunction) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> E getLockUpdate(E entity, Function<E, E> updateFunction) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public QueryEntity query(Repository repository) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public Update update(Repository repository) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public Delete delete(Repository repository) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, int batchSize) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] update(E... entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] update(List<E> entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, IgnorePolicy ignorePolicy) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int save(E entity) {
                // YUFEI_TODO Auto-generated method stub
                return 0;
            }

            @Override
            public <E> int[] save(E... entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] save(List<E> entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] delete(Serializable[] ids, Class<E> entityType) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E, ID extends Serializable> int[] delete(List<ID> ids, Class<E> entityType) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] delete(E... entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }

            @Override
            public <E> int[] delete(List<E> entities) {
                // YUFEI_TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper.class));
        System.out.println(type.getName());
    }
}
