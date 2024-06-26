
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeJoinRelationTest extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_ER() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).where().eq(UserInfo::getId, uid1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());
        /*
         SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp`
         FROM `user_info` _user_info0
         JOIN `user` _user0 ON _user0.`id` = _user_info0.`user_id` WHERE _user_info0.`id` = ?
         */

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, uid1)
                .single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNotNull(userInfo.getUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2() {
        order = query.find(Order.class).join(Order::getCreateUser).join(Order::getUpdateUser).where()
                .eq(Order::getId, id1).single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
        /*
         SELECT _order0.`id` `id`, _order0.`no` `no`, _order0.`app_id` `appId`, _order0.`app_key` `appKey`, _order0.`wx_package` `packageValue`, _order0.`wx_package_expire_time` `packageExpireTime`, _order0.`alipay_trade_no` `tradeNo`, _order0.`create_user` `createUser.id`, _order0.`update_user` `updateUser.id`
        FROM `order` _order0
        JOIN `user` _user0 ON _user0.`id` = _order0.`create_user`
        JOIN `user` _user1 ON _user1.`id` = _order0.`update_user`
        WHERE _order0.`id` = ?
         */

        order = query.find(Order.class).join(Order::getCreateUser).fetch().join(Order::getUpdateUser).where()
                .eq(Order::getId, id1).single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).fetch().join(Order::getUpdateUser).fetch().where()
                .eq(Order::getId, id1).single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNotNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_R2E() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).join(Order::getUserInfo).where()
                .eq(UserInfo::getId, uid2).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid2);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

        /*
        SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp`
        FROM `user_info` _user_info0
        JOIN `user` _user0 ON _user0.`id` = _user_info0.`user_id`
        JOIN `order` _order0 ON _order0.`user_info` = _user_info0.`id`
        WHERE _user_info0.`id` = ?
         */

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().join(Order::getUserInfo).where()
                .eq(UserInfo::getId, uid2).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid2);
        assertNotNull(userInfo.getUser().getId());
        assertNotNull(userInfo.getUser().getUsername());
    }

    @Test
    void testJoin_EE() {
        order = query.find(Order.class).join(Order::getParent).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getParent().getId());
        assertEquals(order.getParent().getId(), id1);
        assertNull(order.getParent().getNo());

        order = query.find(Order.class).join(Order::getParent).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getParent().getId());
        assertEquals(order.getParent().getId(), id1);
        assertNotNull(order.getParent().getNo());
    }

    @Test
    void testJoin_RE() {
        user = query.find(User.class).join(UserInfo::getUser).where().eq(User::getId, uid1).single();
        System.err.println(user);
        assertEquals(user.getId(), uid1);
        /*
         SELECT _user0.`id` `id`, _user0.`username` `username`, _user0.`password` `pwd`, _user0.`mobile_no` `mobileNo`, _user0.`age` `age`
         FROM `user` _user0
         JOIN `user_info` _user_info0 ON _user_info0.`user_id` = _user0.`id` WHERE _user0.`id` = ?
         */
    }

    //    @Test
    //    void testJoin_RE_Exception() {
    //        Tuple2<User, UserInfo> tupleUserUserInfo = query.find(User.class).join(UserInfo::getUser).fetch().where()
    //                .eq(User::getId, uid1).single();
    //
    //        //      userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().join2(UserRole2::getUser).fetch().where()
    //        Tuple2<UserInfo, UserRole2> tupleUserInfoRole2 = query.find(UserInfo.class).join(UserInfo::getUser).fetch()
    //                .join2(UserRole2::getUser).fetch().where().eq(UserInfo::getId, uid1).single();
    //        System.err.println(tupleUserInfoRole2);
    //        userInfo = tupleUserInfoRole2.get0();
    //        System.err.println(userInfo);
    //        assertEquals(userInfo.getId(), uid1);
    //        assertNotNull(userInfo.getUser().getId());
    //        assertNotNull(userInfo.getUser().getUsername());
    //    }

    @Test
    void testJoin1_ER1_R2E() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).join2(UserRole2::getUser).where()
                .eq(UserInfo::getId, uid1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());
        /*
         SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp`
        FROM `user_info` _user_info0
        JOIN `user` _user0 ON _user0.`id` = _user_info0.`user_id`
        JOIN `user_role` _user_role0 ON _user_role0.`user_id` = _user0.`id`
        WHERE _user_info0.`id` = 1
         */
    }

    @Test
    void testJoin1_ER1_R1R2() {
        order = query.find(Order.class).join(Order::getUserInfo).join2(UserInfo::getUser).where().eq(Order::getId, id1)
                .single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNull(order.getUserInfo().getUser());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join2(UserInfo::getUser).where()
                .eq(Order::getId, id1).single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNull(order.getUserInfo().getUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join2(UserInfo::getUser).fetch().where()
                .eq(Order::getId, id1).single();

        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNotNull(order.getUserInfo().getUser().getUsername());
    }

    @Test
    void testJoin1_EE_EE_() {
        // EE1_E1E2_E2E3
        tree = query.find(Tree.class).join(Tree::getParent).fetch().join2(Tree::getParent).fetch()
                .join3(Tree::getParent).fetch().where().eq(Tree::getId, tid).single();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
                _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`,
                _tree2.`parent_id` `parent.parent.parent.id`, _tree2.`name` `parent.parent.name`,
                _tree3.`parent_id` `parent.parent.parent.parent.id`, _tree3.`name` `parent.parent.parent.name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
        JOIN `tree` _tree3 ON _tree3.`id` = _tree2.`parent_id`
        WHERE _tree0.`id` = 7
         */

        //        query.find(UserInfo.class).join(UserInfo::getUser).join2(UserRole2::getUser);
        //        query.find(User.class).join(UserInfo::getUser).join(UserRole2::getUser);
        //            .join(User::getDevices).join(UserInfo::getUser);

    }

    @Test
    void testJoin1_EE_EE() {
        // EE1_E1E2
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */
        tree = query.find(Tree.class).join(Tree::getParent).join2(Tree::getParent).where().eq(Tree::getId, tid)
                .single();
        assertTree(tree, false);
        assertNull(tree.getParent().getParent());
        // EE1_E1E2 fetched
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
            _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */
        tree = query.find(Tree.class).join(Tree::getParent).fetch().join2(Tree::getParent).where().eq(Tree::getId, tid)
                .single();
        assertTree(tree, true);
        assertTree(tree.getParent(), false);
        assertNull(tree.getParent().getParent().getParent());
        // EE1_E1E2
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
            _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`,
            _tree2.`parent_id` `parent.parent.parent.id`, _tree2.`name` `parent.parent.name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */
        tree = query.find(Tree.class).join(Tree::getParent).fetch().join2(Tree::getParent).fetch().where()
                .eq(Tree::getId, tid).single();
        assertTree(tree, true);
        assertTree(tree.getParent(), true);
        assertNotNull(tree.getParent().getParent().getParent());
        assertNull(tree.getParent().getParent().getParent().getParent());

        // EE1_E1E2
        tree = query.find(Tree.class).join(Tree::getParent).fetch().join2(Tree::getParent).fetch()
                .join3(Tree::getParent).fetch().where().eq(Tree::getId, tid).single();

        assertTree(tree, true);
        assertTree(tree.getParent(), true);
        assertTree(tree.getParent().getParent(), true);
        assertNotNull(tree.getParent().getParent().getParent().getParent());

        // EE1_EE2
        trees = query.find(Tree.class).join(Tree::getParent).join(Tree::getParent).list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree0.`parent_id`
         */
    }
}
