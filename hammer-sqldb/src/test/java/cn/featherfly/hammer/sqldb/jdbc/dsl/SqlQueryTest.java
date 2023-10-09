
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * SqlQueryTest.
 *
 * @author zhongj
 */
public class SqlQueryTest extends JdbcTestBase {

    SqlQuery query;

    @BeforeClass
    void beforeClass() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    @Test
    void testNull() {
        List<Map<String, Object>> list = query.find("user").where().eq("a", null).and().eq("b", null).and()
                .sw("username", "yufei").and().eq("d", null).list();
        for (Map<String, Object> map : list) {
            String username = (String) map.get("username");
            System.err.println(username);
            assertTrue(Strings.startsWith(username, "yufei"));
        }
    }

    @Test
    void testFunction() {

        Object result = null;

        List<Map<String, Object>> ages = query.find("user").property("age").list();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Map<String, Object> m : ages) {
            int i = (int) m.get("age");
            sum += i;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        result = query.find("user").min("age").integer();
        System.out.println("min = " + result);
        assertEquals(result, min);

        result = query.find("user").max("age").integer();
        System.out.println("max = " + result);
        assertEquals(result, max);

        result = query.find("user").avg("age").integer();
        System.out.println("avg = " + result);
        assertEquals(result, sum / ages.size());

        result = query.find("user").sum("age").integer();
        System.out.println("sum = " + result);
        assertEquals(result, sum);

        result = query.find("user").count("age").integer();
        System.out.println("count = " + result);
        assertEquals(result, ages.size());

    }

    @Test
    void test0() {

        List<Map<String, Object>> list = query.find("user").property("username", "password", "age").sort().asc("age")
                .list();
        int age = Integer.MIN_VALUE;
        for (Map<String, Object> map : list) {
            Integer a = (Integer) map.get("age");
            System.err.println(age + "    " + a);
            assertTrue(age <= a);
            age = a;
        }

        //        list = query.find("user").property("username", "password", "AGE").sort().asc("AGE").list();
        //        age = Integer.MIN_VALUE;
        //        for (Map<String, Object> map : list) {
        //            Integer a = (Integer) map.get("AGE");
        //            System.err.println(age + "    " + a);
        //            assertTrue(age <= a);
        //            age = a;
        //        }

        //        list = query.find("user").property("username", "password").propertyAlias("AGE", "age").sort().asc("age").list();
        //        age = Integer.MIN_VALUE;
        //        for (Map<String, Object> map : list) {
        //            Integer a = (Integer) map.get("age");
        //            System.err.println(age + "    " + a);
        //            assertTrue(age <= a);
        //            age = a;
        //        }
    }

    @Test
    void test1() {

        query.find("user").list(User.class);
        query.find("user").property("username", "password", "age").list(User.class);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group(g -> g.gt("age", 18).and().lt("age", 60)).list(User.class);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and(g -> g.gt("age", 18).and().lt("age", 60)).list(User.class);
    }

