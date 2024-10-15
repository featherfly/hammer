
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin2Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_E_R1R2_on1() {
        Order2 order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser) //
            .join(User2.class).on(Order2::getUser1) //
            .where() //
            .eq(Order2::getId, oid1) //
            .single(); //
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser) //
            .join(User2.class).on(Order2::getUser1) //
            .where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
            .eq(Order2::getId, oid1) //
            .single(); //
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        Tuple2<Order2, User2> orderUser = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser).fetch() //
            .join(User2.class).on(Order2::getUser1) //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(orderUser);
        assertEquals(orderUser.get0().getId(), oid1);
        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    }

    @Test
    void testJoin_E_R1R2_on3() {
        Order2 order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser, User2::getId) //
            .join(User2.class).on(Order2::getUser1, User2::getId) //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser, User2::getId) //
            .join(User2.class).on(Order2::getUser1, User2::getId) //
            .where() //
            .eq2(User2::getId, uid1) //
            .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        // ****************************************************************************************************************

        Tuple3<Order2, User2, User2> orderUser = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser, User2::getId).fetch() //
            .join(User2.class).on(Order2::getUser1, User2::getId).fetch() //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(orderUser);
        assertEquals(orderUser.get0().getId(), oid1);
        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
        assertEquals(orderUser.get2().getId(), orderUser.get0().getUser1());
    }

    @Test
    void testJoin_E_R1R2_on2() {
        List<User2> users = query.find(User2.class) //
            //                .property(true, User2::getId) //
            .join(Order2.class).on(Order2::getCreateUser) //
            .join(Order2.class).on(Order2::getUser1) //
            .where() //
            .eq2(Order2::getId, oid1) //
            .list();
        for (User2 user : users) {
            assertNotNull(user);
            assertEquals(user.getId(), uid1);
        }

        // ****************************************************************************************************************

        List<Tuple3<User2, Order2, Order2>> userOrders = query.find(User2.class) //
            .join(Order2.class).on(Order2::getCreateUser).fetch() //
            .join(Order2.class).on(Order2::getUser1).fetch() //
            .where() //
            .eq2(Order2::getId, oid1) //
            .list();
        for (Tuple3<User2, Order2, Order2> userOrder : userOrders) {
            assertNotNull(userOrder);
            assertEquals(userOrder.get1().getId(), oid1);
            assertEquals(userOrder.get0().getId(), userOrder.get1().getCreateUser());
            assertEquals(userOrder.get0().getId(), userOrder.get2().getUser1());
        }
    }

    @Test
    void testJoin_E_R1R2_on2__() {

        List<Tuple3<User2, Order2, Order2>> userOrders = query.find(User2.class) //
            .join(Order2.class).on(Order2::getCreateUser).fetch() //
            .join(Order2.class).on(Order2::getUser1).fetch() //
            .where() //
            .eq2(Order2::getId, oid1) //
            .list();
        for (Tuple3<User2, Order2, Order2> userOrder : userOrders) {
            assertNotNull(userOrder);
            assertEquals(userOrder.get1().getId(), oid1);
            assertEquals(userOrder.get0().getId(), userOrder.get1().getCreateUser());
            assertEquals(userOrder.get0().getId(), userOrder.get2().getUser1());
        }
    }

    @Test
    void testJoin_________() {
        Order2 order = query.find(Order2.class) //
            // IMPLSOON 后续加入join on的新实现
            //                    .join(User2.class).on(t -> t.property(Order2::getCreateUser).eq(User2::getId)) //
            .join(User2.class).on((t1, t2) -> t1.property(Order2::getCreateUser).eq(t2.property(User2::getId))) //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
    }

    //    @Test
    //    void testJoin_ER_TYPE_ER_TYPE() {
    //        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getUser1).join(User2.class)
    //                .on(Order2::getUser2).where().eq(Order2::getId, oid1).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        //        order = query.find(Order2.class).join(User2.class).on(Order2::getUser1)
    //        //                .join((e1, e2) -> e1, Order2::getUser2, User2.class).where().eq(Order2::getId, oid1).single();
    //        //        assertNotNull(order);
    //        //        assertEquals(order.getId(), oid1);
    //
    //        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(User2.class).on(Order2::getUser1).fetch()
    //                .join(User2.class).on(Order2::getUser2).where().eq(Order2::getId, oid1).single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getUser1());
    //
    //        orderUser = query.find(Order2.class).join(User2.class).on(Order2::getUser1).join(User2.class)
    //                .on(Order2::getUser2).fetch().where().eq(Order2::getId, oid1).single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getUser2());
    //
    //        Tuple3<Order2, User2, User2> orderUserUser = query.find(Order2.class).join(User2.class).on(Order2::getUser1)
    //                .fetch().join(User2.class).on(Order2::getUser2).fetch().where().eq(Order2::getId, oid1).single();
    //        assertNotNull(orderUserUser);
    //        assertEquals(orderUserUser.get0().getId(), oid1);
    //        assertEquals(orderUserUser.get1().getId(), orderUserUser.get0().getUser1());
    //        assertEquals(orderUserUser.get2().getId(), orderUserUser.get0().getUser2());
    //    }
    //
    //    @Test
    //    void testJoin_ER_RJ_ER_RJ() {
    //        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getUser1, User2::getId).join(User2.class)
    //                .on(Order2::getUser2, User2::getId).where().eq(Order2::getId, oid1).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getUser1, User2::getId)
    //                .join((e1, e2) -> e1, Order2::getUser2, User2::getId).where().eq(Order2::getId, oid1).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        // ****************************************************************************************************************
    //
    //        //        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(Order2::getCreateUser, User2::getId).fetch()
    //        //                .where().eq(Order2::getId, oid1).single();
    //        //        assertNotNull(orderUser);
    //        //        assertEquals(orderUser.get0().getId(), oid1);
    //        //        assertEquals(orderUser.get1().getId(), uid1);
    //    }
    //
    //    @Test
    //    void testJoin_RJ_RJ() {
    //        User2 user = query.find(User2.class).join(Order2.class).on(Order2::getUser1).join(Order2.class)
    //                .on(Order2::getUser2).where().eq2(Order2::getId, oid1).single();
    //        assertNull(user);
    //
    //        user = query.find(User2.class).join(Order2.class).on(Order2::getUser1).join(Order2.class)
    //                .on(Order2::getCreateUser).where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        user = query.find(User2.class).join(Order2.class).on(Order2::getUser1).join(UserInfo2.class)
    //                .on(UserInfo2::getUserId).where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        user = query.find(User2.class).join(Order2.class).on(Order2::getUser1)
    //                //
    //                .join((e1, e2) -> e1, (SerializableToNumberFunction1<UserInfo2, Integer>) UserInfo2::getUserId)
    //                //                .join((e1, e2) -> e1, UserInfo2::getUserId)
    //                //
    //                .where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        //        user = query.find(User2.class).join(Order2::getUser1)
    //        //                //
    //        //                //                        .join(es -> es.get0(), UserInfo2::getUserId)
    //        //                .join(es -> es.get0(), (SerializableToNumberFunction1<UserInfo2, Integer>) UserInfo2::getUserId)
    //        //                //
    //        //                .where().eq2(Order2::getId, oid1).single();
    //        //        assertNotNull(user);
    //        //        assertEquals(user.getId(), uid1);
    //
    //        user = query.find(User2.class).join(Order2.class).on(Order2::getUser1).join2(UserInfo2.class)
    //                .on(UserInfo2::getUserId).where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        user = query.find(User2.class).join(Order2.class).on(Order2::getUser1)
    //                .join((e1, e2) -> e2, Order2::getUserInfo, UserInfo2.class).where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        //        user = query.find(User2.class).join(Order2::getUser1)
    //        //                .join(es -> es.get1(), Order2::getUserInfo, UserInfo2.class).where().eq2(Order2::getId, oid1).single();
    //        //        assertNotNull(user);
    //        //        assertEquals(user.getId(), uid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<User2, Order2> userOrder = query.find(User2.class).join(Order2.class).on(Order2::getUser1).fetch()
    //                .join(UserInfo2.class).on(UserInfo2::getUserId).where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(userOrder);
    //        assertEquals(userOrder.get0().getId(), userOrder.get1().getUser1());
    //        assertEquals(userOrder.get1().getId(), oid1);
    //
    //        Tuple2<User2, UserInfo2> userUserInfo = query.find(User2.class).join(Order2.class).on(Order2::getUser1)
    //                .join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(userUserInfo);
    //        assertEquals(userUserInfo.get0().getId(), userUserInfo.get1().getUserId());
    //
    //        Tuple3<User2, Order2,
    //                UserInfo2> userOrderUserInfo = query.find(User2.class).join(Order2.class).on(Order2::getUser1).fetch()
    //                        .join(UserInfo2.class).on(UserInfo2::getUserId).fetch().where().eq2(Order2::getId, oid1)
    //                        .single();
    //        assertNotNull(userOrderUserInfo);
    //        assertEquals(userOrderUserInfo.get1().getId(), oid1);
    //        assertEquals(userOrderUserInfo.get0().getId(), userOrderUserInfo.get1().getUser1());
    //        assertEquals(userOrderUserInfo.get0().getId(), userOrderUserInfo.get2().getUserId());
    //    }
}
