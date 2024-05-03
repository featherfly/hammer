
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * entity sql query join 5 times test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin5Test extends AbstractEntitySqlQueryJoinTest {

    Timer timer;

    @BeforeMethod
    void beforeMethod() {
        timer = Timer.start();
    }

    @AfterMethod
    void afterMethod() {
        long time = timer.stop();
        System.out.println(Strings.format("use time {0}", time));
    }

    @Test
    void testJoin_E_R1R2R3R4R5_on1() {
        Order2 order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser)//
            .join(User2.class).on(Order2::getUpdateUser)//
            .join(User2.class).on(Order2::getUser1) //
            .join(User2.class).on(Order2::getUser2) //
            .join(User2.class).on(Order2::getUser3) //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        order = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser)//
            .join(User2.class).on(Order2::getUpdateUser)//
            .join(User2.class).on(Order2::getUser1) //
            .join(User2.class).on(Order2::getUser2) //
            .join(User2.class).on(Order2::getUser3) //
            .where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        Tuple6<Order2, User2, User2, User2, User2, User2> orderUser5 = query.find(Order2.class) //
            .join(User2.class).on(Order2::getCreateUser).fetch() //
            .join(User2.class).on(Order2::getUpdateUser).fetch() //
            .join(User2.class).on(Order2::getUser1).fetch() //
            .join(User2.class).on(Order2::getUser2).fetch() //
            .join(User2.class).on(Order2::getUser3).fetch() //
            .where() //
            .eq(Order2::getId, oid1) //
            .single();
        assertNotNull(orderUser5.get0());
        assertNotNull(orderUser5.get1());
        assertNotNull(orderUser5.get2());
        assertNotNull(orderUser5.get3());
        assertNotNull(orderUser5.get4());
        assertNotNull(orderUser5.get5());

        assertEquals(order.getCreateUser(), orderUser5.get1().getId());
        assertEquals(order.getUpdateUser(), orderUser5.get2().getId());
        assertEquals(order.getUser1(), orderUser5.get3().getId());
        assertEquals(order.getUser2(), orderUser5.get4().getId());
        assertEquals(order.getUser3(), orderUser5.get5().getId());

        //        User2 createUser = hammer.get(orderUser5.get1().getId(), User2.class);
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
