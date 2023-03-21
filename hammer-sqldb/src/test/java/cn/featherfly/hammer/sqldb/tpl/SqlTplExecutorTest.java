
package cn.featherfly.hammer.sqldb.tpl;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.dialect.MySQLDialect;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.structure.ChainMapImpl;
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
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;

/**
 * SqlTplExecutorTest.
 *
 * @author zhongj
 */
public class SqlTplExecutorTest extends JdbcTestBase {

    protected TplExecutor executor;

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
    void testNumber() {
        Integer avg = executor.number("selectAvg", Integer.class, new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.number("selectAvg2", Integer.class, new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testIntValue() {
        Integer avg = executor.numberInt("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberInt(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        assertTrue(avg > 20);

        avg = executor.intValue("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.intValue(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberInt("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testLongValue() {
        Long avg = executor.numberLong("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberLong(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        assertTrue(avg > 20);

        avg = executor.longValue("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.longValue(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberLong("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    void testDoubleValue() {
        Double avg = executor.numberDouble("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberDouble(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        assertTrue(avg > 20);

        avg = executor.doubleValue("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.doubleValue(new TplExecuteIdFileImpl("selectAvg"), new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberDouble("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);
    }

    @Test
    void testBigDecimalValue() {
        BigDecimal avg = executor.numberBigDecimal("selectAvg", new ChainMapImpl<String, Object>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 20);

        avg = executor.numberBigDecimal("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);

        avg = executor.numberBigDecimal(new TplExecuteIdFileImpl("selectAvg2"),
                new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);
    }

    @Test
    void testStringValue() {
        String str = executor.string("selectString", new ChainMapImpl<String, Object>());
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = executor.string("selectString2", new ChainMapImpl<String, Object>().putChain("id", 2));
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Test
    void testSingle() {
        String username = "yufei";
        String password = "123456";
        User u1 = executor.single("user@selectByUsername", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username));

        assertEquals(u1.getUsername(), username);

        User u2 = executor.single("user@selectByUsernameAndPassword", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        u2 = executor.single("selectByUsernameAndPassword", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        //        u2 = executor.single("/tpl/user@selectByUsernameAndPassword", User.class,
        //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));
        // 加入多prefix、suffix支持后的获取
        u2 = executor.single("user@selectByUsernameAndPassword", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);
    }

    @Test
    void testUserList() {
        Integer age = 5;
        List<User> users = executor.list("user@selectUser", User.class, new ChainMapImpl<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("user@selectUserList", User.class, new ChainMapImpl<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("user@selectByAge", User.class, new ChainMapImpl<String, Object>().putChain("age", 5));
        users.forEach(u -> {
            assertEquals(u.getAge(), age);
        });
    }

    @Test
    void testUserList2() {

        List<User> users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>());
        assertTrue(users.size() > 0);

        users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", password + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>()
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

        List<User> users = executor.list("user@selectConditions", User.class, new ChainMapImpl<String, Object>(), start,
                limit);
        assertTrue(users.size() == 3);

        users = executor.list(
                "user@selectConditions", User.class, new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination(start, limit));
        final int size = users.size();
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });
        assertTrue(size == 3);

        List<Map<String, Object>> userList = executor.list(
                "user@selectConditions", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination(start, limit));
        final int size2 = userList.size();
        userList.forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);
    }

    @Test
    void testUserPagination() {
        Integer limit = 3;
        Integer start = 0;

        PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class,
                new ChainMapImpl<String, Object>(), start, limit);
        assertTrue(userPaginationResults.getResultSize() == 3);

        userPaginationResults = executor.pagination(
                "user@selectConditions", User.class, new ChainMapImpl<String, Object>().putChain("minAge", minAge)
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

        PaginationResults<Map<String, Object>> userPage = executor.pagination(
                "user@selectConditions", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"),
                new SimplePagination(start, limit));
        final int size2 = userPage.getResultSize();
        userPage.getPageResults().forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);

        userPage = executor.pagination("user@selectConditions", new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"), start,
                limit);
        userPage.getPageResults().forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);
    }

    @Test
    void testRoleList() {
        List<Role> roles = executor.list("role@selectByName", Role.class,
                new ChainMapImpl<String, Object>().putChain("name", "name%"));
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("name"));
        });
        List<Role> roles2 = executor.list("role@selectByName", Role.class,
                new ChainMapImpl<String, Object>().putChain("name", null));
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
                    new ChainMapImpl<String, Object>().putChain("name", "name%").putChain("dateFormat", dateFormat));
            assertTrue(roles.size() > 0);
            roles.forEach(r -> {
                if (r.get("") != null) {
                    assertTrue(r.get("dateFormat").toString().matches(datePattern));
                }
                assertTrue(r.get("name").toString().startsWith("name"));
            });
            List<Map<String, Object>> roles2 = executor.list(sql,
                    new ChainMapImpl<String, Object>().putChain("name", null).putChain("dateFormat", dateFormat));
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
        List<UserInfo> uis = executor.list("user_info@select", UserInfo.class, new ChainMapImpl<String, Object>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testUserInfoList2() {
        List<UserInfo> uis = executor.list("user_info@select2", UserInfo.class, new ChainMapImpl<String, Object>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate", Role.class,
                new ChainMapImpl<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate2() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate2", Role.class,
                new ChainMapImpl<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate3() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate3", Role.class,
                new ChainMapImpl<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testWithTemplate4() {
        PaginationResults<Map<String, Object>> result = executor.pagination("role@selectWithTemplate4",
                new ChainMapImpl<String, Object>(), 0, 10);
        assertTrue(result.getResultSize() > 0);
        System.out.println("result size:" + result.getResultSize());
        result.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    void testMap() {
        Map<String, Object> uis = executor.single("user_info@selectById",
                new ChainMapImpl<String, Object>().putChain("id", 1));
        assertEquals(uis.get("id").toString(), "1");
        //        assertEquals(uis.get("ID").toString(), "1");
        System.out.println(uis);
    }

    @Test
    void testMapList() {
        List<Map<String, Object>> uis = executor.list("user_info@select2", new ChainMapImpl<String, Object>(), 0, 10);
        assertTrue(uis.size() > 0);
        System.out.println("result size:" + uis.size());
        System.out.println(uis);
    }

    @Test
    void testDuplicateExceptionOneFile() {
        // 配置会读取最下面的同名executeId
        executor.list("duplicate@select", UserInfo.class, new ChainMapImpl<String, Object>());
    }

    @Test(expectedExceptions = HammerException.class)
    void testDuplicateExceptionMulitiFile() {
        // 配置会读取最下面的同名executeId
        executor.list("select", UserInfo.class, new ChainMapImpl<String, Object>());
    }

    @Test
    void testDeepDir() {
        executor.list("dir/user_info@select", UserInfo.class, new ChainMapImpl<String, Object>());
    }

    @Test
    void testDeepDir2() {
        executor.list("selectDir", UserInfo.class, new ChainMapImpl<String, Object>());
    }

    @Test
    void testInsertUpdateDelete() {
        String name = "name_insert_" + Randoms.getString(6);
        String descp = "descp_" + Randoms.getString(6);
        int i = executor.execute("insertRole",
                new ChainMapImpl<String, Object>().putChain("name", name).putChain("descp", descp));
        assertTrue(i == 1);

        Role role = executor.single("getByName", Role.class, new ChainMapImpl<String, Object>().putChain("name", name));
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        descp = "descp_" + Randoms.getString(6);
        i = executor.execute("updateRoleByName",
                new ChainMapImpl<String, Object>().putChain("name", name).putChain("descp", descp));
        assertTrue(i == 1);

        role = executor.single("getByName", Role.class, new ChainMapImpl<String, Object>().putChain("name", name));
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        i = executor.execute("deleteRoleByName", new ChainMapImpl<String, Object>().putChain("name", name));
        assertTrue(i == 1);

        role = executor.single("getByName", Role.class, new ChainMapImpl<String, Object>().putChain("name", name));
        assertEquals(role, null);
    }

    @Test
    void testPrivileType() {
        int i = executor.value("countUserInfo", int.class, new ChainMapImpl<String, Object>());
        assertEquals(i, 2);

        i = executor.value(new TplExecuteIdFileImpl("countUserInfo"), int.class, new ChainMapImpl<String, Object>());
        assertEquals(i, 2);
    }

    @Test
    void testInParams() {
        int resultSize = 3;

        Long[] ids = new Long[] { 1L, 2L, 3L };

        Map<String, Object> params = new ChainMapImpl<String, Object>().putChain("ids", ids);

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
                new ChainMapImpl<String, Object>().putChain("ids", new Long[] { 1L, -1L }));
        assertEquals(user.getId(), new Integer(1));

    }

    @Test
    void testInParams2() {
        int resultSize = 4;

        Long[] ids = new Long[] { 1L, 2L, 3L, 4L };

        Map<String, Object> params = new ChainMapImpl<String, Object>().putChain("ids", ids);

        List<User> users;

        // list
        users = executor.list("selectIn2", User.class, params);
        assertEquals(users.size(), resultSize);
    }

    @Test
    void testSingleTuple2() {
        Integer userId = 1;
        // list
        Tuple2<UserInfo, User> tuple2 = executor.single("selectUserInfoByUserId", UserInfo.class, User.class,
                Tuples.of("ui.", "u."), new ChainMapImpl<String, Object>().putChain("userId", userId));

        System.out.println(tuple2.get0());
        System.out.println(tuple2.get1());

        assertEquals(userId, tuple2.get0().getUser().getId());
        assertEquals(userId, tuple2.get1().getId());
    }

    @Test
    void testSingleTuple2_2() {
        Integer userId = 1;
        // list
        Tuple2<UserInfo, User> tuple2 = executor.single("selectUserInfoByUserId", UserInfo.class, User.class,
                new ChainMapImpl<String, Object>().putChain("userId", userId));

        System.out.println(tuple2.get0());
        System.out.println(tuple2.get1());

        assertEquals(userId, tuple2.get0().getUser().getId());
        assertEquals(userId, tuple2.get1().getId());
    }

    @Test
    void testSingleTuple2List() {
        // list
        List<Tuple2<UserInfo, User>> list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class,
                Tuples.of("ui.", "u."), new ChainMapImpl<String, Object>());
        assertEquals(list.size(), 2);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class, Tuples.of("ui.", "u."),
                new ChainMapImpl<String, Object>(), 0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testSingleTuple2List_2() {
        // list
        List<Tuple2<UserInfo, User>> list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class,
                new ChainMapImpl<String, Object>());
        assertEquals(list.size(), 2);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class,
                new ChainMapImpl<String, Object>(), 0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testSingleTuple2Page() {
        PaginationResults<Tuple2<UserInfo, User>> page = executor.pagination("selectUserInfoAndUserList",
                UserInfo.class, User.class, Tuples.of("ui.", "u."), new ChainMapImpl<String, Object>(), 0, 10);
        assertEquals(page.getTotal(), new Integer(2));
        assertEquals(page.getPageResults().size(), 2);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = executor.pagination("selectUserInfoAndUserList", UserInfo.class, User.class, Tuples.of("ui.", "u."),
                new ChainMapImpl<String, Object>(), 0, 1);
        assertEquals(page.getTotal(), new Integer(2));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testSingleTuple2Page_2() {
        int pageSize = 2;
        PaginationResults<Tuple2<UserInfo, User>> page = executor.pagination("selectUserInfoAndUserList",
                UserInfo.class, User.class, new ChainMapImpl<String, Object>(), 0, pageSize);
        assertEquals(page.getTotal(), new Integer(2));
        assertEquals(page.getPageResults().size(), 2);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = executor.pagination("selectUserInfoAndUserList", UserInfo.class, User.class,
                new ChainMapImpl<String, Object>(), 0, 1);
        assertEquals(page.getSize(), new Integer(1));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }
}
