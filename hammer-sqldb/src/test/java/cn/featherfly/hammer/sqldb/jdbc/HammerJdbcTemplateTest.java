
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.dialect.MySQLDialect;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.sqldb.SqldbHammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.TestConstants;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutorTest;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcTemplateTest extends SqlTplExecutorTest {

    SqldbHammer hammer;

    TplExecuteIdParser parser;

    @BeforeClass
    public void before() {
        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
                .build();
        parser = configFactory.getParser();
        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory,
                new SqldbFreemarkerTemplateEngine(configFactory), new SimpleSqlPageFactory(), hammerConfig);
    }

    Integer minAge = 5;
    Integer maxAge = 40;
    String username1 = "yufei";
    String username2 = "featherfly";
    String password = "123";

    @Override
    @Test
    public void testNumber() {
        Integer avg = hammer.template("selectAvg", new ChainMapImpl<>()).number(Integer.class);
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = hammer.template(parser.parse("selectAvg2"), new ChainMapImpl<String, Object>().putChain("age", 40))
                .number(Integer.class);
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

    }

    @Override
    @Test
    public void testIntValue() {
        Integer avg = hammer.template("selectAvg", new ChainMapImpl<>()).numberInt();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).numberInt();
        assertTrue(avg > 20);

        avg = hammer.template("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40)).numberInt();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

        int avg2 = hammer.template("selectAvg", new ChainMapImpl<>()).intValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);

        avg2 = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).intValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);
    }

    @Override
    @Test
    public void testLongValue() {
        Long avg = hammer.template("selectAvg", new ChainMapImpl<>()).numberLong();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).numberLong();
        assertTrue(avg > 20);

        avg = hammer.template("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40)).numberLong();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

        long avg2 = hammer.template("selectAvg", new ChainMapImpl<>()).longValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);

        avg2 = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).longValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);

    }

    @Override
    @Test
    public void testDoubleValue() {
        Double avg = hammer.template("selectAvg", new ChainMapImpl<>()).numberDouble();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 20);

        avg = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).numberDouble();
        assertTrue(avg > 20);

        avg = hammer.template("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40)).numberDouble();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg > 40);

        double avg2 = hammer.template("selectAvg", new ChainMapImpl<>()).doubleValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);

        avg2 = hammer.template(parser.parse("selectAvg"), new ChainMapImpl<>()).doubleValue();
        System.out.println("avg(age) = " + avg2);
        assertTrue(avg2 > 20);
    }

    @Override
    @Test
    public void testBigIntegerValue() {
        BigInteger avg = hammer.template("selectSum", new ChainMapImpl<>()).numberBigInteger();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 20);

        avg = hammer.template("selectSum2", new ChainMapImpl<String, Object>().putChain("age", 40)).numberBigInteger();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 40);

        avg = hammer.template(parser.parse("selectSum2"), new ChainMapImpl<String, Object>().putChain("age", 40))
                .numberBigInteger();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.intValue() > 40);
    }

    @Override
    @Test
    public void testBigDecimalValue() {
        BigDecimal avg = hammer.template("selectAvg", new ChainMapImpl<>()).numberBigDecimal();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 20);

        avg = hammer.template("selectAvg2", new ChainMapImpl<String, Object>().putChain("age", 40)).numberBigDecimal();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);

        avg = hammer.template(parser.parse("selectAvg2"), new ChainMapImpl<String, Object>().putChain("age", 40))
                .numberBigDecimal();
        System.out.println("avg(age) = " + avg);
        assertTrue(avg.doubleValue() > 40);
    }

    @Override
    @Test
    public void testStringValue() {
        String str = hammer.template("selectString", new ChainMapImpl<>()).string();
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = hammer.template("selectString2", new ChainMapImpl<String, Object>().putChain("id", 2)).string();
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Override
    @Test
    public void testSingle() {
        String username = "yufei";
        String password = "123456";
        User u1 = hammer
                .template("selectByUsername@user", new ChainMapImpl<String, Object>().putChain("username", username))
                .single(User.class);

        assertEquals(u1.getUsername(), username);

        User u2 = hammer.template("selectByUsernameAndPassword@user",
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password))
                .single(User.class);

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        u2 = hammer.template("selectByUsernameAndPassword",
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password))
                .single(User.class);

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);

        //        u2 = hammer.single("/tpl/user@selectByUsernameAndPassword", User.class,
        //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));
        // 加入多prefix、suffix支持后的获取
        u2 = hammer.template("selectByUsernameAndPassword@user",
                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password))
                .single(User.class);

        assertEquals(u2.getUsername(), username);
        assertEquals(u2.getPwd(), password);
    }

    @Override
    @Test
    public void testUserList() {
        Integer age = 5;
        List<User> users = hammer.template("selectUser@user", new ChainMapImpl<>()).list(User.class);
        assertTrue(users.size() > 0);

        users = hammer.template("selectUserList@user", new ChainMapImpl<>()).list(User.class);
        assertTrue(users.size() > 0);

        users = hammer.template("selectByAge@user", new ChainMapImpl<String, Object>().putChain("age", 5))
                .list(User.class);
        users.forEach(u -> {
            assertEquals(u.getAge(), age);
        });
    }

    @Override
    @Test
    public void testUserList2() {

        List<User> users = hammer.template("selectConditions@user", new ChainMapImpl<>()).list(User.class);
        assertTrue(users.size() > 0);

        users = hammer.template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                .putChain("maxAge", maxAge).putChain("username", username1 + "%")).list(User.class);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });

        users = hammer.template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                .putChain("maxAge", maxAge).putChain("username", username2 + "%")).list(User.class);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username2));
        });

        users = hammer.template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                .putChain("maxAge", maxAge).putChain("password", password + "%")).list(User.class);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().startsWith(password));
        });

        users = hammer.template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                .putChain("maxAge", maxAge).putChain("password", "%" + password)).list(User.class);
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getPwd().endsWith(password));
        });
    }

    @Override
    @Test
    public void testUserPageList() {
        int limit = 3;
        int start = 0;

        List<User> users = hammer.template("selectConditions@user", new ChainMapImpl<>()).list(User.class, start,
                limit);
        assertTrue(users.size() == 3);

        users = hammer
                .template("selectConditions@user",
                        new ChainMapImpl<String, Object>().putChain("minAge", minAge).putChain("maxAge", maxAge)
                                .putChain("username", username1 + "%"))
                .list(User.class, new SimplePagination(start, limit));
        final int size = users.size();
        users.forEach(u -> {
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });
        assertTrue(size == 3);

        List<Map<String, Object>> userList = hammer
                .template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"))
                .list(new SimplePagination(start, limit));
        final int size2 = userList.size();
        userList.forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);
    }

    @Override
    @Test
    public void testUserPagination() {
        Integer limit = 3;
        Integer start = 0;

        PaginationResults<User> userPaginationResults = hammer.template("selectConditions@user", new ChainMapImpl<>())
                .pagination(User.class, start, limit);
        assertTrue(userPaginationResults.getResultSize() == 3);

        userPaginationResults = hammer
                .template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"))
                .pagination(User.class, start, limit);
        final int size = userPaginationResults.getResultSize();
        assertTrue(userPaginationResults.getTotal() == 4);
        userPaginationResults.getPageResults().forEach(u -> {
            System.err.println(u);
            assertTrue(u.getAge() >= minAge);
            assertTrue(u.getAge() <= maxAge);
            assertTrue(u.getUsername().startsWith(username1));
        });
        assertTrue(size == 3);

        PaginationResults<Map<String, Object>> userPage = hammer
                .template("selectConditions@user", new ChainMapImpl<String, Object>().putChain("minAge", minAge)
                        .putChain("maxAge", maxAge).putChain("username", username1 + "%"))
                .pagination(start, limit);
        final int size2 = userPage.getResultSize();
        userPage.getPageResults().forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);

        userPage = hammer.template("selectConditions@user", new ChainMapImpl<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"))
                .pagination(start, limit);
        userPage.getPageResults().forEach(u -> {
            int age = NumberUtils.parse(u.get("age").toString(), Integer.class);
            assertTrue(age >= minAge);
            assertTrue(age <= maxAge);
            assertTrue(u.get("username").toString().startsWith(username1));
        });
        assertTrue(size2 == 3);
    }

    @Override
    @Test
    public void testRoleList() {
        List<Role> roles = hammer
                .template("selectByName@role", new ChainMapImpl<String, Object>().putChain("name", "name%"))
                .list(Role.class);
        assertTrue(roles.size() > 0);
        roles.forEach(r -> {
            assertTrue(r.getName().startsWith("name"));
        });
        List<Role> roles2 = hammer
                .template("selectByName@role", new ChainMapImpl<String, Object>().putChain("name", null))
                .list(Role.class);
        assertTrue(roles2.size() > roles.size());
    }

    @Override
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
            List<Map<String, Object>> roles = hammer.template(sql,
                    new ChainMapImpl<String, Object>().putChain("name", "name%").putChain("dateFormat", dateFormat))
                    .list();
            assertTrue(roles.size() > 0);
            roles.forEach(r -> {
                if (r.get("") != null) {
                    assertTrue(r.get("dateFormat").toString().matches(datePattern));
                }
                assertTrue(r.get("name").toString().startsWith("name"));
            });
            List<Map<String, Object>> roles2 = hammer.template(sql,
                    new ChainMapImpl<String, Object>().putChain("name", null).putChain("dateFormat", dateFormat))
                    .list();
            assertTrue(roles2.size() > roles.size());
            roles.forEach(r -> {
                if (r.get("") != null) {
                    assertTrue(r.get("dateFormat").toString().matches(datePattern));
                }
            });
        }
    }

    @Override
    @Test
    public void testUserInfoList() {
        List<UserInfo> uis = hammer.template("select@user_info", new ChainMapImpl<>()).list(UserInfo.class);
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testUserInfoList2() {
        List<UserInfo> uis = hammer.template("select2@user_info", new ChainMapImpl<>()).list(UserInfo.class);
        assertTrue(uis.size() > 0);
        uis.forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testWithTemplate() {
        PaginationResults<Role> uis = hammer.template("selectWithTemplate@role", new ChainMapImpl<>())
                .pagination(Role.class, 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testWithTemplate2() {
        PaginationResults<Role> uis = hammer.template("selectWithTemplate2@role", new ChainMapImpl<>())
                .pagination(Role.class, 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testWithTemplate3() {
        PaginationResults<Role> uis = hammer.template("selectWithTemplate3@role", new ChainMapImpl<>())
                .pagination(Role.class, 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testWithTemplate4() {
        PaginationResults<Map<String, Object>> result = hammer
                .template("selectWithTemplate4@role", new ChainMapImpl<>()).pagination(0, 10);
        assertTrue(result.getResultSize() > 0);
        System.out.println("result size:" + result.getResultSize());
        result.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Override
    @Test
    public void testMap() {
        Map<String, Object> uis = hammer
                .template("selectById@user_info", new ChainMapImpl<String, Object>().putChain("id", 1)).single();
        assertEquals(uis.get("id").toString(), "1");
        //        assertEquals(uis.get("ID").toString(), "1");
        System.out.println(uis);
    }

    @Override
    @Test
    public void testMapList() {
        List<Map<String, Object>> uis = hammer.template("select2@user_info", new ChainMapImpl<>()).list(0, 10);
        assertTrue(uis.size() > 0);
        System.out.println("result size:" + uis.size());
        System.out.println(uis);
    }

    @Override
    @Test
    public void testDuplicateExceptionOneFile() {
        // 配置会读取最下面的同名executeId
        hammer.template("select@duplicate", new ChainMapImpl<>()).list(UserInfo.class);
    }

    //    @Override
    //    @Test(expectedExceptions = HammerException.class)
    //    public void testDuplicateExceptionMulitiFile() {
    //        // 配置会读取最下面的同名executeId
    //        hammer.template("select", new ChainMapImpl<>()).list(UserInfo.class);
    //    }

    @Override
    @Test
    public void testDeepDir() {
        hammer.template("select@dir/user_info", new ChainMapImpl<>()).list(UserInfo.class);
    }

    @Override
    @Test
    public void testDeepDir2() {
        hammer.template("selectDir", new ChainMapImpl<>()).list(UserInfo.class);
    }

    @Override
    @Test
    public void testInsertUpdateDelete() {
        String name = "name_insert_" + Randoms.getString(6);
        String descp = "descp_" + Randoms.getString(6);
        int i = hammer.template("insertRole",
                new ChainMapImpl<String, Object>().putChain("name", name).putChain("descp", descp)).execute();
        assertTrue(i == 1);

        Role role = hammer.template("getByName", new ChainMapImpl<String, Object>().putChain("name", name))
                .single(Role.class);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        descp = "descp_" + Randoms.getString(6);
        i = hammer.template("updateRoleByName",
                new ChainMapImpl<String, Object>().putChain("name", name).putChain("descp", descp)).execute();
        assertTrue(i == 1);

        role = hammer.template("getByName", new ChainMapImpl<String, Object>().putChain("name", name))
                .single(Role.class);
        assertEquals(role.getName(), name);
        assertEquals(role.getDescp(), descp);

        i = hammer.template("deleteRoleByName", new ChainMapImpl<String, Object>().putChain("name", name)).execute();
        assertTrue(i == 1);

        role = hammer.template("getByName", new ChainMapImpl<String, Object>().putChain("name", name))
                .single(Role.class);
        assertEquals(role, null);
    }

    @Override
    @Test
    public void testPrivileType() {
        int i = hammer.template("countUserInfo", new ChainMapImpl<>()).value(int.class);
        assertEquals(i, TestConstants.USER_INFO_INIT_ROWS);

        i = hammer.template(parser.parse("countUserInfo"), new ChainMapImpl<>()).value(int.class);
        assertEquals(i, TestConstants.USER_INFO_INIT_ROWS);
    }

    @Override
    @Test
    public void testInParams() {
        int resultSize = 3;

        Long[] ids = new Long[] { 1L, 2L, 3L };

        Map<String, Object> params = new ChainMapImpl<String, Object>().putChain("ids", ids);

        List<User> users;
        // list
        users = hammer.template("selectIn", params).list(User.class);
        assertEquals(users.size(), resultSize);

        // value
        int size = hammer.template("selectInCount", params).value(int.class);
        assertEquals(size, resultSize);

        //  list page
        resultSize = 2;
        users = hammer.template("selectIn", params).list(User.class, 0, 2);
        assertEquals(users.size(), resultSize);

        //  pagination
        PaginationResults<User> p = hammer.template("selectIn", params).pagination(User.class, 0, 2);
        assertEquals(p.getPageResults().size(), resultSize);
        assertEquals(p.getTotal(), Integer.valueOf(ids.length));

        // single
        User user = hammer
                .template("selectInSingle", new ChainMapImpl<String, Object>().putChain("ids", new Long[] { 1L, -1L }))
                .single(User.class);
        assertEquals(user.getId(), Integer.valueOf(1));

    }

    @Override
    @Test
    public void testInParams2() {
        int resultSize = 4;

        Long[] ids = new Long[] { 1L, 2L, 3L, 4L };

        Map<String, Object> params = new ChainMapImpl<String, Object>().putChain("ids", ids);

        List<User> users;

        // list
        users = hammer.template("selectIn2", params).list(User.class);
        assertEquals(users.size(), resultSize);
    }

    @Override
    @Test
    public void testSingleTuple2() {
        Integer userId = 1;
        // list
        Tuple2<UserInfo, User> tuple2 = hammer
                .template("selectUserInfoByUserId", new ChainMapImpl<String, Object>().putChain("userId", userId))
                .mapper(b -> b.map("ui.", UserInfo.class).map("u.", User.class)).single();

        System.out.println(tuple2.get0());
        System.out.println(tuple2.get1());

        assertEquals(userId, tuple2.get0().getUser().getId());
        assertEquals(userId, tuple2.get1().getId());
    }

    @Override
    @Test
    public void testSingleTuple2_2() {
        Integer userId = 1;
        // list
        Tuple2<UserInfo, User> tuple2 = hammer
                .template("selectUserInfoByUserId", new ChainMapImpl<String, Object>().putChain("userId", userId))
                .mapper(UserInfo.class, User.class).single();

        System.out.println(tuple2.get0());
        System.out.println(tuple2.get1());

        assertEquals(userId, tuple2.get0().getUser().getId());
        assertEquals(userId, tuple2.get1().getId());
    }

    @Override
    @Test
    public void testSingleTuple2List() {
        // list
        List<Tuple2<UserInfo, User>> list = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>())
                .mapper(b -> b.map("ui.", UserInfo.class).map("u.", User.class)).list();

        assertEquals(list.size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>())
                .mapper(b -> b.map("ui.", UserInfo.class).map("u.", User.class)).list(0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Override
    @Test
    public void testSingleTuple2List_2() {
        // list
        List<Tuple2<UserInfo, User>> list = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>())
                .mapper(UserInfo.class, User.class).list();
        assertEquals(list.size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>()).mapper(UserInfo.class, User.class)
                .list(0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Override
    @Test
    public void testSingleTuple2Page() {
        PaginationResults<Tuple2<UserInfo, User>> page = hammer
                .template("selectUserInfoAndUserList", new ChainMapImpl<>())
                .mapper(b -> b.map("ui.", UserInfo.class).map("u.", User.class)).pagination(0, 10);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>())
                .mapper(b -> b.map("ui.", UserInfo.class).map("u.", User.class)).pagination(0, 1);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Override
    @Test
    public void testSingleTuple2Page_2() {
        int pageSize = 2;
        PaginationResults<Tuple2<UserInfo, User>> page = hammer
                .template("selectUserInfoAndUserList", new ChainMapImpl<>()).mapper(UserInfo.class, User.class)
                .pagination(0, pageSize);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), pageSize);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = hammer.template("selectUserInfoAndUserList", new ChainMapImpl<>()).mapper(UserInfo.class, User.class)
                .pagination(0, 1);
        assertEquals(page.getSize(), Integer.valueOf(1));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }
}
