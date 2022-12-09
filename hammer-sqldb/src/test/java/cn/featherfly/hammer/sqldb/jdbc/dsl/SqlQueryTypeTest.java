
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

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
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeTest extends JdbcTestBase {

    @Test
    void testCount() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        Long number = query.find("user").count();
        System.out.println("count:" + number);

        Long number2 = query.find(User.class).count();
        System.out.println("count:" + number2);
        assertTrue(number2 > 0);
        assertEquals(number, number2);

        number = query.find("user").where().eq("age", 5).count();
        assertTrue(number == 2);

        number2 = query.find(User.class).where().eq(User::getAge, 5).count();
        assertTrue(number2 == 2);
        assertEquals(number, number2);

    }

    @SuppressWarnings("unchecked")
    @Test
    void testMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
                .gt(User::getAge, 18).and().lt(User::getAge, 60).list();

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
                .gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
        /*
         * query.find(User.class).join(UserInfo.class, UserInfo::getUser)
         * query.find(UserInfo.class).join(UserInfo::getUser, User.class)
         * query.find(UserInfo.class).join(UserInfo::getUser)
         * query.find("user").join("user_info").on("user_id",
         * "id").join("user_role").on("user_id", "id").join("role",
         * "user_role").on("id", "role_id")
         * query.find("user_info").join("user_id", "user")
         */
        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
    }

    @Test
    void testMapping2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        User user = new User();
        user.setUsername("yufei");
        user.setPwd("123456");
        query.find(User.class).where().eq(user::getUsername).and().eq(user::getPwd).list();
    }

    @SuppressWarnings("unchecked")
    @Test
    void testPropertyExpression() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
                .list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
                .and().group().property(User::getAge).gt(18).and().property(User::getAge).lt(60).list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
                .and().group().gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
    }

    @Test
    void testNestedMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        Integer userId = 1;
        //        UserInfo userInfo = query.find(UserInfo.class).where().eq("user.id", userId).single();
        UserInfo userInfo = query.find(UserInfo.class).where().eq(UserInfo::getUser, userId).single(); // YUFEI_TODO 需要测试
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);

        String province = "四川";
        //        userInfo = query.find(UserInfo.class).where().eq("division.province", province).single();
        userInfo = query.find(UserInfo.class).where().eq(UserInfo::getDivision, DistrictDivision::getProvince, province)
                .single(); // YUFEI_TODO 需要测试
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }

    @Test
    void testJoin() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        StringBuilder sb = new StringBuilder();
        sb.append("").append("").append("");

        UserInfo userInfo = null;
        User user = null;

        Integer uid = 1;
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).where().eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, 1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getUsername());

        user = query.find(User.class).join(UserInfo::getUser).join(UserRole2::getUser).where().eq(User::getId, uid)
                .single();
        System.err.println(user);
        assertEquals(user.getId(), uid);

        //        sql: SELECT _user0.`id` `id`, _user0.`username` `username`, _user0.`password` `pwd`, _user0.`mobile_no` `mobileNo`, _user0.`age` `age`
        //        FROM `user` _user0
        //        JOIN `user_info` _user_info0 ON _user_info0.`user_id` = _user0.`id`
        //        JOIN `user_role` _user_role0 ON _user_role0.`user_id` = _user0.`user_id` WHERE _user0.`id` = ?

        //        SELECT _user0.`id` `id`, _user0.`username` `username`, _user0.`password` `pwd`, _user0.`mobile_no` `mobileNo`, _user0.`age` `age`
        //        FROM `user` _user0
        //        JOIN `user_info` _user_info0 ON _user_info0.`user_id` = _user0.`id`
        //        JOIN `user_role` _user_role0 ON _user_role0.`user_id` = _user0.`user_id`
        //        WHERE _user0.`id` = ?

        //        IMPLSOON 后续来实现多类型的查询
        //        user = query.find(User.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, 1).single();

        // YUFEI_TODO 后续来测试
        //        List<UserInfo> list = query.find(UserInfo.class).join(UserInfo::getUser).join(UserRole2::getUser)
        //                .join(UserRole2::getRole).list();
        //        System.out.println(list.size());

        query.find(Tree2.class).join(Tree2::getParent).list();

        query.find(Tree2.class).join(Tree2::getParent).join1(Tree2::getParent).list();
    }

    @Test
    void testJoin1() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        User user = new User();
        String username = "yufei";
        user.setUsername(username);

        // UserInfo::getUser, User::getUsername 联表查询，仅查询不获取，如果没有join的话需要自动join
        List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getUser, User::getUsername, username)
                .list();

        // UserInfo::getUser, user 联表查询，仅查询不获取，如果没有join的话需要自动join
        list = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testJoinFetchException() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        // 因为User类中没有UserRole类的关系，所以fetch时会找不到关系，不fetch只是使用条件查询问题不大
        // userInfo.user.userRole 这里没有userRole

        // YUFEI_TODO 后续来测试
        //        query.find(UserInfo.class).join(UserInfo::getUser).fetch().join(UserRole2::getUser).fetch()
        //                .join(UserRole2::getRole).fetch().list();

        // TODO 可能的条件查询
        /*
         query.find(UserInfo.class).join(UserInfo::getUser, (c) -> {
             c.eq() ..... // 关联user的条件查询
         }).fetch().join(UserRole2::getUser).fetch()
                .join(UserRole2::getRole).fetch().list();
        
        
         */
    }

    @Test
    void testJoinCondition2() {
        // YUFEI_TODO 后续来测试
        //        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        //        Integer userInfoId = 1;
        //        Integer userId = 1;
        //        User user = null;
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().eq(1, "id", userInfoId).single();
        //        assertEquals(user.getId(), userId);
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().eq("user_info", "id", userInfoId).single();
        //        assertEquals(user.getId(), userId);
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().eq(UserInfo.class, "id", userInfoId).single();
        //        assertEquals(user.getId(), userId);
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().eq(User::getId, userId).single();
        //        assertEquals(user.getId(), userId);
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().eq(UserInfo::getId, userInfoId).single();
        //        assertEquals(user.getId(), userId);
        //
        //        user = query.find(User.class).join(UserInfo::getUser).where().property(UserInfo::getId).eq(userInfoId).single();
        //        assertEquals(user.getId(), userId);
    }

    @Test
    void testJoinCondition2_1() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setPwd("123456");
        userInfo.setUser(user);

        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
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
    void testJoinMulity() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        List<Tree2> list1 = query.find(Tree2.class).list();
        list1.forEach(v -> {
            System.err.println(v);
        });

        List<Tree2> list2 = query.find(Tree2.class).join(Tree2::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        list2 = query.find(Tree2.class).join(Tree2::getParent).join(Tree2::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        List<Tree2> list3 = query.find(Tree2.class).join(Tree2::getParent).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            System.err.println(v);
        });

        list3 = query.find(Tree2.class).join(Tree2::getParent).fetch().join1(Tree2::getParent).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            System.err.println(v);
        });

        assertTrue(list1.size() > list2.size());

        // query.find(UserInfo.class).join(UserRole2::getUser).list();

        // query.find(User.class).join(UserRole2::getUser);
        // query.find(User.class).join(UserRole2::getUser)
        // .join(UserRole2::getRole);
        // query.find(User.class).join(UserRole2::getUser).join(UserRole2::getRole).where();
        // query.find(UserInfo.class).join(UserInfo::getUser).on(propertyName);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testJoinExceptions() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
        // YUFEI_TODO 后续来测试
        //        query.find(UserInfo.class).join(UserRole2::getUser).list();
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
        division.setDistrict("金牛");
        userInfo.setDivision(division);

        List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        int size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }
        list = query.find(UserInfo.class).where().eq(UserInfo::getId, 1).or().eq(UserInfo::getDivision, division).or()
                .eq(UserInfo::getId, 1).list();
        size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }

        list = query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();
        for (UserInfo ui : list) {
            assertNotEquals(ui.getDivision(), division);
        }

        userInfo.getDivision().setDistrict(null);
        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).or()
                .eq(UserInfo::getDivision, division).list();
        assertTrue(list.size() == size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
                .list();
        assertTrue(list.size() > size);
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
        division.setDistrict("金牛");
        userInfo.setDivision(division);

        List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        int size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }
        list = query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();
        for (UserInfo ui : list) {
            assertNotEquals(ui.getDivision(), division);
        }

        userInfo.getDivision().setDistrict(null);
        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).or()
                .eq(UserInfo::getDivision, division).list();
        assertTrue(list.size() == size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
                .list();
        assertTrue(list.size() > size);
    }

    @Test
    void testInn() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long nullNum = 1;

        long total = query.find(Tree.class).count();

        long count = query.find(Tree.class).where().isn(Tree::getParentId).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().isn(Tree::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree.class).where().isn(Tree::getParentId).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().isn(Tree::getParentId, false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().isn(Tree::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree.class).where().inn(Tree::getParentId).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn(Tree::getParentId, true).count();
        assertTrue(nullNum < count);

        count = query.find(Tree.class).where().inn(Tree::getParentId, false).count();
        assertEquals(count, nullNum);

        count = query.find(Tree.class).where().inn(Tree::getParentId, (Boolean) null).count();
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
    void testComplexQuery() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        //        query.find(User.class).where().gt(User::getId, 1).and().group().group();

        //        query.find(User.class).where().gt(User::getId, 1).and(c -> {
        //            c.group(g1 -> {
        //                g1.eq(User::getId, 2).and().eq(User::getAge, 5);
        //            }).or().group(g2 -> {
        //                g2.eq(User::getId, 3).and().eq(User::getAge, 15);
        //            });
        //        }).list();

        //        query.find(User.class).where().gt(User::getId, 1).and().group()
        //                .group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)).or()
        //                .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15)).endGroup().list();

        long count = -1;

        // 基于group() endGroup() 方法
        count = query.find(User.class).where().gt(User::getId, 1).and().group().group().eq(User::getId, 2).and()
                .eq(User::getAge, 5).endGroup().or().group().eq(User::getId, 3).and().eq(User::getAge, 15).endGroup()
                .endGroup().count();
        assertEquals(count, 2);

        //  基于group(g -> g.xxx)
        count = query.find(User.class).where().gt(User::getId, 1)
                .and(g -> g.group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)).or()
                        .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15)))
                .count();
        assertEquals(count, 2);

        //  混合使用
        count = query.find(User.class).where().gt(User::getId, 1).and(g -> g.group().eq(User::getId, 2).and()
                .eq(User::getAge, 5).endGroup().or().group().eq(User::getId, 3).and().eq(User::getAge, 15).endGroup())
                .count();
        assertEquals(count, 2);

        // 混合使用，这个使用方法不建议，太难看懂了
        count = query.find(User.class).where().gt(User::getId, 1).and(g -> g.group(g1 -> g1.eq(User::getId, 2).and()
                .eq(User::getAge, 5).endGroup().or().group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15))))
                .count();
        assertEquals(count, 2);
    }

    // @Test
    // void test1111() {
    // JdbcClassMapping<?> classMapping =
    // mappingFactory.getClassMapping(Tree2.class);
    // System.err.println(ClassMappingUtils.getSelectColumnsSql(classMapping,
    // "t0", Dialects.MYSQL, mappingFactory,
    // new HashChainMap<String, String>().putChain("parent", "t1")));
    //
    // }
}