    @Test
    void test2() {

        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test3() {

        query.find(new SimpleAliasRepository("user", "u")).where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test4() {

        query.find(new SimpleAliasRepository("user", "u")).property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60)
                .list(User.class);

        Repository repository = new SimpleAliasRepository("user", "u");

        query.find(repository).property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void testCondition_in() {
        int[] ids = new int[] { 1, 2 };
        List<Map<String, Object>> list = query.find("user") //
                .where() //
                .in("id", ids) //
                .list();
        assertEquals(list.size(), ids.length);

        list = query.find("user") //
                .where() //
                .in("id", null) //
                .list();
        long total = query.find("user").count();
        assertEquals(list.size(), total);

        long c1 = query.find("user") //
                .where() //
                .in("id", null, IgnoreStrategy.NONE)// 不忽略空值
                .count();
        assertEquals(c1, 0);
    }

    @Test
    void testCondition_eq() {
        int id = 1;
        int userId = query.find("user").property("id") //
                .where() //
                .eq("id", id) //
                .intValue();
        assertEquals(userId, id);

        long c1 = query.find("user") //
                .where() //
                .eq("id", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .eq("id", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
                .where() //
                .eq("id", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_ne() {
        int id = 1;
        List<Integer> userIds = query.find("user").property("id") //
                .where() //
                .ne("id", id) //
                .list(Integer.class);
        for (Integer userId : userIds) {
            assertNotEquals(userId, id);
        }

        long c1 = query.find("user") //
                .where() //
                .ne("id", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .ne("id", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
                .where() //
                .ne("id", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_sw() {
        String sw = "yufei";
        List<String> usernames = query.find("user").property("username") //
                .where() //
                .sw("username", sw) //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.startsWith(username, sw));
        }

        long c = query.find("user")//
                .where() //
                .sw("username", "zzzzzzzz") //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .sw("username", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .sw("username", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .sw("username", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_ew() {
        String ew = "55";
        List<String> usernames = query.find("user").property("username") //
                .where() //
                .ew("username", ew) //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.endWith(username, ew));
        }

        long c = query.find("user")//
                .where() //
                .ew("username", "zzzzzzzz") //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .ew("username", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .ew("username", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .ew("username", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_co() {
        String co = "uf";
        List<String> usernames = query.find("user").property("username") //
                .where() //
                .co("username", co) //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.contains(username, co));
        }

        long c = query.find("user")//
                .where() //
                .co("username", "zzzzzzzz") //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .co("username", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .co("username", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .co("username", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_lk() {
        String yufei = "yufei";
        String un = query.find("user").property("username") //
                .where() //
                .lk("username", yufei) //
                .string();
        assertEquals(un, yufei);

        String sw = "yufei";
        List<String> usernames = query.find("user").property("username") //
                .where() //
                .sw("username", sw + "%") //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.startsWith(username, sw));
        }

        String ew = "55";
        usernames = query.find("user").property("username") //
                .where() //
                .ew("username", "%" + ew) //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.endWith(username, ew));
        }

        String co = "uf";
        usernames = query.find("user").property("username") //
                .where() //
                .co("username", "%" + co + "%") //
                .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.contains(username, co));
        }

        long c = query.find("user")//
                .where() //
                .lk("username", "zzzzzzzz") //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .lk("username", null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .lk("username", null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .lk("username", null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_gt() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").property("age") //
                .where() //
                .gt("age", ageValue) //
                .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age > ageValue);
        }

        long c = query.find("user")//
                .where() //
                .gt("age", Integer.MAX_VALUE) //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .gt("age", (Integer) null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .gt("age", (Integer) null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .gt("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .gt("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_ge() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").property("age") //
                .where() //
                .ge("age", ageValue) //
                .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age >= ageValue);
        }

