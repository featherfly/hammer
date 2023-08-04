
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeJoinRelation2Test extends SqlQueryTypeJoinTest {

    @Test
    void testJoin_ER1_ER2_R3E() {
        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getCreateUser)
                .join(OrderInfo::getOrder).where().eq(Order2::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_ER3() {
        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getCreateUser)
                .join(Order2::getUpdateUser).where().eq(Order2::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getCreateUser)
                .join(Order2::getUpdateUser).where().eq(Order2::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getCreateUser).fetch()
                .join(Order2::getUpdateUser).where().eq(Order2::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getCreateUser).fetch()
                .join(Order2::getUpdateUser).fetch().where().eq(Order2::getId, id1).single();
        System.err.println(order);
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNotNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_EE() {
        order = query.find(Order2.class).join(Order2::getUpdateUser).join(Order2::getCreateUser).join(Order2::getParent)
                .where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
        assertNotNull(order.getParent().getId());
        assertNull(order.getParent().getNo());

        order = query.find(Order2.class).join(Order2::getUpdateUser).join(Order2::getCreateUser).join(Order2::getParent)
                .fetch().where().eq(Order2::getId, id2).single();
        assertEquals(order.getId(), id2);
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
        assertNotNull(order.getParent().getId());
        assertNotNull(order.getParent().getNo());
    }

    @Test
    void testJoin_ER1_ER2_R1R1() {
        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).join(OrderInfo::getCreateUser)
                .join1(Order2::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join1(Order2::getParent).where().eq(OrderInfo::getId, id2).single();
        assertEquals(orderInfo.getId(), id2);
        assertNotNull(orderInfo.getOrder().getId());
        assertNotNull(orderInfo.getOrder().getNo());
        assertNotNull(orderInfo.getOrder().getParent().getId());
        assertNull(orderInfo.getOrder().getParent().getNo());
        assertNotNull(orderInfo.getCreateUser().getId());
        assertNull(orderInfo.getCreateUser().getUsername());

        orderInfo = query.find(OrderInfo.class).join(OrderInfo::getOrder).fetch().join(OrderInfo::getCreateUser)
                .join1(Order2::getParent).fetch().where().eq(OrderInfo::getId, id2).single();
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
        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getCreateUser)
                .join1(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNull(order.getUserInoInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getCreateUser)
                .join1(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getUserInoInfo).fetch().join(Order2::getCreateUser)
                .join1(UserInfo::getUser).fetch().where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getCreateUser).fetch().join(Order2::getUpdateUser)
                .join1(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
        assertNotNull(order.getUpdateUser().getId());
        assertNull(order.getUpdateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_R3R2() {
        order = query.find(Order2.class).join(Order2::getUserInoInfo).join(Order2::getCreateUser)
                .join2(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNull(order.getUserInoInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
    }

    @Test
    void testJoin_ER1_ER2_R2R3() {
        order = query.find(Order2.class).join(Order2::getCreateUser).join(Order2::getUserInoInfo)
                .join2(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNull(order.getUserInoInfo().getName());
        assertNull(order.getUserInoInfo().getUser());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getCreateUser).join(Order2::getUserInoInfo).fetch()
                .join2(UserInfo::getUser).where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order2.class).join(Order2::getCreateUser).join(Order2::getUserInoInfo).fetch()
                .join2(UserInfo::getUser).fetch().where().eq(Order2::getId, id1).single();
        assertEquals(order.getId(), id1);
        assertNotNull(order.getUserInoInfo().getId());
        assertNotNull(order.getUserInoInfo().getName());
        assertNotNull(order.getUserInoInfo().getUser().getId());
        assertNotNull(order.getUserInoInfo().getUser().getUsername());
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());
    }
}
