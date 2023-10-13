
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoinTest extends JdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid = 1;
    List<Tree> trees = new ArrayList<>();

    @BeforeTest
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        trees = new ArrayList<>();
    }

    @Test
    void testJoin() {

        StringBuilder sb = new StringBuilder();
        sb.append("").append("").append("");

        UserInfo userInfo = null;
        User user = null;

        Integer uid = 1;
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).where().eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNull(userInfo.getUser().getUsername());

        //        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, 1).single();
        //        Tuple2<UserInfo, User> t2 = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where()
        //                .eq(UserInfo::getId, 1).single();
        //        System.err.println(t2);
        //        assertEquals(t2.get0().getId(), uid);
        //        assertNotNull(t2.get1().getUsername());

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

        // YUFEI_TEST 后续来测试
        //        List<UserInfo> list = query.find(UserInfo.class).join(UserInfo::getUser).join(UserRole2::getUser)
        //                .join(UserRole2::getRole).list();
        //        System.out.println(list.size());

        query.find(Tree.class).join(Tree::getParent).list();

        query.find(Tree.class).join(Tree::getParent).join2(Tree::getParent).list();
    }

    @Test
    void testJoin1() {

        User user = new User();
        String username = "yufei";
        user.setUsername(username);

        // IMPLSOON property(UserInfo::getUser).property(User::getUsername) 联表查询，仅查询不获取，如果没有join的话需要自动join
        // List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getUser, User::getUsername, username).list();
        List<UserInfo> list = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getUsername)
                .eq(username).list();

        // IMPLSOON UserInfo::getUser, user 联表查询，仅查询不获取，如果没有join的话需要自动join
        list = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testJoinFetchException() {

        // 因为User类中没有UserRole类的关系，所以fetch时会找不到关系，不fetch只是使用条件查询问题不大
        // userInfo.user.userRole 这里没有userRole

        // YUFEI_TEST 后续来测试
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
        // YUFEI_TEST 后续来测试
        //
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

        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setPwd("123456");
        userInfo.setUser(user);

        //        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
        //                .eq(userInfo::getUser, User::getPwd).list();
        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
                .property(UserInfo::getUser).property(User::getPwd).eq(userInfo.getUser().getPwd()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

    }

    @Test
    void testJoinCondition2_2() {

        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setPwd("123456");
        user.setUsername("yufei");
        userInfo.setUser(user);
        userInfo.setId(1);

        //        List<UserInfo> userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).list();
        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().eq(userInfo::getId).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).and().lt(UserInfo::getUser, User::getAge, 10).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().eq(userInfo::getId).and().property(UserInfo::getUser)
                .property(User::getAge).lt(userInfo.getUser().getAge()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(UserInfo::getId, 2).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().eq(UserInfo::getId, 2).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).and().ge(UserInfo::getUser, User::getAge, 10).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().eq(userInfo::getId).and().property(UserInfo::getUser)
                .property(User::getAge).ge(10).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().property(UserInfo::getUser).property(User::getUsername)
                .eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).and().eq(userInfo::getId).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().property(UserInfo::getUser).property(User::getUsername)
                .eq(userInfo.getUser().getUsername()).and().eq(userInfo::getId).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().property(UserInfo::getUser).property(User::getUsername)
                .eq(userInfo.getUser().getUsername()).and().eq(UserInfo::getId, 2).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        user.setUsername("yufei1111");
        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getPwd)
                .eq(userInfo.getUser().getPwd()).and().property(UserInfo::getUser).property(User::getUsername)
                .eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);
    }

    @Test
    void testJoinMulity() {

        List<Tree> list1 = query.find(Tree.class).list();
        list1.forEach(v -> {
            System.err.println(v);
        });

        List<Tree> list2 = query.find(Tree.class).join(Tree::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        list2 = query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
            System.err.println(v);
        });

        //        List<Tuple2<Tree2, Tree2>> list3 = query.find(Tree2.class).join(Tree2::getParent).fetch().list();
        //        list3.forEach(v -> {
        //            assertNotNull(v.get0().getParent().getId());
        //            assertNotNull(v.get0().getParent().getName());
        //            System.err.println(v);
        //        });
        List<Tree> list3 = query.find(Tree.class).join(Tree::getParent).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            System.err.println(v);
        });

        // YUFEI_TEST 后续实现了再来处理
        //        List<Tuple3<Tree2, Tree2, Tree2>> list4 = query.find(Tree2.class).join(Tree2::getParent).fetch()
        //                .join1(Tree2::getParent).fetch().list();
        //        list4.forEach(v -> {
        //            assertNotNull(v.get0().getParent().getId());
        //            assertNotNull(v.get0().getParent().getName());
        //            System.err.println(v);
        //        });

        assertTrue(list1.size() > list2.size());

        // query.find(UserInfo.class).join(UserRole2::getUser).list();

        // query.find(User.class).join(UserRole2::getUser);
        // query.find(User.class).join(UserRole2::getUser)
        // .join(UserRole2::getRole);
        // query.find(User.class).join(UserRole2::getUser).join(UserRole2::getRole).where();
        // query.find(UserInfo.class).join(UserInfo::getUser).on(propertyName);
    }
}