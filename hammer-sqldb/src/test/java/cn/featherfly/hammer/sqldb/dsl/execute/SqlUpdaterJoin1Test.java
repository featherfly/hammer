
package cn.featherfly.hammer.sqldb.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;

/**
 * SqlUpdaterJoin1Test.
 *
 * @author zhongj
 */
public class SqlUpdaterJoin1Test extends AbstractUpdaterTest {

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
    public void entityUpdateJoin1() {
        User createUser = assertUserExist(createUserId);

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
            .set(order::getTradeNo) //
            .where() //
            .eq2(createUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
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
            .set(order::getTradeNo).where() //
            .eq((e1, e2) -> e2.accept(createUser::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq((e1, e2) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

    }

    @Test
    public void entityUpdateJoin1_2() {
        User createUser = assertUserExist(createUserId);

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
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .eq((e1, e2) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

        // ----------------------------------------------------------------------------------------------------------------

        tradeNo = "tradeNo_" + System.currentTimeMillis();

        result = updater.update(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .property((e1, e2) -> e2.property(User::getUsername).eq(createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);
    }

    @Test
    public void entityUpdateJoin1_3() {
        User createUser = assertUserExist(createUserId);

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
            .set(order::getTradeNo) //
            .where((e1, e2) -> e2.eq(createUser::getUsername) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2) -> e2.eq(User::getUsername, createUser.getUsername()) //
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
            .set(order::getTradeNo) //
            .where((e1, e2) -> e2.property(User::getUsername).eq(createUser.getUsername()) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2) -> e2.property(User::getUsername).eq(createUser.getUsername()) //
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
            .set(ORDER_FIELD_NO, no) //
            .where() //
            .eq2(createUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq(Order2::getId, order.getId()) //
            .and().eq2(User::getUsername, createUser.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((e1, e2) -> e1.accept(order::getId)) //
            .and().eq((e1, e2) -> e2.accept(createUser::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((e1, e2) -> e1.accept(Order2::getId, order.getId())) //
            .and().eq((e1, e2) -> e2.accept(User::getUsername, createUser.getUsername())) //
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
            .set(order::getNo) //
            .where() //
            .eq(order::getId) //
            .and().eq2(createUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq(Order2::getId, order.getId()) //
            .and().eq2(User::getUsername, createUser.getUsername()) //
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
            .set(order::getNo).where() //
            .eq((e1, e2) -> e1.accept(order::getId)) //
            .and().eq((e1, e2) -> e2.accept(createUser::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(Order2::getNo, no) //
            .where() //
            .eq((e1, e2) -> e1.accept(Order2::getId, order.getId())) //
            .and().eq((e1, e2) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

    }

    @Test
    public void repositoryUpdateJoin1_2() {
        User createUser = assertUserExist(createUserId);

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
            .field(Order2::getNo).set(no) //
            .where() //
            .eq((e1, e2) -> e1.field(Order2::getId).value(order.getId())) //
            .and().eq((e1, e2) -> e2.field(User::getUsername).value(createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getNo(), no);

        // ----------------------------------------------------------------------------------------------------------------

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .field(ORDER_FIELD_NO).set(no) //
            .where() //
            .eq((e1, e2) -> e1.field(Order2::getId).value(order.getId())) //
            .and().eq((e1, e2) -> e2.field(User::getUsername).value(createUser.getUsername())) //
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
    public void repositoryUpdateJoin1_3() {
        User createUser = assertUserExist(createUserId);

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

        int result = -1;

        no = "no_" + System.currentTimeMillis();

        result = updater.update(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .set(ORDER_FIELD_NO, no) //
            .where((e1, e2) -> e1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
            .set((Field) () -> ORDER_FIELD_NO, no) //
            .where((e1, e2) -> e1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
            .set(Order2::getNo, no) //
            .where((e1, e2) -> e1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
            .set(order::getNo) //
            .where((e1, e2) -> e1.field(ORDER_FIELD_ID).eq(order.getId()) //
                .and(e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
