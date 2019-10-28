
package cn.featherfly.juorm.rdb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.vo.Role;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;
import cn.featherfly.juorm.tpl.FreemarkerTemplateProcessor;
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

    @BeforeMethod
    void setup() {
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl/");
        executor = new SqlTplExecutor(configFactory, new FreemarkerTemplateProcessor(configFactory), jdbc,
                mappingFactory);
    }

    @Test
    void testNumberValue() {
        Integer avg = executor.intValue("selectAvg", new HashChainMap<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.intValue("selectAvg2", new HashChainMap<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testStringValue() {
        String str = executor.stringValue("selectString", new HashChainMap<String, Object>());
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = executor.stringValue("selectString2", new HashChainMap<String, Object>().putChain("id", 2));
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Test
    void testSingle() {
        String username = "yufei";
        String password = "123456";
        User u1 = executor.single("user@selectByUsername", User.class,
                new HashChainMap<String, Object>().putChain("username", username));

        assertEquals(u1.getUsername(), username);

        User u2 = executor.single("user@selectByUsernameAndPassword", User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        u2 = executor.single("selectByUsernameAndPassword", User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        u2 = executor.single("/tpl/user@selectByUsernameAndPassword", User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);
    }

    @Test
    void testUserList() {
        Integer age = 5;
        List<User> users = executor.list("user@selectUser", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("user@selectByAge", User.class, new HashChainMap<String, Object>().putChain("age", 5));
        users.forEach(u -> {
            assertEquals(u.getAge(), age);
        });
    }

    @Test
    void testUserList2() {

        List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", password + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
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

        List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>(), start,
                limit);
        assertTrue(users.size() == 3);

        users = executor.list(
                "user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination(start, limit));
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

        PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class,
                new HashChainMap<String, Object>(), start, limit);
        assertTrue(userPaginationResults.getResultSize() == 3);

        userPaginationResults = executor.pagination(
                "user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination(start, limit));
        final int size = userPaginationResults.getResultSize();
        assertTrue(userPaginationResults.getTotal() == 4);
        userPaginationResults.getPageResults().forEach(u -> {
            System.err.println(u);
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });
        assertTrue(size == 3);
    }

    @Test
    void testRoleList() {
        List<Role> roles = executor.list("role@selectByName", Role.class,
                new HashChainMap<String, Object>().putChain("name", "n\\_%"));
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("n_"));
        });
        List<Role> roles2 = executor.list("role@selectByName", Role.class,
                new HashChainMap<String, Object>().putChain("name", null));
        assertTrue(roles2.size() > roles.size());
    }

    @Test
    void testUserInfoList() {
        List<UserInfo> uis = executor.list("user_info@select", UserInfo.class, new HashChainMap<String, Object>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testUserInfoList2() {
        List<UserInfo> uis = executor.list("user_info@select2", UserInfo.class, new HashChainMap<String, Object>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate", Role.class,
                new HashChainMap<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate2() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate2", Role.class,
                new HashChainMap<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate3() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate3", Role.class,
                new HashChainMap<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testMap() {
        Map<String, Object> uis = executor.single("user_info@selectById",
                new HashChainMap<String, Object>().putChain("id", 1));
        assertEquals(uis.get("id").toString(), "1");
        System.out.println(uis);
    }

    @Test
    void testMapList() {
        List<Map<String, Object>> uis = executor.list("user_info@select2", new HashChainMap<String, Object>(), 0, 10);
        assertTrue(uis.size() > 0);
        System.out.println("result size:" + uis.size());
        System.out.println(uis);
    }

    @Test
    void testDuplicateExceptionOneFile() {
        // 配置会读取最下面的同名executeId
        executor.list("duplicate@select", UserInfo.class, new HashChainMap<String, Object>());
    }

    @Test(expectedExceptions = JuormException.class)
    void testDuplicateExceptionMulitiFile() {
        // 配置会读取最下面的同名executeId
        executor.list("select", UserInfo.class, new HashChainMap<String, Object>());
    }
}
