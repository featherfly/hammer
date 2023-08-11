
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin4Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_E_R1R2R3R4() {
        Order2 order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(Order2::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        Tuple5<Order2, User2, User2, User2, User2> orderUser5 = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser).fetch() //
                .join(User2.class).on(Order2::getUpdateUser).fetch() //
                .join(User2.class).on(Order2::getUser1).fetch() //
                .join(User2.class).on(Order2::getUser2).fetch() //
                .where() //
                .eq(Order2::getId, oid1) //
                .single();
        assertNotNull(orderUser5.get0());
        assertNotNull(orderUser5.get1());
        assertNotNull(orderUser5.get2());
        assertNotNull(orderUser5.get3());
        assertNotNull(orderUser5.get4());

        assertEquals(order.getCreateUser(), orderUser5.get1().getId());
        assertEquals(order.getUpdateUser(), orderUser5.get2().getId());
        assertEquals(order.getUser1(), orderUser5.get3().getId());
        assertEquals(order.getUser2(), orderUser5.get4().getId());

        //        order = query.find(Order2.class).join(Order2::getUser1, User2.class)
        //                .join((e1, e2) -> e1, Order2::getUser2, User2.class).where().eq(Order2::getId, oid1).single();
        //        assertNotNull(order);
        //        assertEquals(order.getId(), oid1);
        //
        //        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(Order2::getUser1, User2.class).fetch()
        //                .join(Order2::getUser2, User2.class).where().eq(Order2::getId, oid1).single();
        //        assertNotNull(orderUser);
        //        assertEquals(orderUser.get0().getId(), oid1);
        //        assertEquals(orderUser.get1().getId(), orderUser.get0().getUser1());
        //
        //        orderUser = query.find(Order2.class).join(Order2::getUser1, User2.class).join(Order2::getUser2, User2.class)
        //                .fetch().where().eq(Order2::getId, oid1).single();
        //        assertNotNull(orderUser);
        //        assertEquals(orderUser.get0().getId(), oid1);
        //        assertEquals(orderUser.get1().getId(), orderUser.get0().getUser2());
        //
        //        Tuple3<Order2, User2, User2> orderUserUser = query.find(Order2.class).join(Order2::getUser1, User2.class)
        //                .fetch().join(Order2::getUser2, User2.class).fetch().where().eq(Order2::getId, oid1).single();
        //        assertNotNull(orderUserUser);
        //        assertEquals(orderUserUser.get0().getId(), oid1);
        //        assertEquals(orderUserUser.get1().getId(), orderUserUser.get0().getUser1());
        //        assertEquals(orderUserUser.get2().getId(), orderUserUser.get0().getUser2());
    }
}
