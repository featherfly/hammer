
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * JdbcTest.
 *
 * @author zhongj
 */
public class JdbcEachTest extends JdbcTestBase {

    @BeforeClass
    void before() {
        PlatformJavaSqlTypeMapper platformJavaSqlTypeMapper = new PlatformJavaSqlTypeMapper();

        mappingFactory.getSqlTypeMappingManager()
            .regist(BeanDescriptor.getBeanDescriptor(App.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
        mappingFactory.getSqlTypeMappingManager().regist(
            BeanDescriptor.getBeanDescriptor(AppVersion.class).getBeanProperty("platform"), platformJavaSqlTypeMapper);
    }

    @Test
    public void queryEach() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        Iterable<Map<String, Object>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        Iterator<Map<String, Object>> iter = ids.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        assertTrue(size == 1);
        jdbc.close(); // 手动关闭链接
    }

    @Test
    public void queryEach2() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        //        JdbcTransaction tran = jdbc.beginTransation();
        Iterable<Map<String, Object>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        int size = 0;
        for (Map<String, Object> value : ids) {
            System.out.println(value);
            size++;
        }
        assertTrue(size == 1);
        jdbc.close(); // 手动关闭链接
    }

    @Test
    public void queryEachEntity() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        Iterable<User> users = jdbc.queryEach("select id,username from user where id in (?,?)", User.class, 1, 2);
        Iterator<User> iter = users.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            User u = iter.next();
            System.out.println(u);
            assertTrue(u.getId() == size);
        }
        assertTrue(size == 2);
        jdbc.close(); // 手动关闭链接
    }

    @Test(expectedExceptions = JdbcException.class, expectedExceptionsMessageRegExp = "[\\s\\S]+close[\\s\\S]*")
    public void queryEachExceptionConnClosed() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        Iterable<Map<String, Object>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        Iterator<Map<String, Object>> iter = ids.iterator();

        jdbc.close(); // 手动关闭链接

        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next(); // 这里会报错，因为连接已经关闭
        }
        assertTrue(size == 1);

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void queryEachNoSuchElementException() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        Iterable<Map<String, Object>> ids = jdbc.queryEach("select * from role where id in (?,?)", 1, 2);
        Iterator<Map<String, Object>> iter = ids.iterator();
        System.out.println(iter.hasNext());
        System.out.println(iter.hasNext());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next()); // 这里会报错，因为只有两条数据
        jdbc.close();
    }

    @Test
    public void queryEach3() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        JdbcTransaction tran = jdbc.beginTransation();
        List<Map<String, Object>> ids = jdbc.queryList("select * from role where id = ?", 1);
        Iterator<Map<String, Object>> iter = ids.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        assertTrue(size == 1);

        tran.commit();
    }
}
