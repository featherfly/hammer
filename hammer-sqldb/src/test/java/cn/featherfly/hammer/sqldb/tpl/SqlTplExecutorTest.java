
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
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
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.TestConstants;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;

/**
 * SqlTplExecutorTest.
 *
 * @author zhongj
 */
public class SqlTplExecutorTest extends JdbcTestBase {

    protected TplExecutor executor;

    protected TplExecuteIdParser parser;

    Integer minAge = 5;
    Integer maxAge = 40;
    String username1 = "yufei";
    String username2 = "featherfly";
    String password = "123";

    @BeforeMethod
    public void setup() {
        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
                .config(hammerConfig.getTemplateConfig()).build();
        HammerConfig config = new HammerConfigImpl(devMode);
        parser = config.getTemplateConfig().getTplExecuteIdParser();
        executor = new SqlTplExecutor(config, configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory, new SimpleSqlPageFactory(), new TransverterManager());
    }

    @Test
    public void testNumber() {
        Integer avg = executor.number("selectAvg", Integer.class, new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.number("selectAvg2", Integer.class, new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    public void testIntValue() {
        Integer avg = executor.numberInt("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberInt(parser.parse("selectAvg"), new ChainMapImpl<>());
        assertTrue(avg > 20);

        avg = executor.intValue("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.intValue(parser.parse("selectAvg"), new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberInt("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    public void testLongValue() {
        Long avg = executor.numberLong("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberLong(parser.parse("selectAvg"), new ChainMapImpl<>());
        assertTrue(avg > 20);

        avg = executor.longValue("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.longValue(parser.parse("selectAvg"), new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberLong("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Test
    public void testDoubleValue() {
        Double avg = executor.numberDouble("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberDouble(parser.parse("selectAvg"), new ChainMapImpl<>());
        assertTrue(avg > 20);

        avg = executor.doubleValue("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.doubleValue(parser.parse("selectAvg"), new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = executor.numberDouble("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);
    }

    @Test
    public void testBigIntegerValue() {
        BigInteger avg = executor.numberBigInteger("selectSum", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 20);

        avg = executor.numberBigInteger("selectSum2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 40);

        avg = executor.numberBigInteger(parser.parse("selectSum2"),
                new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 40);
    }

    @Test
    public void testBigDecimalValue() {
        BigDecimal avg = executor.numberBigDecimal("selectAvg", new ChainMapImpl<>());
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 20);

        avg = executor.numberBigDecimal("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);

        avg = executor.numberBigDecimal(parser.parse("selectAvg2"),
                new ChainMapImpl<String, Object>().putChain("age", 40));
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);
    }

    @Test
    public void testStringValue() {
        String str = executor.string("selectString", new ChainMapImpl<>());
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = executor.string("selectString2", new ChainMapImpl<String, Object>().putChain("id", 2));
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Test
    public void testSingle() {
        String username = "yufei";
        String password = "123456";
        User u1 = executor.single("selectByUsername@user", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username));

        assertEquals(u1.getUsername(), username);

        User u2 = executor.single("selectByUsernameAndPassword@user", User.class,
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
        u2 = executor.single("selectByUsernameAndPassword@user", User.class,
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);
    }

    @Test
    public void testUserList() {
        Integer age = 5;
        List<User> users = executor.list("selectUser@user", User.class, new ChainMapImpl<>());
        assertTrue(users.size() > 0);

        users = executor.list("selectUserList@user", User.class, new ChainMapImpl<>());
        assertTrue(users.size() > 0);

        users = executor.list("selectByAge@user", User.class, new ChainMapImpl<String, Object>().putChain("age", 5));
        users.forEach(u -> {
            assertEquals(u.getAge(), age);
        });
    }

    @Test
    public void testUserList2() {

        List<User> users = executor.list("selectConditions@user", User.class, new ChainMapImpl<>());
        assertTrue(users.size() > 0);

        users = executor.list("selectConditions@user", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = executor.list("selectConditions@user", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = executor.list("selectConditions@user", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", password + "%"));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = executor.list("selectConditions@user", User.class, new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("password", "%" + password));
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().endsWith(password));
        });
    }

    @Test
    public void testUserPageList() {
        Integer limit = 3;
        Integer start = 0;

        List<User> users = executor.list("selectConditions@user", User.class, new ChainMapImpl<>(), start, limit);
        assertTrue(users.size() == 3);

        users = executor.list(
                "selectConditions@user", User.class, new ChainMapImpl<String, Object>().putChain("minAge", minAge)
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
                "selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
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
    public void testUserPagination() {
        Integer limit = 3;
        Integer start = 0;

        PaginationResults<User> userPaginationResults = executor.pagination("selectConditions@user", User.class,
                new ChainMapImpl<>(), start, limit);
        assertTrue(userPaginationResults.getResultSize() == 3);

        userPaginationResults = executor.pagination(
                "selectConditions@user", User.class, new ChainMapImpl<String, Object>().putChain("minAge", minAge)
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
                "selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
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

        userPage = executor.pagination("selectConditions@user", new ChainMapImpl<String, Object>()
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
    public void testRoleList() {
        List<Role> roles = executor.list("selectByName@role", Role.class,
                new ChainMapImpl<String, Object>().putChain("name", "name%"));
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("name"));
        });
        List<Role> roles2 = executor.list("selectByName@role", Role.class,
                new ChainMapImpl<String, Object>().putChain("name", null));
        assertTrue(roles2.size() > roles.size());
    }

    @Test
    public void testRoleListWithFomat() {
        String sql = null;
        final String dateFormat;
        final String datePattern;
        if (dialect instanceof MySQLDialect) {
            sql = "selectByName_mysql@role";
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
    public void testUserInfoList() {
        List<UserInfo> uis = executor.list("select@user_info", UserInfo.class, new ChainMapImpl<>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testUserInfoList2() {
        List<UserInfo> uis = executor.list("select2@user_info", UserInfo.class, new ChainMapImpl<>());
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testWithTemplate() {
        PaginationResults<Role> uis = executor.pagination("selectWithTemplate@role", Role.class, new ChainMapImpl<>(),
                0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testWithTemplate2() {
        PaginationResults<Role> uis = executor.pagination("selectWithTemplate2@role", Role.class, new ChainMapImpl<>(),
                0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testWithTemplate3() {
        PaginationResults<Role> uis = executor.pagination("selectWithTemplate3@role", Role.class, new ChainMapImpl<>(),
                0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testWithTemplate4() {
        PaginationResults<Map<String, Object>> result = executor.pagination("selectWithTemplate4@role",
                new ChainMapImpl<>(), 0, 10);
        assertTrue(result.getResultSize() > 0);
        System.out.println("result size:" + result.getResultSize());
        result.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void testMap() {
        Map<String, Object> uis = executor.single("selectById@user_info",
                new ChainMapImpl<String, Object>().putChain("id", 1));
        assertEquals(uis.get("id").toString(), "1");
        //        assertEquals(uis.get("ID").toString(), "1");
        System.out.println(uis);
    }

    @Test
    public void testMapList() {
        List<Map<String, Object>> uis = executor.list("select2@user_info", new ChainMapImpl<>(), 0, 10);
        assertTrue(uis.size() > 0);
        System.out.println("result size:" + uis.size());
        System.out.println(uis);
    }

    @Test
    public void testDuplicateExceptionOneFile() {
        // 配置会读取最下面的同名executeId
        executor.list("select@duplicate", UserInfo.class, new ChainMapImpl<>());
    }

    @Test(expectedExceptions = HammerException.class)
    public void testDuplicateExceptionMulitiFile() {
        // 配置会读取最下面的同名executeId
        executor.list("select", UserInfo.class, new ChainMapImpl<>());
    }

    @Test
    public void testDeepDir() {
        executor.list("select@dir/user_info", UserInfo.class, new ChainMapImpl<>());
    }

    @Test
    public void testDeepDir2() {
        executor.list("selectDir", UserInfo.class, new ChainMapImpl<>());
    }

    @Test
    public void testInsertUpdateDelete() {
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
    public void testPrivileType() {
        int i = executor.value("countUserInfo", int.class, new ChainMapImpl<>());
        assertEquals(i, TestConstants.USER_INFO_INIT_ROWS);

        i = executor.value(parser.parse("countUserInfo"), int.class, new ChainMapImpl<>());
        assertEquals(i, TestConstants.USER_INFO_INIT_ROWS);
    }

    @Test
    public void testInParams() {
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
        assertEquals(p.getTotal(), Integer.valueOf(ids.length));

        // single
        User user = executor.single("selectInSingle", User.class,
                new ChainMapImpl<String, Object>().putChain("ids", new Long[] { 1L, -1L }));
        assertEquals(user.getId(), Integer.valueOf(1));

    }

    @Test
    public void testInParams2() {
        int resultSize = 4;

        Long[] ids = new Long[] { 1L, 2L, 3L, 4L };

        Map<String, Object> params = new ChainMapImpl<String, Object>().putChain("ids", ids);

        List<User> users;

        // list
        users = executor.list("selectIn2", User.class, params);
        assertEquals(users.size(), resultSize);
    }

    @Test
    public void testInParams3() {
        int resultSize = 4;

        Long[] ids = new Long[] { 1L, 2L, 3L, 4L };

        List<User> users;

        // list
        users = executor.list(new TplExecuteIdFileImpl("selectIn3", null, parser), User.class, new Object[] { ids });
        assertEquals(users.size(), resultSize);

        users = executor.list(new TplExecuteIdFileImpl("selectIn3_2", null, parser), User.class, new Object[] { ids });
        assertEquals(users.size(), resultSize);

        users = executor.list(new TplExecuteIdFileImpl("selectIn3_3", null, parser), User.class,
                new Object[] { ids, 0 });
        assertEquals(users.size(), resultSize);

        users = executor.list(new TplExecuteIdFileImpl("selectIn3_4", null, parser), User.class,
                new Object[] { ids, 0 });
        assertEquals(users.size(), resultSize);
    }

    @Test
    public void testSingleTuple2() {
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
    public void testSingleTuple2_2() {
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
    public void testSingleTuple2List() {
        // list
        List<Tuple2<UserInfo, User>> list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class,
                Tuples.of("ui.", "u."), new ChainMapImpl<>());
        assertEquals(list.size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class, Tuples.of("ui.", "u."),
                new ChainMapImpl<>(), 0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    public void testSingleTuple2List_2() {
        // list
        List<Tuple2<UserInfo, User>> list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class,
                new ChainMapImpl<>());
        assertEquals(list.size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = executor.list("selectUserInfoAndUserList", UserInfo.class, User.class, new ChainMapImpl<>(), 0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    public void testSingleTuple2Page() {
        PaginationResults<Tuple2<UserInfo, User>> page = executor.pagination("selectUserInfoAndUserList",
                UserInfo.class, User.class, Tuples.of("ui.", "u."), new ChainMapImpl<>(), 0, 10);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = executor.pagination("selectUserInfoAndUserList", UserInfo.class, User.class, Tuples.of("ui.", "u."),
                new ChainMapImpl<>(), 0, 1);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    public void testSingleTuple2Page_2() {
        int pageSize = 2;
        PaginationResults<Tuple2<UserInfo, User>> page = executor.pagination("selectUserInfoAndUserList",
                UserInfo.class, User.class, new ChainMapImpl<>(), 0, pageSize);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), pageSize);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = executor.pagination("selectUserInfoAndUserList", UserInfo.class, User.class, new ChainMapImpl<>(), 0, 1);
        assertEquals(page.getSize(), Integer.valueOf(1));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    public void selectConditions2() {
        Map<String, Object> u = executor.single("selectById2@user",
                new ChainMapImpl<String, Object>().putChain("id", 1));

        Map<String, Object> uis = executor.single("selectConditions2@user",
                new ChainMapImpl<String, Object>().putChain("username", u.get("username")) //
                        .putChain("mobile", u.get("mobileNo")) //
                        .putChain("age", -1) //
                        .putChain("id", u.get("id")) //
                        .putChain("password", u.get("password")));
        assertNotNull(uis);
        assertEquals(uis.get("id"), u.get("id"));
        assertEquals(uis.get("mobileNo"), u.get("mobileNo"));
        assertEquals(uis.get("password"), u.get("password"));
        assertEquals(uis.get("username"), u.get("username"));

        //        <@and if=age??>id = :id</@and>
        //        <@and if=age??>age > :age</@and>
        //        <@and>
        //        (
        //            <#if test=username??>username = :username</#if>
        //            <@or if=password??>password = :password</@or>
        //            <@or if=mobile??>mobile_no = :mobile</@or>
        //        )
        //        </@and>
    }
}