        long c = query.find("user")//
                .where() //
                .ge("age", Integer.MAX_VALUE) //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .ge("age", (Integer) null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .ge("age", (Integer) null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .ge("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .ge("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_lt() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").property("age") //
                .where() //
                .lt("age", ageValue) //
                .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age < ageValue);
        }

        long c = query.find("user")//
                .where() //
                .lt("age", 0) //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .lt("age", (Integer) null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .lt("age", (Integer) null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .lt("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .lt("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test
    void testCondition_le() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").property("age") //
                .where() //
                .le("age", ageValue) //
                .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age <= ageValue);
        }

        long c = query.find("user")//
                .where() //
                .le("age", 0) //
                .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
                .where() //
                .le("age", (Integer) null) //
                .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
                .where() //
                .le("age", (Integer) null, v -> false) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .le("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
                .where() //
                .le("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
                .count();
        assertEquals(c2, 0);
    }

    @Test(expectedExceptions = BuilderException.class)
    void testConditionException() {

        QueryConditionGroupExpression condition = query.find(new SimpleAliasRepository("user", "u")).where();
        condition.eq("id", 1);
        condition.eq("id", 2).list();
    }

    @Test(expectedExceptions = BuilderException.class)
    void testConditionException2() {

        QueryConditionGroupExpression condition = query.find(new SimpleAliasRepository("user", "u")).where();
        QueryConditionGroupLogicExpression logic = condition.eq("id", 1);
        logic.and();
        logic.list();
    }

    @Test
    void testCount() {

        Long number = query.find("user").count();
        System.out.println("count:" + number);
        assertTrue(number > 0);
    }

    @Test
    void testCount2() {
        long number = query.find("user").property("id") //
                .count();
        System.out.println("count:" + number);
        assertTrue(number > 0);
    }

    @Test
    void testLimit() {

        int pageSize = 3;
        Integer total = 10;
        List<Role> roleList = query.find(new SimpleRepository("role")).where().le("id", total).limit(2, pageSize)
                .list(Role.class);
        assertEquals(roleList.size(), pageSize);

        List<Map<String, Object>> roleList2 = query.find(new SimpleRepository("role")).where().le("id", total)
                .limit(2, pageSize).list();
        assertEquals(roleList2.size(), pageSize);

        List<Integer> roleList3 = query.find(new SimpleRepository("role")).where().le("id", total).limit(2, pageSize)
                .list((res, rowNum) -> res.getInt("id"));
        assertEquals(roleList3.size(), pageSize);

        PaginationResults<Role> rolePage = query.find(new SimpleRepository("role")).where().le("id", total)
                .limit(2, pageSize).pagination(Role.class);
        assertEquals(rolePage.getTotal(), total);
        assertEquals(rolePage.getPageResults().size(), pageSize);

        PaginationResults<Map<String, Object>> rolePage2 = query.find(new SimpleRepository("role")).where()
                .le("id", total).limit(2, pageSize).pagination();
        assertEquals(rolePage2.getTotal(), total);
        assertEquals(rolePage2.getPageResults().size(), pageSize);

        PaginationResults<Integer> rolePage3 = query.find(new SimpleRepository("role")).where().le("id", total)
                .limit(2, pageSize).pagination((res, rowNum) -> res.getInt("id"));
        assertEquals(rolePage3.getTotal(), total);
        assertEquals(rolePage3.getPageResults().size(), pageSize);
    }

    @Test
    void testJoin() {

        // query.find("user") 返回 SqlQueryEntity
        // query.find("user").property("username") 返回 QueryEntityProperties，应该返回SqlQueryEntity
        query.find("user").property("username", "password", "age") //
                .join("user_info") //
                .on("user_id") //
                .list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").join("user_info")
                .on("user_id").list();

        // ENHANCE 后续加入省略on方法的形式，通过database metadata 自动获取join的table的id
        //  query.find("user").property("username", "password", "age").join("user_info").list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch().list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch("name").fetch()
                .list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch("name")
                .fetch("descp").list();

        query.find("user").property("username", "password", "age").join("user_role").on("user_id").join("role")
                .on("id", "user_role", "role_id").fetch().list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").list();

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").fetch().list();

        query.find("tree").join("tree").on("parent_id").list();

        query.find("tree").join("tree").on("parent_id").join("tree").on("parent_id").list();

        query.find("user_info").join("user").on("id", "user_id").fetchAlias("password", "pwd").fetch().list();
    }

    @Test
    void testJoinCondition() {

        List<Map<String, Object>> list = query.find("user").property("username", "password", "age") //
                .join("user_info").on("user_id") //
                .where().eq("user_info", "name", "羽飞") //
                .list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").join("user_info").on("user_id").where()
                .eq(1, "name", "羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").join("user_info").on("user_id").where()
                .property("user_info", "name").eq("羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").join("user_info").on("user_id").where()
                .property(1, "name").eq("羽飞").list();
        assertEquals(list.size(), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testQueryNull() {
        query.find((Repository) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testQueryNull2() {
        query.find((AliasRepository) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testQueryNull3() {
        query.find((Table) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testQueryNull4() {
        query.find((String) null);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testQueryClassMappingFactorNull() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
        query.find(User.class);
    }

    @Test(expectedExceptions = JdbcMappingException.class)
    void testQueryNotEntityNull() {
        query.find(String.class);
    }
}
