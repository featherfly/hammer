
package cn.featherfly.juorm.rdb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplExecutorTest extends JdbcTestBase {

    SqlTplExecutor executor;

    Integer minAge = 5;
    Integer maxAge = 40;
    String username1 = "yufei";
    String username2 = "featherfly";
    String password = "123";

    @BeforeClass
    void init() {
        ConstantConfigurator.config();
    }

    @BeforeMethod
    void setup() {
        executor = new SqlTplExecutor(new TplConfigFactoryImpl(), jdbc, factory);
    }

    @Test
    void testSingle() {
        String username = "yufei";
        String password = "123456";
        User u1 = executor.single("tpl/user@selectByUsername", User.class,
                new HashChainMap<String, Object>().putChain("username", username));

        assertEquals(u1.getUsername(), username);

        User u2 = executor.single("tpl/user@selectByUsernameAndPassword", User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);
    }

    @Test
    void testUserList() {
        Integer age = 5;
        List<User> users = executor.list("tpl/user@selectUser", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("tpl/user@selectByAge", User.class,
                new HashChainMap<String, Object>().putChain("age", 5));
        users.forEach(u -> {
            assertEquals(u.getAge(), age);
        });
    }

    @Test
    void testUserList2() {

        List<User> users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", password + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", "%" + password));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().endsWith(password));
        });
    }

    @Test
    void testUserPageList() {
        Integer limit = 3;
        Integer start = 0;

        List<User> users = executor.list("tpl/user@selectConditions", User.class, new HashChainMap<String, Object>(),
                start, limit);
        assertTrue(users.size() == 3);

        users = executor.list(
                "tpl/user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination<>(start, limit));
        final int size = users.size();
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
            assertTrue(size == 3);
        });
    }

    @Test
    void testUserPagination() {
        Integer limit = 3;
        Integer start = 0;

        PaginationResults<User> userPaginationResults = executor.pagination("tpl/user@selectConditions", User.class,
                new HashChainMap<String, Object>(), start, limit);
        assertTrue(userPaginationResults.getResultSize() == 3);

        userPaginationResults = executor.pagination(
                "tpl/user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination<>(start, limit));
        final int size = userPaginationResults.getResultSize();
        assertTrue(userPaginationResults.getTotal() == 4);
        userPaginationResults.getPageResults().forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
            assertTrue(size == 3);
        });
    }

    @Test
    void testRoleList() {
        List<Role> roles = executor.list("tpl/role@selectByName", Role.class,
                new HashChainMap<String, Object>().putChain("name", "n_%"));
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("n_"));
        });
        List<Role> roles2 = executor.list("tpl/role@selectByName", Role.class,
                new HashChainMap<String, Object>().putChain("name", null));
        assertTrue(roles2.size() > roles.size());
    }
}
