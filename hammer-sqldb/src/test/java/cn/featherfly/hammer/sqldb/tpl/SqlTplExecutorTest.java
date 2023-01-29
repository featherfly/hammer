
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.db.dialect.MySQLDialect;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TransverterManager;

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
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl");
        executor = new SqlTplExecutor(configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory, new SimpleSqlPageFactory(), new TransverterManager());
    }

    @Test
    void testNumberValue() {
        Integer avg = executor.numberInt("selectAvg", new HashChainMap<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberInt("selectAvg2", new HashChainMap<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testStringValue() {
        String str = executor.string("selectString", new HashChainMap<String, Object>());
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = executor.string("selectString2", new HashChainMap<String, Object>().putChain("id", 2));
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

        //        u2 = executor.single("/tpl/user@selectByUsernameAndPassword", User.class,
        //                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));
        // 加入多prefix、suffix支持后的获取
        u2 = executor.single("user@selectByUsernameAndPassword", User.class,
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
                new HashChainMap<String, Object>().putChain("name", "name%"));
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("name"));
        });
        List<Role> roles2 = executor.list("role@selectByName", Role.class,
                new HashChainMap<String, Object>().putChain("name", null));
        assertTrue(roles2.size() > roles.size());
    }

    @Test
    void testRoleListWithFomat() {
        String sql = null;
        final String dateFormat;
        final String datePattern;
        if (dialect instanceof MySQLDialect) {
            sql = "role@selectByName_mysql";
            dateFormat = "%Y-%m-%d";
            datePattern = "(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)";
        } else {
            dateFormat = "%Y-%m-%d";
            datePattern = "(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)";
        }

        if (sql != null) {
            List<Map<String, Object>> roles = executor.list(sql,
                    new HashChainMap<String, Object>().putChain("name", "name%").putChain("dateFormat", dateFormat));
            assertTrue(roles.size() > 0);
            roles.forEach(r -> {
                if (r.get("") != null) {
                    assertTrue(r.get("dateFormat").toString().matches(datePattern));
                }
                assertTrue(r.get("name").toString().startsWith("name"));
            });
            List<Map<String, Object>> roles2 = executor.list(sql,
                    new HashChainMap<String, Object>().putChain("name", null).putChain("dateFormat", dateFormat));
            assertTrue(roles2.size() > roles.size());
            roles.forEach(r -> {
                if (r.get("") != null) {
                    assertTrue(r.get("dateFormat").toString().matches(datePattern));
                }
            });
        }
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
        //        assertEquals(uis.get("ID").toString(), "1");
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

    @Test(expectedExceptions = HammerException.class)
    void testDuplicateExceptionMulitiFile() {
        // 配置会读取最下面的同名executeId
        executor.list("select", UserInfo.class, new HashChainMap<String, Object>());
    }

    @Test
    void testDeepDir() {
        executor.list("dir/user_info@select", UserInfo.class, new HashChainMap<String, Object>());
    }

    @Test
    void testDeepDir2() {
        executor.list("selectDir", UserInfo.class, new HashChainMap<String, Object>());
    }

    @Test
    void testInsertUpdateDelete() {
        String name = "name_insert_" + Randoms.getString(6);
        String descp = "descp_" + Randoms.getString(6);
        int i = executor.execute("insertRole",
                new HashChainMap<String, Object>().putChain("name", name).putChain("descp", descp));
        assertTrue(i == 1);

        Role role = executor.single("getByName", Role.class, new HashChainMap<String, Object>().putChain("name", name));
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        descp = "descp_" + Randoms.getString(6);
        i = executor.execute("updateRoleByName",
                new HashChainMap<String, Object>().putChain("name", name).putChain("descp", descp));
        assertTrue(i == 1);

        role = executor.single("getByName", Role.class, new HashChainMap<String, Object>().putChain("name", name));
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        i = executor.execute("deleteRoleByName", new HashChainMap<String, Object>().putChain("name", name));
        assertTrue(i == 1);

        role = executor.single("getByName", Role.class, new HashChainMap<String, Object>().putChain("name", name));
        assertEquals(role, null);
    }

    @Test
    void testPrivileType() {
        int i = executor.value("countRole", int.class, new HashChainMap<String, Object>());
        System.out.println(i);
    }

    @Test
    void testInParams() {
        int resultSize = 3;

        Long[] ids = new Long[] { 1L, 2L, 3L };

        Map<String, Object> params = new HashChainMap<String, Object>().putChain("ids", ids);

        List<User> users;
        // list
        users = executor.list("selectIn", User.class, params);
        assertEquals(users.size(), resultSize);

        // value
        int size = executor.value("selectInCount", int.class, params);
        assertEquals(size, resultSize);

        //  list page
        resultSize = 2;
        users = executor.list("selectIn", User.class, params, 0, 2);
        assertEquals(users.size(), resultSize);

        //  pagination
        PaginationResults<User> p = executor.pagination("selectIn", User.class, params, 0, 2);
        assertEquals(p.getPageResults().size(), resultSize);
        assertEquals(p.getTotal(), new Integer(ids.length));

        // single
        User user = executor.single("selectInSingle", User.class,
                new HashChainMap<String, Object>().putChain("ids", new Long[] { 1L, -1L }));
        assertEquals(user.getId(), new Integer(1));

    }

    @Test
    void testInParams2() {
        int resultSize = 4;

        Long[] ids = new Long[] { 1L, 2L, 3L, 4L };

        Map<String, Object> params = new HashChainMap<String, Object>().putChain("ids", ids);

        List<User> users;

        // list
        users = executor.list("selectIn2", User.class, params);
        assertEquals(users.size(), resultSize);
    }
}
