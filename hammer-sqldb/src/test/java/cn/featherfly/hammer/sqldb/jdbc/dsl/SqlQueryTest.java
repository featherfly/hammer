
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.SimpleRepository;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;

/**
 * SqlQueryTest.
 *
 * @author zhongj
 */
public class SqlQueryTest extends JdbcTestBase {

    @Test
    void testNull() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
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
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);

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
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
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
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
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
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test3() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
        query.find(new SimpleRepository("user", "u")).where().eq("username", "yufei").and().eq("password", "123456")
                .and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test4() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
        query.find(new SimpleRepository("user", "u")).property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60)
                .list(User.class);
    }

    @Test
    void testCount() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        Long number = query.find("user").count();
        System.out.println("count:" + number);
        assertTrue(number > 0);
    }

    @Test
    void testLimit() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory);
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
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        query.find("user").property("username", "password", "age").join("user_info").on("user_id").list();

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

        query.find("user").property("username", "password", "age").join(UserInfo.class).on("user_id").list();

        query.find("user").property("username", "password", "age").join(UserInfo.class).on("user_id").fetch().list();

        query.find("tree").join("tree").on("parent_id").list();

        query.find("tree").join("tree").on("parent_id").join("tree").on("parent_id").list();

        query.find("user_info").join("user").on("id", "user_id").fetchAlias("password", "pwd").fetch().list();
    }

    @Test
    void testJoinCondition() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        List<Map<String, Object>> list = query.find("user").property("username", "password", "age").join("user_info")
                .on("user_id").where().eq("user_info", "name", "羽飞").list();
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
}
