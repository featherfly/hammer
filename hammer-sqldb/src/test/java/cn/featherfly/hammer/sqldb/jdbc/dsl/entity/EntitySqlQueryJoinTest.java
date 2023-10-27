
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
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
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig.getDslConfig().getQueryConfig());
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

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, uid).single();
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
        user.setUsername("yufei");
        userInfo.setUser(user);

        //        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
        //                .eq(userInfo::getUser, User::getPwd).list();
        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where() //
                .property(UserInfo::getUser).property(User::getUsername).eq(userInfo.getUser().getUsername()).list();
        System.out.println(userInfos.size());
        assertTrue(userInfos.size() == 1);

    }

    @Test
    void testJoinCondition2_2() {

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
        });

        List<Tree> list2 = query.find(Tree.class).join(Tree::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
        });

        list2 = query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).list();
        list2.forEach(v -> {
            assertNotNull(v.getParent().getId());
        });

        assertTrue(list1.size() > list2.size());

        List<Tuple2<Tree2, Tree2>> listTuple2 = query.find(Tree2.class) //
                .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch() //
                .list();
        listTuple2.forEach(v -> {
            assertEquals(v.get0().getParentId(), v.get1().getId());
        });

        List<Tree> list3 = query.find(Tree.class).join(Tree::getParent).fetch().list();
        list3.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
        });

        List<Tree> list4 = query.find(Tree.class).join(Tree::getParent).fetch().join2(Tree::getParent).fetch().list();
        list4.forEach(v -> {
            assertNotNull(v.getParent().getId());
            assertNotNull(v.getParent().getName());
            assertNotNull(v.getParent().getParent());
            assertNotNull(v.getParent().getParent().getId());
            assertNotNull(v.getParent().getParent().getName());
        });

        List<Tuple3<Tree2, Tree2, Tree2>> listTuple3 = query.find(Tree2.class) //
                .join(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch() //
                .join2(Tree2.class).on(Tree2::getParentId, Tree2::getId).fetch() //
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
    }

    @Test
    void testJoinMulity2() {
        // 因为User类中没有UserRole类的关系，所以fetch时会找不到关系，不fetch只是使用条件查询问题不大
        // userInfo.user.userRole 这里没有userRole

        List<Tuple2<UserInfo, UserRole2>> listTuple2 = query.find(UserInfo.class) //
                .join(UserInfo::getUser).fetch() //
                .join2(UserRole2::getUser).fetch() //
                .join3(UserRole2::getRole).list();
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
                .join3(UserRole2::getRole).fetch() // FIXME 这里在拼接 select alias时有问题（_user_role0.user.id.role.id）
                .list();
        // FIXME 上面的错误，是因为join2(UserRole2::getUser)这一次生成的Relation对象的joinFromPropertyName的问题
        // 可能需要在逻辑上判断双向和单项映射的问题，后续来修复这个问题
        listTuple2.forEach(t -> {
            assertNotNull(t.get0().getUser().getId());
            assertNotNull(t.get0().getUser().getUsername());
            assertEquals(t.get0().getUser().getId(), t.get1().getUser().getId());
            assertNotNull(t.get1().getUser().getId());
            assertNotNull(t.get1().getUser().getUsername());
            assertNotNull(t.get1().getRole().getId());
            assertNotNull(t.get1().getRole().getName());
        });
    }
}
