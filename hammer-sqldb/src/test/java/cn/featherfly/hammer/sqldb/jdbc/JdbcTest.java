
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import cn.featherfly.common.model.app.Platforms;
import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.hammer.sqldb.jdbc.vo.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;

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

    @Test
    public void testInsert() {
        Article article;
        int result = 0;
        final String tableName = "cms_article";
        final String id = "id";
        final String title = "title";
        final String content = "content";
        final String[] columnNames = new String[] { id, title, content };
        final Object[] params = new Object[] { null, "title_01", "content_01" };

        result = jdbc.update("delete from cms_article");

        result = jdbc.insert(tableName, columnNames, params);
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 1);

        final AtomicLong l = new AtomicLong();

        result = jdbc.insert(tableName, columnNames, new GeneratedKeyHolder<Long>() {
            @Override
            public void acceptKey(Long key, int row) {
                l.set(key);
            }

            @Override
            public GenericType<Long> getType() {
                return new GenericClass<>(Long.class);
            }
        }, params);

        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        result = jdbc.insert(tableName, new HashChainMap<String, Object>().putChain(id, null)
                .putChain(title, "title_02").putChain(content, "content_02"));
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 2);
    }

    @Test
    public void testInsertBatch() {
        int result = 0;
        final String tableName = "cms_article";
        final String id = "id";
        final String title = "title";
        final String content = "content";
        final String[] columnNames = new String[] { id, title, content };

        result = jdbc.update("delete from cms_article");

        result = jdbc.insertBatch(tableName, columnNames, null, "title_batch_01", "content_batch_01", null,
                "title_batch_02", "content_batch_02");
        assertEquals(result, 2);

        List<Map<String, Object>> params = new ArrayList<>();
        params.add(new HashChainMap<String, Object>().putChain(id, null).putChain(title, "title_batch_03")
                .putChain(content, "content_batch_03"));
        params.add(new HashChainMap<String, Object>().putChain(id, null).putChain(title, "title_batch_04")
                .putChain(content, "content_batch_04"));
        params.add(new HashChainMap<String, Object>().putChain(id, null).putChain(title, "title_batch_05")
                .putChain(content, "content_batch_05"));
        result = jdbc.insertBatch(tableName, params);
        assertEquals(result, params.size());
    }

    @Test
    public void testUpsert() {
        int result = 0;
        final String tableName = "app";
        final String id = "id";
        final String code = "code";
        final String name = "name";
        final String platform = "platform";
        final String[] columnNames = new String[] { id, code, name, platform };
        final String[] ukNames = new String[] { code };

        result = jdbc.update("delete from app");

        final Object[] params = new Object[] { null, "code_01", "name_01", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params);
        assertEquals(result, 1);

        final Object[] params2 = new Object[] { null, "code_01", "name_02", Platforms.ANDROID };
        result = jdbc.upsert(tableName, columnNames, ukNames, params2);
        assertEquals(result, 2);

        result = jdbc.upsert(tableName, ukNames, new HashChainMap<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_03").putChain(platform, Platforms.IOS));
        assertEquals(result, 1);

        result = jdbc.upsert(tableName, ukNames, new HashChainMap<String, Object>().putChain(id, null)
                .putChain(code, "code_03").putChain(name, "name_04").putChain(platform, Platforms.IOS));
        assertEquals(result, 2);
        //
        result = jdbc.update("delete from app where code like ?", "code_%");
        assertEquals(result, 2);
    }
}
