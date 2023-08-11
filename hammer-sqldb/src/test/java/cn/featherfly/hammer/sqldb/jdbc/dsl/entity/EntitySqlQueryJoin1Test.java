
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin1Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_ER_TYPE() {
        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).where()
                .eq(Order2::getId, oid1).single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).fetch()
                .where().eq(Order2::getId, oid1).single();
        assertNotNull(orderUser);
        assertEquals(orderUser.get0().getId(), oid1);
        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    }

    @Test
    void testJoin_ER_RJ() {
        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
                .eq(Order2::getId, oid1).single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
                .eq2(User2::getId, uid1).single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);

        // ****************************************************************************************************************

        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(User2.class)
                .on(Order2::getCreateUser, User2::getId).fetch().where().eq(Order2::getId, oid1).single();
        assertNotNull(orderUser);
        assertEquals(orderUser.get0().getId(), oid1);
        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    }

    @Test
    void testJoin_RJ() {
        User2 user = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).where()
                .eq2(Order2::getId, oid1).single();
        assertNotNull(user);
        assertEquals(user.getId(), uid1);

        // ****************************************************************************************************************

        Tuple2<User2, Order2> userOrder = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).fetch()
                .where().eq2(Order2::getId, oid1).single();
        assertNotNull(userOrder);
        assertEquals(userOrder.get1().getId(), oid1);
        assertEquals(userOrder.get0().getId(), userOrder.get1().getCreateUser());
    }
}
