
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

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
public class SqlQueryTypeJoinRelation4Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_ER1_ER2_ER3_ER4_EE() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join(Order::getParent).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getParent().getId());
        assertNull(order.getParent().getNo());

        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join(Order::getParent).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getParent().getId());
        assertNotNull(order.getParent().getNo());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_ER5() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join(Order::getUserInoInfo).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join(Order::getUserInoInfo).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R5E() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join(OrderInfo::getOrder).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R1R1() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join2(Order::getParent).where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNull(orderInfo.getOrder().getParent());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join2(Order2::getParent).fetch().where()
        //                .eq(OrderInfo::getId, id2).single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId());
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join2(Order::getParent).fetch().where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNotNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R1R5() {
        order = query.find(Order.class).join(Order::getUserInoInfo).join(Order::getUser1).join(Order::getUser2)
                .join(Order::getUser3).join2(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        //        order = query.find(Order2.class)
        //                .join(Order2::getUserInoInfo)
        //                .join(Order2::getUser1)
        //                .join(Order2::getUser2)
        //                .join(Order2::getUser3)
        //                .join2(UserInfo::getUser)
        //                .fetch()
        //                .where()
        //                .eq(Order2::getId, id2)
        //                .single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUser1().getId());
        //        assertNull(order.getUser1().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());
        //        assertNotNull(order.getUserInoInfo().getId()); 
        //        assertNotNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId());
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());

        order = query.find(Order.class).join(Order::getUserInoInfo).fetch().join(Order::getUser1).join(Order::getUser2)
                .join(Order::getUser3).join2(UserInfo::getUser).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R5R1() {
        order = query.find(Order.class).join(Order::getCreateUser).join(Order::getUser1).join(Order::getUser2)
                .join(Order::getUser3).join2(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R2R2() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getOrder)
                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join3(Order::getParent).where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNull(orderInfo.getOrder().getParent());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join3(Order2::getParent).fetch().where()
        //                .eq(OrderInfo::getId, id2).single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId());
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getOrder).fetch()
                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join3(Order::getParent).fetch().where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNotNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R2R5() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUserInoInfo).join(Order::getUser2)
                .join(Order::getUser3).join3(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        //        order = query.find(Order2.class)
        //                .join(Order2::getUserInoInfo)
        //                .join(Order2::getUser1)
        //                .join(Order2::getUser2)
        //                .join(Order2::getUser3)
        //                .join3(UserInfo::getUser)
        //                .fetch()
        //                .where()
        //                .eq(Order2::getId, id2)
        //                .single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUser1().getId());
        //        assertNull(order.getUser1().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());
        //        assertNotNull(order.getUserInoInfo().getId()); 
        //        assertNotNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId());
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());

        order = query.find(Order.class).join(Order::getUser1).join(Order::getUserInoInfo).fetch().join(Order::getUser2)
                .join(Order::getUser3).join3(UserInfo::getUser).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R5R2() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getCreateUser).join(Order::getUser2)
                .join(Order::getUser3).join3(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R3R3() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getOrder).join(OrderInfo::getUser1).join4(Order::getParent).where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNull(orderInfo.getOrder().getParent());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join4(Order2::getParent).fetch().where()
        //                .eq(OrderInfo::getId, id2).single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId());
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getOrder).fetch().join(OrderInfo::getUser1).join4(Order::getParent).fetch().where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNotNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R3R5() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUserInoInfo)
                .join(Order::getUser3).join4(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        //        order = query.find(Order2.class)
        //                .join(Order2::getUserInoInfo)
        //                .join(Order2::getUser1)
        //                .join(Order2::getUser2)
        //                .join(Order2::getUser3)
        //                .join4(UserInfo::getUser)
        //                .fetch()
        //                .where()
        //                .eq(Order2::getId, id2)
        //                .single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUser1().getId());
        //        assertNull(order.getUser1().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());
        //        assertNotNull(order.getUserInoInfo().getId()); 
        //        assertNotNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId());
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());

        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUserInoInfo).fetch()
                .join(Order::getUser3).join4(UserInfo::getUser).fetch().where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R5R3() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getCreateUser)
                .join(Order::getUser3).join4(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R4R4() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getUser1).join(OrderInfo::getOrder).join5(Order::getParent).where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNull(orderInfo.getOrder().getParent());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join(OrderInfo::getUser1).join5(Order2::getParent).fetch().where()
        //                .eq(OrderInfo::getId, id2).single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId());
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getUser1).join(OrderInfo::getOrder).fetch().join5(Order::getParent).fetch().where()
                .eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNotNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R4R5() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getUserInoInfo).join5(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        //        order = query.find(Order2.class)
        //                .join(Order2::getUserInoInfo)
        //                .join(Order2::getUser1)
        //                .join(Order2::getUser2)
        //                .join(Order2::getUser3)
        //                .join5(UserInfo::getUser)
        //                .fetch()
        //                .where()
        //                .eq(Order2::getId, id2)
        //                .single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUser1().getId());
        //        assertNull(order.getUser1().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());
        //        assertNotNull(order.getUserInoInfo().getId()); 
        //        assertNotNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId());
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());

        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getUserInoInfo).fetch().join5(UserInfo::getUser).fetch().where().eq(Order::getId, id2)
                .single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_ER4_R5R4() {
        order = query.find(Order.class).join(Order::getUser1).join(Order::getUser2).join(Order::getUser3)
                .join(Order::getCreateUser).join5(UserInfo::getUser).where().eq(Order::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
    }
}
