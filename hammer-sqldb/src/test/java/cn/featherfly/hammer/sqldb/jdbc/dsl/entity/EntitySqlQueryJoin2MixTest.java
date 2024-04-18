
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.sqldb.jdbc.vo.OrderMix;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin2MixTest extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_E_R1_R2() {
        OrderMix order = null;
        User user = null;

        order = query.find(OrderMix.class) //
                .join(User.class).on(OrderMix::getCreateUser) //
                .join(OrderMix::getUser1) //
                .where() //
                .eq(OrderMix::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser());
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());

        order = query.find(OrderMix.class) //
                .join(User.class).on(OrderMix::getCreateUser) //
                .join(OrderMix::getUser1).fetch() //
                .where() //
                .eq(OrderMix::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser());
        assertNotNull(order.getUser1().getId());
        assertNotNull(order.getUser1().getUsername());

        Tuple2<OrderMix, User> t2 = query.find(OrderMix.class) //
                .join(OrderMix::getUser1) //
                .join(User.class).on(OrderMix::getCreateUser).fetch() //
                .where() //
                .eq(OrderMix::getId, oid1) //
                .single();
        order = t2.get0();
        user = t2.get1();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser());
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(user);
        assertNotNull(user.getUsername());

        t2 = query.find(OrderMix.class) //
                .join(OrderMix::getUser1).fetch() //
                .join(User.class).on(OrderMix::getCreateUser).fetch() //
                .where() //
                .eq(OrderMix::getId, oid1) //
                .single();
        order = t2.get0();
        user = t2.get1();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser());
        assertNotNull(order.getUser1().getId());
        assertNotNull(order.getUser1().getUsername());
        assertNotNull(user);
        assertNotNull(user.getUsername());

        //        t2 = query.find(OrderMix.class) //
        //                .join(User.class).on(OrderMix::getCreateUser).fetch() //
        //                .join(OrderMix::getUser1).fetch() //
        //                .where() //
        //                .eq(OrderMix::getId, oid1) //
        //                .single();
        //        order = t2.get0();
        //        user = t2.get1();
        //        assertNotNull(order);
        //        assertEquals(order.getId(), oid1);
        //        assertNotNull(order.getCreateUser());
        //        assertNotNull(order.getUser1().getId());
        //        assertNull(order.getUser1().getUsername());
        //        assertNotNull(user);
        //        assertNotNull(user.getUsername());

    }

    //    @Test
    //    void test() {
    //        OrderMix order = null;
    //        User user = null;
    //        Tuple2<OrderMix, User> t2 = null;
    //
    //        t2 = query.find(OrderMix.class) //
    //                .join(OrderMix::getUser1).fetch() //
    //                .join(User.class).on(OrderMix::getCreateUser).fetch() //
    //                .where() //
    //                .eq(OrderMix::getId, oid1) //
    //                .single();
    //        order = t2.get0();
    //        user = t2.get1();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //        assertNotNull(order.getCreateUser());
    //        assertNotNull(order.getUser1().getId());
    //        assertNotNull(order.getUser1().getUsername());
    //        assertNotNull(user);
    //        assertNotNull(user.getUsername());
    //    }
}
