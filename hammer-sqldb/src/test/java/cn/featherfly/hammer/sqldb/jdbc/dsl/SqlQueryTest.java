
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.SimpleRepository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.Tree2;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole2;

/**
 * <p>
 * SqlQueryTest
 * </p>
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

        Long number2 = query.find(User.class).count();
        System.out.println("count:" + number2);
        assertTrue(number2 > 0);
        assertEquals(number, number2);

        number = query.find("user").where().eq("age", 5).count();
        assertTrue(number == 2);

        number2 = query.find(User.class).where().eq("age", 5).count();
        assertTrue(number2 == 2);
        assertEquals(number, number2);

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

    @SuppressWarnings("unchecked")
    @Test
    void testMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        query.find(User.class).where().eq("username", "yufei").and().eq("pwd", "123456").and().group().gt("age", 18)
                .and().lt("age", 60).list();

        query.find(User.class).where().eq("username", "yufei").and().eq("pwd", "123456").and().group().gt("age", 18)
                .and().property("age").lt(60).list();

        query.find(User.class).property("username", "pwd", "age").where().eq("username", "yufei").and()
                .eq("pwd", "123456").and().group().gt("age", 18).and().lt("age", 60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where().eq("username", "yufei")
                .and().eq("pwd", "123456").and().group().gt("age", 18).and().lt("age", 60).list();
        /*
         * query.find(User.class).with(UserInfo.class, UserInfo::getUser)
         * query.find(UserInfo.class).with(UserInfo::getUser, User.class)
         * query.find(UserInfo.class).with(UserInfo::getUser)
         * query.find("user").with("user_info").on("user_id",
         * "id").with("user_role").on("user_id", "id").with("role",
         * "user_role").on("id", "role_id")
         * query.find("user_info").with("user_id", "user")
         */
        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where().eq("username", "yufei")
                .and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18).and().lt(User::getAge, 60).list();
    }

    @Test
    void testMapping2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        User user = new User();
        user.setUsername("yufei");
        user.setPwd("123456");
        query.find(User.class).where().eq(user::getUsername).and().eq(user::getPwd).list();
    }

    @Test
    void testNestedMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        Integer userId = 1;
        UserInfo userInfo = query.find(UserInfo.class).where().eq("user.id", userId).single();
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);

        String province = "四川";
        userInfo = query.find(UserInfo.class).where().eq("division.province", province).single();
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }

    @Test
    void testJoin() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").list();

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").fetch().list();

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").fetch("name").fetch()
                .list();

        query.find("user").property("username", "password", "age").with("user_info").on("user_id").fetch("name")
                .fetch("descp").list();

        query.find("user").property("username", "password", "age").with("user_role").on("user_id").with("role")
                .on("id", "user_role", "role_id").fetch().list();

        query.find("user").property("username", "password", "age").with(UserInfo.class).on("user_id").list();

        query.find("user").property("username", "password", "age").with(UserInfo.class).on("user_id").fetch().list();

        query.find("tree").with("tree").on("parent_id").list();

        query.find("tree").with("tree").on("parent_id").with("tree").on("parent_id").list();

        query.find("user_info").with("user").on("id", "user_id").fetchAlias("password", "pwd").fetch().list();
    }

    @Test
    void testJoinCondition() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        List<Map<String, Object>> list = query.find("user").property("username", "password", "age").with("user_info")
                .on("user_id").where().eq("user_info", "name", "羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").with("user_info").on("user_id").where()
                .eq(1, "name", "羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").with("user_info").on("user_id").where()
                .property("user_info", "name").eq("羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").property("username", "password", "age").with("user_info").on("user_id").where()
                .property(1, "name").eq("羽飞").list();
        assertEquals(list.size(), 1);
    }

    @Test
    void testJoin2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        UserInfo userInfo = query.find(UserInfo.class).with(UserInfo::getUser).where().eq(UserInfo::getId, 1).single();
        System.err.println(userInfo);
        assertNull(userInfo.getUser().getUsername());
        userInfo = query.find(UserInfo.class).with(UserInfo::getUser).fetch().where().eq(UserInfo::getId, 1).single();
        assertNotNull(userInfo.getUser().getUsername());
        System.err.println(userInfo);

        query.find(UserInfo.class).with(UserInfo::getUser).with(UserRole2::getUser).with(UserRole2::getRole).list();

        query.find(Tree2.class).with(Tree2::getParent).list();

        query.find(Tree2.class).with(Tree2::getParent).with(Tree2::getParent, 1).list();
    }

    @Test
    void testJoinCondition2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        Integer userInfoId = 1;
        Integer userId = 1;
        User user = null;

        user = query.find(User.class).with(UserInfo::getUser).where().eq(1, "id", userInfoId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).with(UserInfo::getUser).where().eq("user_info", "id", userInfoId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).with(UserInfo::getUser).where().eq(UserInfo.class, "id", userInfoId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).with(UserInfo::getUser).where().eq(User::getId, userId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).with(UserInfo::getUser).where().eq(UserInfo::getId, userInfoId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).with(UserInfo::getUser).where().property(UserInfo::getId).eq(userInfoId).single();
        assertEquals(user.getId(), userId);
    }

    @Test
    void testJoinCondition2_1() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setPwd("123456");
        userInfo.setUser(user);

        List<UserInfo> userInfos = query.find(UserInfo.class).with(UserInfo::getUser).where()
                .eq(userInfo::getUser, User::getPwd).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

    }

    @Test
    void testJoinCondition2_2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setPwd("123456");
        user.setUsername("yufei");
        userInfo.setUser(user);
        userInfo.setId(1);

        List<UserInfo> userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId)
                .list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId)
                .and().lt(UserInfo::getUser, User::getAge, 10).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(UserInfo::getId, 2)
                .list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId)
                .and().ge(UserInfo::getUser, User::getAge, 10).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and()
                .eq(userInfo::getUser, User::getUsername).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and()
                .eq(userInfo::getUser, User::getUsername).and().eq(userInfo::getId).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and()
                .eq(userInfo::getUser, User::getUsername).and().eq(UserInfo::getId, 2).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        user.setUsername("yufei1111");
        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and()
                .eq(userInfo::getUser, User::getUsername).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);
    }

    @Test
    void testJoin3() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        List<Tree2> list1 = query.find(Tree2.class).list();
        list1.forEach(v -> {
            System.err.println(v);
        });

        List<Tree2> list2 = query.find(Tree2.class).with(Tree2::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        list2 = query.find(Tree2.class).with(Tree2::getParent).with(Tree2::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        List<Tree2> list3 = query.find(Tree2.class).with(Tree2::getParent).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            System.err.println(v);
        });

        list3 = query.find(Tree2.class).with(Tree2::getParent).fetch().with(Tree2::getParent, 1).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            System.err.println(v);
        });

        assertTrue(list1.size() > list2.size());

        // query.find(UserInfo.class).with(UserRole2::getUser).list();

        // query.find(User.class).with(UserRole2::getUser);
        // query.find(User.class).with(UserRole2::getUser)
        // .with(UserRole2::getRole);
        // query.find(User.class).with(UserRole2::getUser).with(UserRole2::getRole).where();
        // query.find(UserInfo.class).with(UserInfo::getUser).on(propertyName);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testJoinExceptions() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        query.find(UserInfo.class).with(UserRole2::getUser).list();
    }

    @Test
    void testManyToOne() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        int parent = 1;
        List<Tree2> list = query.find(Tree2.class).where().eq(Tree2::getParent, parent).list();
        System.out.println(list);
        for (Tree2 t : list) {
            assertTrue(parent == t.getParent().getId());
        }
    }

    @Test
    void testManyToOne2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        int parent = 1;
        Tree2 tree2 = new Tree2();
        tree2.setParent(new Tree2(parent));
        List<Tree2> list = query.find(Tree2.class).where().eq(tree2::getParent).list();
        System.out.println(list);
        for (Tree2 t : list) {
            assertTrue(1 == t.getParent().getId());
        }
    }

    @Test
    void testNestedProperty() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        UserRole2 userRole2 = new UserRole2();
        userRole2.setRole(new Role(2));
        userRole2.setUser(new User(1));
        query.find(UserRole2.class).where().eq(userRole2::getRole).and().ne(userRole2::getUser).list();

        UserInfo userInfo = new UserInfo();
        DistrictDivision division = new DistrictDivision();
        division.setCity("成都");
        division.setProvince("四川");
        division.setDistrict("高新");
        userInfo.setDivision(division);

        query.find(UserInfo.class).where().eq(userInfo::getDivision).list();
        query.find(UserInfo.class).where().ne(userInfo::getDivision).list();

        userInfo.getDivision().setDistrict(null);
        query.find(UserInfo.class).where().eq(userInfo::getDivision).or().eq(userInfo::getDivision).list();
    }

    @Test
    void testNestedProperty2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        UserRole2 userRole2 = new UserRole2();
        userRole2.setRole(new Role(2));
        userRole2.setUser(new User(1));
        query.find(UserRole2.class).where().eq(userRole2::getRole).and().ne(userRole2::getUser).list();

        UserInfo userInfo = new UserInfo();
        DistrictDivision division = new DistrictDivision();
        division.setCity("成都");
        division.setProvince("四川");
        division.setDistrict("高新");
        userInfo.setDivision(division);

        query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();

        userInfo.getDivision().setDistrict(null);
        query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).or().eq(UserInfo::getDivision, division)
                .list();
    }

    @Test
    void testInn() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long nullNum = 1;

        long total = query.find(Tree.class).count();

        long count = query.find(Tree.class).where().isn("parent_id").count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn("parent_id", true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn("parent_id", false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().isn("parent_id", null).count();
        assertTrue(count == total);

        count = query.find(Tree.class).where().isn(Tree::getParentId).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().isn(Tree::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree.class).where().inn("parent_id").count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn("parent_id", true).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn("parent_id", false).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().inn("parent_id", null).count();
        assertTrue(count == total);

        count = query.find(Tree.class).where().inn(Tree::getParentId).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn(Tree::getParentId, true).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn(Tree::getParentId, false).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().inn(Tree::getParentId, (Boolean) null).count();
        assertTrue(count == total);
    }

    @Test
    void testInn2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long nullNum = 1;

        long count = query.find(Tree2.class).with(Tree2::getParent).where().isn(1, "parent_id").list().size();
        assertTrue(nullNum < count);

    }

    // @Test
    // void test1111() {
    // ClassMapping<?> classMapping =
    // mappingFactory.getClassMapping(Tree2.class);
    // System.err.println(ClassMappingUtils.getSelectColumnsSql(classMapping,
    // "t0", Dialects.MYSQL, mappingFactory,
    // new HashChainMap<String, String>().putChain("parent", "t1")));
    //
    // }
}
