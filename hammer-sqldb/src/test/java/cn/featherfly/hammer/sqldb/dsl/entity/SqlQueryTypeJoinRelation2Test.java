
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeJoinRelation2Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_ER1_ER2_R3E() {
        order = query.find(Order.class).join(Order::getUserInfo).join(Order::getCreateUser)
                .join(OrderInfo::getOrder).where().eq(Order::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3() {
        order = query.find(Order.class).join(Order::getUserInfo).join(Order::getCreateUser)
                .join(Order::getUpdateUser).where().eq(Order::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join(Order::getCreateUser)
                .join(Order::getUpdateUser).where().eq(Order::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join(Order::getCreateUser).fetch()
                .join(Order::getUpdateUser).where().eq(Order::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join(Order::getCreateUser).fetch()
                .join(Order::getUpdateUser).fetch().where().eq(Order::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNotNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_EE() {
        order = query.find(Order.class).join(Order::getUpdateUser).join(Order::getCreateUser).join(Order::getParent)
                .where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
        assertNotNull(order.getParent().getId());
        assertNull(order.getParent().getNo());

        order = query.find(Order.class).join(Order::getUpdateUser).join(Order::getCreateUser).join(Order::getParent)
                .fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
        assertNotNull(order.getParent().getId());
        assertNotNull(order.getParent().getNo());
    }

    @Test
    void testJoin_ER1_ER2_R1R1() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
                .join2(Order::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join2(Order::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join2(Order::getParent).fetch().where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNotNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_R1R3() {
        order = query.find(Order.class).join(Order::getUserInfo).join(Order::getCreateUser)
                .join2(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNull(order.getUserInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join(Order::getCreateUser)
                .join2(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNull(order.getUserInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInfo).fetch().join(Order::getCreateUser)
                .join2(UserInfo::getUser).fetch().where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNotNull(order.getUserInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).fetch().join(Order::getUpdateUser)
                .join2(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_R3R2() {
        order = query.find(Order.class).join(Order::getUserInfo).join(Order::getCreateUser)
                .join3(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNull(order.getUserInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_R2R3() {
        order = query.find(Order.class).join(Order::getCreateUser).join(Order::getUserInfo)
                .join3(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNull(order.getUserInfo().getName());
        assertNull(order.getUserInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).join(Order::getUserInfo).fetch()
                .join3(UserInfo::getUser).where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNull(order.getUserInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).join(Order::getUserInfo).fetch()
                .join3(UserInfo::getUser).fetch().where().eq(Order::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInfo().getId());
        assertNotNull(order.getUserInfo().getName());
        assertNotNull(order.getUserInfo().getUser().getId());
        assertNotNull(order.getUserInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
    }
}
