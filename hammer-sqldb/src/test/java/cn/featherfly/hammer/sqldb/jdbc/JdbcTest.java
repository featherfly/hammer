
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.hammer.sqldb.jdbc.vo.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.AppVersion;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JdbcTest extends JdbcTestBase {

    @BeforeClass
    void before() {
        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
                BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"),
                platformJavaSqlTypeMapper);
    }

    @Test
    public void testQuery() {
        List<Long> idList = jdbc.query("select id from role order by id", Long.class);
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }
    }

    @Test
    public void testNestedPropertyMapper() {
        List<App> appList = jdbc.query(
                "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
                App.class, ArrayUtils.EMPTY_OBJECT_ARRAY);
        for (App app : appList) {
            System.out.println(app);
        }
    }

    @Test
    public void testIntercepor() {
        JdbcImpl jdbc = new JdbcImpl(dataSource, dialect, sqlTypeMappingManager);

        jdbc.addInterceptor(new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                execution.setExecution("/*+ 加入sql hit 测试*/" + execution.getExecution());
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                execution.setResult(null);
            }
        }, new JdbcExecutionInterceptor() {
            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("original sql -> {0}\n", execution.getOriginalExecution()));
                System.err.println(Strings.format("execute sql -> {0}\n", execution.getExecution()));
                System.err.println(Strings.format("original params -> {0}\n", execution.getOriginalParams()));
                System.err.println(Strings.format("execute params -> {0}\n", execution.getParams()));
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                System.err.println(Strings.format("original result -> {0}\n", execution.getOriginalResult()));
                System.err.println(Strings.format("execute result -> {0}\n", execution.getResult()));
            }
        });

        List<App> appList = jdbc.query(
                "select a.id, a.code, a.name, a.platform, a.last_version as \"lastVersion.id\", v.version as \"lastVersion.version\", v.version_code as \"lastVersion.versionCode\" from app a join app_version v on a.last_version = v.id",
                App.class, ArrayUtils.EMPTY_OBJECT_ARRAY);
        assertNull(appList);

    }

    @Test
    public void testGeneratedKeyHolder() {
        AtomicLong id = new AtomicLong(-1);
        int i = jdbc.update("insert into cms_article values(?,?,?)", new GeneratedKeyHolder<Long>() {
            @Override
            public GenericType<Long> getType() {
                return new GenericClass<>(Long.class);
            }

            @Override
            public void acceptKey(Long key, int row) {
                System.err.println("generated id -> " + key);
                id.set(key);
            }

        }, null, "title", "content");

        assertEquals(i, 1);

        Long l = jdbc.queryLong("select id from cms_article where id = ?", id);

        assertTrue(l == id.longValue());

    }
}
