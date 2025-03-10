
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Tree2;

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
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);
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
        assertNotNull(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser) //
            .fetch() //
            .where().eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getUsername());

        user = query.find(User.class) //
            .join(UserInfo::getUser) //
            .join(UserRole2::getUser) //
            .where().eq(User::getId, uid).single();
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

        Integer id = 1;

        user = query.find(User.class).join(UserInfo::getUser).where().eq2(UserInfo::getId, 1).single();

        Tuple2<User, UserInfo> userUserInfo = query.find(User.class).join(UserInfo::getUser).fetch().where()
            .eq2(UserInfo::getId, id).single();
        assertEquals(userUserInfo.get1().getId(), id);
        assertEquals(userUserInfo.get1().getUser().getId(), userUserInfo.get0().getId());

        List<UserInfo> list = query.find(UserInfo.class).join(UserInfo::getUser).join2(UserRole2::getUser)
            .join3(UserRole2::getRole).list();
        System.out.println(list.size());

        query.find(Tree.class).join(Tree::getParent).list();

        query.find(Tree.class).join(Tree::getParent).join2(Tree::getParent).list();
    }

    @Test
    void testJoin1() {

        User user = new User();
        String username = "yufei";
        user.setUsername(username);

        User u = query.find(User.class).where().eq(User::getUsername, username).single();

        List<UserInfo> list = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getUsername)
            .eq(username).list();
        for (UserInfo ui : list) {
            assertEquals(ui.getUser().getId(), u.getId());
        }
    }

    @Test
    void testJoin1_1() {
        User user = new User();
        String username = "yufei";
        user.setUsername(username);

        User u = query.find(User.class).where().eq(User::getUsername, username).single();

        List<UserInfo> list = null;

        list = query.find(UserInfo.class).where().property(UserInfo::getUser) //
            .eq(user).list();
        for (UserInfo ui : list) {
            assertEquals(ui.getUser().getId(), u.getId());
        }

        list = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
        for (UserInfo ui : list) {
            assertEquals(ui.getUser().getId(), u.getId());
        }
    }

    @Test
    void testJoin1_2() {
        User user = new User();
        String username = "yufei";
        user.setUsername(username);

        User u = query.find(User.class).where().eq(User::getUsername, username).single();

        List<UserInfo> list = null;

        list = query.find(UserInfo.class).where().property(UserInfo::getUser) //
            .eq(user).list();
        for (UserInfo ui : list) {
            assertEquals(ui.getUser().getId(), u.getId());
        }

        list = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
        for (UserInfo ui : list) {
            assertEquals(ui.getUser().getId(), u.getId());
        }
    }

    @Test
    void testJoinCondition2() {
        Integer userInfoId = 1;
        Integer userId = 1;
        User user = null;

        user = query.find(User.class).join(UserInfo::getUser).where().eq(User::getId, userId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).join(UserInfo::getUser).where().eq2(UserInfo::getId, userInfoId).single();
        assertEquals(user.getId(), userId);

        user = query.find(User.class).join(UserInfo::getUser).where()
            .property((e1, e2) -> e2.property(UserInfo::getId).eq(userInfoId)).single();
        assertEquals(user.getId(), userId);
    }

    @Test
    void testJoinCondition2_EntityProperty() {
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setUsername("yufei");
        userInfo.setUser(user);

        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where() //
            .property(UserInfo::getUser).property(User::getUsername).eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);
    }

    @Test
    void testJoinCondition2_EntityPropertyAutoJoin() {
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setUsername("yufei");
        user.setMobileNo("12345678901");
        userInfo.setUser(user);
        userInfo.setId(1);

        //        List<UserInfo> userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).list();
        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getMobileNo).eq(userInfo.getUser().getMobileNo()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().eq(userInfo::getId).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).and().lt(UserInfo::getUser, User::getAge, 10).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().eq(userInfo::getId).and().property(UserInfo::getUser)
            .property(User::getAge).lt(userInfo.getUser().getAge()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(UserInfo::getId, 2).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().eq(UserInfo::getId, 2).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).and().ge(UserInfo::getUser, User::getAge, 10).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().eq(userInfo::getId).and().property(UserInfo::getUser)
            .property(User::getAge).ge(1000).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().property(UserInfo::getUser).property(User::getUsername)
            .eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).and().eq(userInfo::getId).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().property(UserInfo::getUser).property(User::getUsername)
            .eq(userInfo.getUser().getUsername()).and().eq(userInfo::getId).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().property(UserInfo::getUser).property(User::getUsername)
            .eq(userInfo.getUser().getUsername()).and().eq(UserInfo::getId, 2).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);

        user.setUsername("yufei1111");
        //        userInfos = query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getUser, User::getUsername).list();
        userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getMobileNo)
            .eq(userInfo.getUser().getMobileNo()).and().property(UserInfo::getUser).property(User::getUsername)
            .eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 0);
    }

    @Test
    void testJoinMulity() {
        List<Tree> list1 = query.find(Tree.class).list();
        list1.forEach(v -> {
            System.err.println(v);
            assertNotNull(v.getId());
        });

        List<Tree> list2 = query.find(Tree.class).join(Tree::getParent).list();
        list2.forEach(v -> {
            if (v.getId().intValue() == 1) {
                assertNull(v.getParent().getId());
            } else {
                assertNotNull(v.getParent().getId());
            }
        });

        list2 = query.find(Tree.class) //
            .join(Tree::getParent) //
            .join(Tree::getParent) // ENHANCE 这里自关联没有关联上，是否需要对已经映射的对象属性进行多次join再考虑
            .list();
        list2.forEach(v -> {
            if (v.getId().intValue() == 1) {
                assertNull(v.getParent().getId());
            } else {
                assertNotNull(v.getParent().getId());
            }
        });

        assertTrue(list1.size() == list2.size());

        List<Tuple2<Tree2, Tree2>> listTuple2 = query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch() //
            .list();
        listTuple2.forEach(v -> {
            assertEquals(v.get0().getParentId(), v.get1().getId());
        });

        List<Tree> list3 = query.find(Tree.class).join(Tree::getParent) //
            .fetch() //
            .list();
        list3.forEach(v -> {
            if (v.getId().intValue() == 1) {
                assertNull(v.getParent().getId());
            } else {
                assertNotNull(v.getParent().getId());
                assertNotNull(v.getParent().getName());
            }
        });

        List<Tree> list4 = query.find(Tree.class) //
            .join(Tree::getParent) //
            .fetch() //
            .join2(Tree::getParent) //
            .fetch() //
            .list();
        list4.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            assertNotNull(v.getParent().getParent());
            assertNotNull(v.getParent().getParent().getId());
            assertNotNull(v.getParent().getParent().getName());
        });

        List<Tuple3<Tree2, Tree2, Tree2>> listTuple3 = query.find(Tree2.class) //
            .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch()
            //                .join2(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch() //
            .join(Tree2.class).on((e1, e2, j) -> j.property(Tree2::getId).eq(e2.property(Tree2::getParentId))) //
            .fetch() //
            .list();
        listTuple3.forEach(v -> {
            assertEquals(v.get0().getParentId(), v.get1().getId());
            assertEquals(v.get1().getParentId(), v.get2().getId());
        });

        // query.find(UserInfo.class).join(UserRole2::getUser).list();

        // query.find(User.class).join(UserRole2::getUser);
        // query.find(User.class).join(UserRole2::getUser)
        // .join(UserRole2::getRole);
        // query.find(User.class).join(UserRole2::getUser).join(UserRole2::getRole).where();
        // query.find(UserInfo.class).join(UserInfo::getUser).on(propertyName);

        //        List<Tree> list4 = query.find(Tree.class) //
        //            .join(Tree::getParent) //
        //            .fetch() //
        //            .join2(Tree::getParent) //
        //            .fetch() //
        //            .join3(Tree::getParent) //
        //            .fetch() //
        //            .list();
    }

    @Test
    void testJoinMulity2() {
        List<Tuple2<UserInfo, UserRole2>> listTuple2 = null;
        listTuple2 = query.find(UserInfo.class) //
            .join(UserInfo::getUser).fetch() //
            .join2(UserRole2::getUser).fetch() //
            .join3(UserRole2::getRole) //
            .list();
        listTuple2.forEach(t -> {
            assertNotNull(t.get0().getUser().getId());
            assertNotNull(t.get0().getUser().getUsername());
            assertEquals(t.get0().getUser().getId(), t.get1().getUser().getId());
            assertNotNull(t.get1().getUser().getId());
            assertNotNull(t.get1().getRole().getId());
        });

        listTuple2 = query.find(UserInfo.class) //
            .join(UserInfo::getUser).fetch() //
            .join2(UserRole2::getUser).fetch() //
            .join3(UserRole2::getRole).fetch() //
            .list();

        listTuple2.forEach(t -> {
            assertNotNull(t.get0().getUser().getId());
            assertNotNull(t.get0().getUser().getUsername());
            assertEquals(t.get0().getUser().getId(), t.get1().getUser().getId());
            assertNotNull(t.get1().getUser().getId());
            //            assertNotNull(t.get1().getUser().getUsername()); // 没有获取 .join2(UserRole2::getUser).fetch() 是获取UserRole2
            assertNotNull(t.get1().getRole().getId());
            assertNotNull(t.get1().getRole().getName());
        });
    }
}
