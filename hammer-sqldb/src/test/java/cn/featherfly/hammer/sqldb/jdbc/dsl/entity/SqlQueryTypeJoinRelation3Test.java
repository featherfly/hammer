
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeJoinRelation3Test extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_ER1_ER2_ER3_EE() {
        order = query.find(Order2.class).join(Order2::getUser1).join(Order2::getUser2).join(Order2::getUser3)
                .join(Order2::getParent).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getParent().getId());
        assertNull(order.getParent().getNo());

        order = query.find(Order2.class).join(Order2::getUser1).join(Order2::getUser2).join(Order2::getUser3)
                .join(Order2::getParent).fetch().where().eq(Order2::getId, id2).single();
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
    void testJoin_ER1_ER2_ER3_ER4() {
        order = query.find(Order2.class).join(Order2::getUser1).join(Order2::getUser2).join(Order2::getUser3)
                .join(Order2::getUserInoInfo).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUser1().getId());
        assertNull(order.getUser1().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());

        order = query.find(Order2.class).join(Order2::getUser1).join(Order2::getUser2).join(Order2::getUser3)
                .join(Order2::getUserInoInfo).fetch().where().eq(Order2::getId, id2).single();
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
    void testJoin_ER1_ER2_ER3_R4E() {
        order = query.find(Order2.class).join(Order2::getUser1).join(Order2::getUser2).join(Order2::getUser3)
                .join(OrderInfo::getOrder).where().eq(Order2::getId, id2).single();
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
    void testJoin_ER1_ER2_ER3_R1R4() {
        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getUser2).join(Order2::getUser3)
                .join1(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());

        //        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getUser2).join(Order2::getUser3)
        //                .join1(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUserInoInfo().getId());
        //        assertNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId()); // FIXME 没有fetch UserInfo会缺少UserInfo.id
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getUser2)
                .join(Order2::getUser3).join1(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R4R1() {
        order = query.find(Order2.class).join(Order2::getCreateUser).join(Order2::getUser2).join(Order2::getUser3)
                .join1(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R1R1() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
                .join(OrderInfo::getUpdateUser).join1(Order2::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNull(orderInfo.getOrder().getParent());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join1(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
        //                .single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId()); // FIXME 没有fetch Order会缺少Order.id
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join(OrderInfo::getUpdateUser).join1(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
                .single();
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
    void testJoin_ER1_ER2_ER3_R2R4() {
        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUserInoInfo).join(Order2::getUser3)
                .join2(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());

        //        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUserInoInfo)
        //                .join(Order2::getUser3).join2(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUserInoInfo().getId());
        //        assertNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId()); // FIXME 没有fetch UserInfo会缺少UserInfo.id
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());

        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUserInoInfo).fetch()
                .join(Order2::getUser3).join2(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R4R2() {
        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getCreateUser).join(Order2::getUser3)
                .join2(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R2R2() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getOrder)
                .join(OrderInfo::getUpdateUser).join2(Order2::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //      orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join2(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
        //                .single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId()); // FIXME 没有fetch Order会缺少Order.id
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getOrder).fetch()
                .join(OrderInfo::getUpdateUser).join2(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
                .single();
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
    void testJoin_ER1_ER2_ER3_R3R4() {
        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUser3).join(Order2::getUserInoInfo)
                .join3(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());

        //        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUser3).join(Order2::getUserInoInfo)
        //                .join3(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        //        assertEquals(order.getId(), id2);
        //        assertNotNull(order.getUserInoInfo().getId());
        //        assertNull(order.getUserInoInfo().getName());
        //        assertNotNull(order.getUserInoInfo().getUser().getId()); // FIXME 没有fetch UserInfo会缺少UserInfo.id
        //        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        //        assertNotNull(order.getUser2().getId());
        //        assertNull(order.getUser2().getUsername());
        //        assertNotNull(order.getUser3().getId());
        //        assertNull(order.getUser3().getUsername());

        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUser3).join(Order2::getUserInoInfo)
                .fetch().join3(UserInfo::getUser).fetch().where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R4R3() {
        order = query.find(Order2.class).join(Order2::getUser2).join(Order2::getUser3).join(Order2::getCreateUser)
                .join3(UserInfo::getUser).where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUser2().getId());
        assertNull(order.getUser2().getUsername());
        assertNotNull(order.getUser3().getId());
        assertNull(order.getUser3().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3_R3R3() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getOrder).join3(Order2::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());
        assertNotNull(orderInfo.getUpdateUser().getId());
        assertNull(orderInfo.getUpdateUser().getUsername());

        //      orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
        //                .join(OrderInfo::getUpdateUser).join3(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
        //                .single();
        //        assertEquals(orderInfo.getId(), id2);
        //        assertNotNull(orderInfo.getOrder().getId());
        //        assertNull(orderInfo.getOrder().getNo());
        //        assertNotNull(orderInfo.getOrder().getParent().getId()); // FIXME 没有fetch Order会缺少Order.id
        //        assertNotNull(orderInfo.getOrder().getParent().getNo());
        //        assertNotNull(orderInfo.getCreateUser().getId());
        //        assertNull(orderInfo.getCreateUser().getUsername());
        //        assertNotNull(orderInfo.getUpdateUser().getId());
        //        assertNull(orderInfo.getUpdateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getCreateUser).join(OrderInfo::getUpdateUser)
                .join(OrderInfo::getOrder).fetch().join3(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2)
                .single();
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
}
