package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;

/**
 * SqlUpdaterJoin5Test.
 *
 * @author zhongj
 */
public class SqlUpdaterJoin5Test extends AbstractUpdaterTest {

    Order2 load;

    @AfterMethod
    private void afterMethod() {
        if (load != null) {
            hammer.delete(load);
            load = hammer.get(load);
            assertNull(load);
        }
    }

    @Test
    public void entityUpdateJoin5() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        String tradeNo = "tradeNo_" + System.currentTimeMillis();
        order.setTradeNo(tradeNo);

        int result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(order::getTradeNo) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .and().eq4(user1::getUsername) //
            .and().eq5(user2::getUsername) //
            .and().eq6(user3::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .and().eq4(User::getUsername, user1.getUsername()) //
            .and().eq5(User::getUsername, user2.getUsername()) //
            .and().eq6(User::getUsername, user3.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();
        order.setTradeNo(tradeNo);

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(order::getTradeNo).where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.accept(createUser::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.accept(updateUser::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.accept(user1::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.accept(user2::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.accept(user3::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.accept(User::getUsername, updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.accept(User::getUsername, user1.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.accept(User::getUsername, user2.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.accept(User::getUsername, user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

    }

    @Test
    public void entityUpdateJoin5_2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        String tradeNo = "tradeNo_" + System.currentTimeMillis();
        order.setTradeNo(tradeNo);

        int result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.property(User::getUsername).value(user1.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.property(User::getUsername).value(user2.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.property(User::getUsername).value(user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.property(User::getUsername).value(user1.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.property(User::getUsername).value(user2.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.property(User::getUsername).value(user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);
    }

    @Test
    public void entityUpdateJoin5_3() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        String tradeNo = "tradeNo_" + System.currentTimeMillis();
        order.setTradeNo(tradeNo);

        int result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(order::getTradeNo) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.eq(createUser::getUsername) //
                .and(e3.eq(updateUser::getUsername)) //
                .and(e4.eq(user1::getUsername)) //
                .and(e5.eq(user2::getUsername)) //
                .and(e6.eq(user3::getUsername)) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), order.getTradeNo());

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.eq(User::getUsername, createUser.getUsername()) //
                .and(e3.eq(User::getUsername, updateUser.getUsername())) //
                .and(e4.eq(User::getUsername, user1.getUsername())) //
                .and(e5.eq(User::getUsername, user2.getUsername())) //
                .and(e6.eq(User::getUsername, user3.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();
        order.setTradeNo(tradeNo);

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(order::getTradeNo) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.eq(createUser::getUsername) //
                .and(e3.eq(updateUser::getUsername)) //
                .and(e4.eq(user1::getUsername)) //
                .and(e5.eq(user2::getUsername)) //
                .and(e6.eq(user3::getUsername)) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).eq(createUser.getUsername()) //
                .and(e3.property(User::getUsername).eq(updateUser.getUsername())) //
                .and(e4.property(User::getUsername).eq(user1.getUsername())) //
                .and(e5.property(User::getUsername).eq(user2.getUsername())) //
                .and(e6.property(User::getUsername).eq(user3.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Test
    public void repositoryUpdateJoin1() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        int result = -1;

        String no = "no_" + System.currentTimeMillis();
        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(ORDER_FIELD_NO, no) //
            .where() //
            .eq(order::getId) //
            .and().eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .and().eq4(user1::getUsername) //
            .and().eq5(user2::getUsername) //
            .and().eq6(user3::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq(Order2::getId, order.getId()) //
            .and().eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .and().eq4(User::getUsername, user1.getUsername()) //
            .and().eq5(User::getUsername, user2.getUsername()) //
            .and().eq6(User::getUsername, user3.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((r1, r2, r3, r4, r5, r6) -> r1.accept(order::getId)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r2.accept(createUser::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.accept(updateUser::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.accept(user1::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.accept(user2::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.accept(user3::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((r1, r2, r3, r4, r5, r6) -> r1.accept(Order2::getId, order.getId())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.accept(User::getUsername, updateUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.accept(User::getUsername, user1.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.accept(User::getUsername, user2.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.accept(User::getUsername, user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();
        order.setNo(no);

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(order::getNo) //
            .where() //
            .eq(order::getId) //
            .and().eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .and().eq4(user1::getUsername) //
            .and().eq5(user2::getUsername) //
            .and().eq6(user3::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq(Order2::getId, order.getId()) //
            .and().eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .and().eq4(User::getUsername, user1.getUsername()) //
            .and().eq5(User::getUsername, user2.getUsername()) //
            .and().eq6(User::getUsername, user3.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();
        order.setNo(no);

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(order::getNo).where() //
            .eq((r1, r2, r3, r4, r5, r6) -> r1.accept(order::getId)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r2.accept(createUser::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.accept(updateUser::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.accept(user1::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.accept(user2::getUsername)) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.accept(user3::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((r1, r2, r3, r4, r5, r6) -> r1.accept(Order2::getId, order.getId())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.accept(User::getUsername, updateUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.accept(User::getUsername, user1.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.accept(User::getUsername, user2.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.accept(User::getUsername, user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

    }

    @Test
    public void repositoryUpdateJoin1_2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        String no = "no_" + System.currentTimeMillis();
        order.setNo(no);

        int result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .field(Order2::getNo).set(no) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e1.field(Order2::getId).value(order.getId())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e2.field(User::getUsername).value(createUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.field(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.field(User::getUsername).value(user1.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.field(User::getUsername).value(user2.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.field(User::getUsername).value(user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .field(ORDER_FIELD_NO).set(no) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e1.field(Order2::getId).value(order.getId())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e2.field(User::getUsername).value(createUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r3.field(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r4.field(User::getUsername).value(user1.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r5.field(User::getUsername).value(user2.getUsername())) //
            .and().eq((r1, r2, r3, r4, r5, r6) -> r6.field(User::getUsername).value(user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        no = "no_" + System.currentTimeMillis();
        //
        //        result = updater.update(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) //
        //            .field(Order2::getTradeNo).set(no) //
        //            .where() //
        //            .field((e1, e2) -> e2.field(User::getUsername).eq(createUser.getUsername()))  // YUFEI_TODO 当前没有此定义此方法
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getTradeNo(), no);
    }

    @Test
    public void repositoryUpdateJoin5_3() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);
        User user2 = assertUserExist(userId2);
        User user3 = assertUserExist(userId3);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());
        assertNull(load.getTradeNo());

        int result = -1;

        String no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(ORDER_FIELD_NO, no) //
            .where((r1, r2, r3, r4, r5, r6) -> r1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(r2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
                .and(r3.field(USER_FIELD_USERNAME).eq(updateUser.getUsername())) //
                .and(r4.field(USER_FIELD_USERNAME).eq(user1.getUsername())) //
                .and(r5.field(USER_FIELD_USERNAME).eq(user2.getUsername())) //
                .and(r6.field(USER_FIELD_USERNAME).eq(user3.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------
        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set((Field) () -> ORDER_FIELD_NO, no) //
            .where((r1, r2, r3, r4, r5, r6) -> r1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(r2).field(USER_FIELD_USERNAME).eq(createUser.getUsername()) //
                .and(r3).field(USER_FIELD_USERNAME).eq(updateUser.getUsername()) //
                .and(r4).field(USER_FIELD_USERNAME).eq(user1.getUsername()) //
                .and(r5).field(USER_FIELD_USERNAME).eq(user2.getUsername()) //
                .and(r6).field(USER_FIELD_USERNAME).eq(user3.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where((r1, r2, r3, r4, r5, r6) -> r1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(r2).field(USER_FIELD_USERNAME).eq(createUser.getUsername()) //
                .and(r3).field(USER_FIELD_USERNAME).eq(updateUser.getUsername()) //
                .and(r4).field(USER_FIELD_USERNAME).eq(user1.getUsername()) //
                .and(r5).field(USER_FIELD_USERNAME).eq(user2.getUsername()) //
                .and(r6).field(USER_FIELD_USERNAME).eq(user3.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();
        order.setNo(no);

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, e3, e4, e5, j) -> e1.field(ORDER_FIELD_USER3) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(order::getNo) //
            .where((r1, r2, r3, r4, r5, r6) -> r1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(r2).field(USER_FIELD_USERNAME).eq(createUser.getUsername()) //
                .and(r3).field(USER_FIELD_USERNAME).eq(updateUser.getUsername()) //
                .and(r4).field(USER_FIELD_USERNAME).eq(user1.getUsername()) //
                .and(r5).field(USER_FIELD_USERNAME).eq(user2.getUsername()) //
                .and(r6).field(USER_FIELD_USERNAME).eq(user3.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), order.getNo());

        // ----------------------------------------------------------------------------------------------------------------

        //      result = updater.update(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) //
        //            .set(order::getTradeNo) //
        //            .where((e1, e2) -> e2.eq(createUser::getUsername) // YUFEI_TODO 当前没有此定义此方法
        //            ) //
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getTradeNo(), order.getTradeNo());

        // ----------------------------------------------------------------------------------------------------------------

        //        tradeNo = "no_" + System.currentTimeMillis();
        //
        //        result = updater.update(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) //
        //            .set(Order2::getTradeNo, tradeNo) //
        //            .where((e1, e2) -> e2.eq(User::getUsername, createUser.getUsername()) // YUFEI_TODO 当前没有此定义此方法
        //            ) //
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getTradeNo(), tradeNo);

        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        tradeNo = "no_" + System.currentTimeMillis();
        //        order.setTradeNo(tradeNo);
        //
        //        result = updater.update(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) //
        //            .set(order::getTradeNo) //
        //            .where((e1, e2) -> e2.field(User::getUsername).eq(createUser.getUsername()) // YUFEI_TODO 当前没有此定义此方法
        //            ) //
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getTradeNo(), tradeNo);
        //
        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        tradeNo = "no_" + System.currentTimeMillis();
        //
        //        result = updater.update(Order2.class) //
        //            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
        //                .eq(j.property(User::getId))) //
        //            .set(Order2::getTradeNo, tradeNo) //
        //            .where((e1, e2) -> e2.property(User::getUsername).eq(createUser.getUsername()) // YUFEI_TODO 当前没有此定义此方法
        //            ) //
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getTradeNo(), tradeNo);

    }
}
