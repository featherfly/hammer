
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin4Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_E_R1R2R3R4_on1() {
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

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
                .eq(Order2::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        Tuple5<Order2, User2, User2, User2, User2> orderUser4 = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser).fetch() //
                .join(User2.class).on(Order2::getUpdateUser).fetch() //
                .join(User2.class).on(Order2::getUser1).fetch() //
                .join(User2.class).on(Order2::getUser2).fetch() //
                .where() //
                .eq(Order2::getId, oid1) //
                .single();
        assertNotNull(orderUser4.get0());
        assertNotNull(orderUser4.get1());
        assertNotNull(orderUser4.get2());
        assertNotNull(orderUser4.get3());
        assertNotNull(orderUser4.get4());

        assertEquals(order.getCreateUser(), orderUser4.get1().getId());
        assertEquals(order.getUpdateUser(), orderUser4.get2().getId());
        assertEquals(order.getUser1(), orderUser4.get3().getId());
        assertEquals(order.getUser2(), orderUser4.get4().getId());

    }
}
