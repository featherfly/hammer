
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin4ConditionTest extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_E_R1R2R3R4() {
        Order2 order = query.find(Order2.class) //
                .where() //
                .eq(Order2::getId, oid3) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        Order2 order2 = order;

        User2 createUser = query.find(User2.class).where() //
                .eq(User2::getId, order.getCreateUser()) //
                .single();
        User2 updateUser = query.find(User2.class).where() //
                .eq(User2::getId, order.getUpdateUser()) //
                .single();

        User2 orderUser1 = query.find(User2.class).where() //
                .eq(User2::getId, order.getUser1()) //
                .single();
        User2 orderUser2 = query.find(User2.class).where() //
                .eq(User2::getId, order.getUser2()) //
                .single();

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(Order2::getId, order2.getId())) //
                .and() //
                .eq(es -> es.get1().accept(User2::getUsername, createUser.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(Order2::getId, order2.getId())) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e1.accept(User2::getUsername, createUser.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(order2::getId)) //
                .and() //
                .eq(es -> es.get1().accept(createUser::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(order2::getId)) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e1.accept(createUser::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(Order2::getId, order2.getId())) //
                .and() //
                .eq(es -> es.get2().accept(User2::getUsername, updateUser.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(Order2::getId, order2.getId())) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e2.accept(User2::getUsername, updateUser.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(order2::getId)) //
                .and() //
                .eq(es -> es.get2().accept(updateUser::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(order2::getId)) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e2.accept(updateUser::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(Order2::getId, order2.getId())) //
                .and() //
                .eq(es -> es.get3().accept(User2::getUsername, orderUser1.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(Order2::getId, order2.getId())) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e3.accept(User2::getUsername, orderUser1.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(order2::getId)) //
                .and() //
                .eq(es -> es.get3().accept(orderUser1::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(order2::getId)) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e3.accept(orderUser1::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(Order2::getId, order2.getId())) //
                .and() //
                .eq(es -> es.get4().accept(User2::getUsername, orderUser2.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(Order2::getId, order2.getId())) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e4.accept(User2::getUsername, orderUser2.getUsername())) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq(es -> es.get0().accept(order2::getId)) //
                .and() //
                .eq(es -> es.get4().accept(orderUser2::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where() //
                .eq((e0, e1, e2, e3, e4) -> e0.accept(order2::getId)) //
                .and() //
                .eq((e0, e1, e2, e3, e4) -> e4.accept(orderUser2::getUsername)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

    }

    @Test
    void propertyExpressionJoin() {
        Order2 order = query.find(Order2.class) //
                .where() //
                .eq(Order2::getId, oid3) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        Order2 order2 = order;

        User2 createUser = query.find(User2.class).where() //
                .eq(User2::getId, order.getCreateUser()) //
                .single();
        User2 updateUser = query.find(User2.class).where() //
                .eq(User2::getId, order.getUpdateUser()) //
                .single();

        User2 orderUser1 = query.find(User2.class).where() //
                .eq(User2::getId, order.getUser1()) //
                .single();
        User2 orderUser2 = query.find(User2.class).where() //
                .eq(User2::getId, order.getUser2()) //
                .single();

        // ----------------------------------------------------------------------------------------------------------------

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e1.eq(User2::getUsername, createUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e1.eq(User2::getUsername, createUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e1.property(User2::getUsername).eq(createUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e1.property(User2::getUsername).eq(createUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(order2::getId) //
                        .and(e1.eq(createUser::getUsername))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getCreateUser(), createUser.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e2.eq(User2::getUsername, updateUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e2.eq(User2::getUsername, updateUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e2.property(User2::getUsername).eq(updateUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e2.property(User2::getUsername).eq(updateUser.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(order2::getId) //
                        .and(e2.eq(updateUser::getUsername))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUpdateUser(), updateUser.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e3.eq(User2::getUsername, orderUser1.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e3.eq(User2::getUsername, orderUser1.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e3.property(User2::getUsername).eq(orderUser1.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e3.property(User2::getUsername).eq(orderUser1.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(order2::getId) //
                        .and(e3.eq(orderUser1::getUsername))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser1(), orderUser1.getId());

        // ****************************************************************************************************************

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e4.eq(User2::getUsername, orderUser2.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e4.eq(User2::getUsername, orderUser2.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(Order2::getId, order2.getId()) //
                        .and(e4.property(User2::getUsername).eq(orderUser2.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.property(Order2::getId).eq(order2.getId()) //
                        .and(e4.property(User2::getUsername).eq(orderUser2.getUsername()))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());

        order = query.find(Order2.class) //
                .join(User2.class).on(Order2::getCreateUser)//
                .join(User2.class).on(Order2::getUpdateUser)//
                .join(User2.class).on(Order2::getUser1) //
                .join(User2.class).on(Order2::getUser2) //
                .where((e0, e1, e2, e3, e4) -> e0.eq(order2::getId) //
                        .and(e4.eq(orderUser2::getUsername))) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid3);
        assertEquals(order.getUser2(), orderUser2.getId());
    }
}
