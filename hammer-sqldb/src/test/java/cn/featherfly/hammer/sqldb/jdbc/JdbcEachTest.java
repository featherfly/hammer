
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.mappers.PlatformJavaSqlTypeMapper;
import cn.featherfly.common.lang.AutoCloseableIterable;
import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.App;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.AppVersion;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

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
        RowIterable<Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        Iterator<Map<String, Serializable>> iter = ids.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        assertTrue(size == 1);
        // 如果jdbc（或连接池）驱动connection close方法没有自动关闭其打开的资源，并且没有使用CascadeCloseDataSource包装,则这里需要手动关闭
        // ids.close();
        jdbc.close(); // 手动关闭链接

        System.out.println("");
    }

    @Test
    public void queryEach2() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        //        JdbcTransaction tran = jdbc.beginTransation();
        RowIterable<Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        int size = 0;
        for (Map<String, Serializable> value : ids) {
            System.out.println(value);
            size++;
        }
        assertTrue(size == 1);
        // 如果jdbc（或连接池）驱动connection close方法没有自动关闭其打开的资源，并且没有使用CascadeCloseDataSource包装,则这里需要手动关闭
        ids.close();
        jdbc.close(); // 手动关闭链接
    }

    @Test
    public void queryEach2TryWithResouce() throws Exception {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        try (AutoCloseableIterable<
            Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1)) {
            int size = 0;
            for (Map<String, Serializable> value : ids) {
                System.out.println(value);
                size++;
            }
            assertTrue(size == 1);
        }
        jdbc.close(); // 手动关闭链接
    }

    @Test
    public void queryEachEntity() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        RowIterable<User> users = jdbc.queryEach("select id,username from user where id in (?,?)", User.class, 1, 2);
        Iterator<User> iter = users.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            User u = iter.next();
            System.out.println(u);
            assertTrue(u.getId() == size);
        }
        assertTrue(size == 2);
        // 如果jdbc（或连接池）驱动connection close方法没有自动关闭其打开的资源，并且没有使用CascadeCloseDataSource包装,则这里需要手动关闭
        users.close();
        jdbc.close(); // 手动关闭链接
    }

    @Test(expectedExceptions = JdbcException.class, expectedExceptionsMessageRegExp = "[\\s\\S]+close[\\s\\S]*")
    public void queryEachExceptionConnClosed() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        RowIterable<Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id = ?", 1);
        Iterator<Map<String, Serializable>> iter = ids.iterator();

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
        Iterable<Map<String, Serializable>> ids = jdbc.queryEach("select * from role where id in (?,?)", 1, 2);
        Iterator<Map<String, Serializable>> iter = ids.iterator();
        System.out.println(iter.hasNext());
        System.out.println(iter.hasNext());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next()); // 这里会报错，因为只有两条数据
        jdbc.close();
    }

    @Test
    public void queryListIter() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        JdbcTransaction tran = jdbc.beginTransation();
        List<Map<String, Serializable>> ids = jdbc.queryList("select * from role where id = ?", 1);
        Iterator<Map<String, Serializable>> iter = ids.iterator();
        int size = 0;
        while (iter.hasNext()) {
            size++;
            iter.next();
        }
        assertTrue(size == 1);

        tran.commit();
        jdbc.close();
    }

    @Test
    public void callMulitiQueryIter() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        JdbcTransaction tran = jdbc.beginTransation();
        Integer uid = 1;
        Serializable[] params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery("call_query_user_by_id2", params)) {
            assertEquals(params[0], uid + 1);
            int queryNum = 3;
            int i = 0;
            while (query.hasNext()) {
                i++;
                query.next();
            }
            assertEquals(i, queryNum); // 三个查询
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery("call_query_user_by_id2", params)) {
            assertEquals(params[0], uid + 1);
            for (User user : query.next(User.class)) {
                assertEquals(user.getId(), uid);
            }
            for (UserInfo2 ui : query.next(UserInfo2.class)) {
                assertEquals(ui.getUserId(), uid);
            }
            for (Map<String, Serializable> order : query.next()) {
                assertEquals(order.get("create_user"), uid);
            }
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        tran.commit();
        jdbc.close();
    }

    @Test
    public void callMulitiQueryIter6() {
        JdbcSession jdbc = jdbcFactory.createSession(dataSource);
        JdbcTransaction tran = jdbc.beginTransation();
        final String name = "call_query_user_by_id6";
        Integer uid = 1;
        Serializable[] params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery(name, params)) {
            assertEquals(params[0], uid + 1);
            int i = 0;
            while (query.hasNext()) {
                i++;
                query.next();
            }
            assertEquals(i, 6); // 六个查询
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        params = new Serializable[] { uid };
        try (MulitiQuery query = jdbc.callMultiQuery(name, params)) {
            assertEquals(params[0], uid + 1);
            for (User user : query.next(User.class)) {
                assertEquals(user.getId(), uid);
            }
            for (UserInfo2 ui : query.next(UserInfo2.class)) {
                assertEquals(ui.getUserId(), uid);
            }
            for (Order2 order : query.next(Order2.class)) {
                assertEquals(order.getCreateUser(), uid);
            }
            for (Map<String, Serializable> orderInfo : query.next()) {
                assertEquals(orderInfo.get("create_user"), uid);
            }
            for (UserRole userRole : query.next(UserRole.class)) {
                assertEquals(userRole.getUserId(), uid);
            }
            for (Map<String, Serializable> user : query.next()) {
                assertEquals(user.get("id"), uid);
            }
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        tran.commit();
        jdbc.close();
    }
}
