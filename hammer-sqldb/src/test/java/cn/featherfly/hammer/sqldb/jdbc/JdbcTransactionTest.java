
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.sqldb.jdbc.transaction.Isolation;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.vo.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;

/**
 * JdbcTest.
 *
 * @author zhongj
 */
public class JdbcTransactionTest extends JdbcTestBase {

    final String tableName = "cms_article";
    final String id = "id";
    final String title = "title";
    final String content = "content";
    final String[] columnNames = new String[] { id, title, content };

    String getSql() {
        return getSql(Lang.getInvoker(2).getMethodName());
    }

    String getSql(String fileName) {
        try {
            File file = new File(
                    ClassLoaderUtils.getResource(".").getPath() + Strings.format("../test/sql/{0}.sql", fileName));
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void testTransactionCommit() {
        Article article;
        int result = 0;
        final String tableName = "cms_article";
        final String id = "id";
        final String title = "title";
        final String content = "content";
        final String[] columnNames = new String[] { id, title, content };
        final Object[] params = new Object[] { null, "title_01", "content_01" };

        Connection conn = getConnection();
        Connection conn2 = getConnection();
        JdbcTransaction jdbc = jdbcFactory.beginTransation(conn, Isolation.READ_COMMITTED);
        JdbcTransaction jdbc2 = jdbcFactory.beginTransation(conn2, Isolation.READ_COMMITTED);

        result = jdbc.update("delete from cms_article");

        final AtomicLong l = new AtomicLong();
        result = jdbc.insert(tableName, columnNames, new GeneratedKeyHolder<Long>() {
            @Override
            public void acceptKey(Long key, int row) {
                l.set(key);
            }

            @Override
            public Type<Long> getType() {
                return new ClassType<>(Long.class);
            }

            @Override
            public void acceptKey(List<Long> keys) {
                l.set(keys.get(0));
            }
        }, params);

        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        // 事务未提交，其他连接获取不到数据
        article = jdbc2.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertNull(article);

        jdbc.commit();
        // 事务提交，其他连接可以获取到数据
        article = jdbc2.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        result = jdbc.insert(tableName, new ChainMapImpl<String, Object>().putChain(id, null)
                .putChain(title, "title_02").putChain(content, "content_02"));
        assertEquals(result, 1);

        result = jdbc.update("delete from cms_article");
        assertEquals(result, 2);
    }

    @Test
    public void testTransactionRollback() {
        Article article;
        int result = 0;
        final String tableName = "cms_article";
        final String id = "id";
        final String title = "title";
        final String content = "content";
        final String[] columnNames = new String[] { id, title, content };
        final Object[] params = new Object[] { null, "title_01", "content_01" };

        Connection conn = getConnection();
        Connection conn2 = getConnection();
        JdbcTransaction jdbc = jdbcFactory.beginTransation(conn, Isolation.READ_COMMITTED);
        JdbcTransaction jdbc2 = jdbcFactory.beginTransation(conn2, Isolation.READ_COMMITTED);

        jdbc.update("delete from cms_article");

        final AtomicLong l = new AtomicLong();
        result = jdbc.insert(tableName, columnNames, new GeneratedKeyHolder<Long>() {
            @Override
            public void acceptKey(Long key, int row) {
                l.set(key);
            }

            @Override
            public Type<Long> getType() {
                return new ClassType<>(Long.class);
            }

            @Override
            public void acceptKey(List<Long> keys) {
                l.set(keys.get(0));
            }
        }, params);
        assertEquals(result, 1);

        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");

        // 事务未提交，其他连接获取不到数据
        article = jdbc2.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertNull(article);

        jdbc.rollback();
        // 事务回滚，插入数据就不存在了
        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertNull(article);
    }

}
