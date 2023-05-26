
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article;

/**
 * JdbcTransactionTest.
 *
 * @author zhongj
 */
public class JdbcTransactionTest extends JdbcTestBase {

    final String tableName = "cms_article";
    final String id = "id";
    final String title = "title";
    final String content = "content";
    final String[] columnNames = new String[] { id, title, content };

    @BeforeClass
    void before() {
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
        JdbcSession jdbc = jdbcFactory.createSession(conn);
        JdbcSession jdbc2 = jdbcFactory.createSession(conn2);

        JdbcTransaction tran = jdbc.beginTransation();

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

        tran.commit();
        // 事务提交，其他连接可以获取到数据
        article = jdbc2.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertEquals(article.getTitle(), "title_01");
        assertEquals(article.getContent(), "content_01");
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
        JdbcSession jdbc = jdbcFactory.createSession(conn);
        JdbcSession jdbc2 = jdbcFactory.createSession(conn2);

        JdbcTransaction tran = jdbc.beginTransation();
        JdbcTransaction tran2 = jdbc2.beginTransation();

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

        tran.rollback();
        // 事务回滚，插入数据就不存在了
        article = jdbc.querySingle("select * from cms_article where id = ?", Article.class, l.longValue());
        assertNull(article);
        jdbc.close();

        tran2.rollback();
        jdbc2.close();
    }

}
