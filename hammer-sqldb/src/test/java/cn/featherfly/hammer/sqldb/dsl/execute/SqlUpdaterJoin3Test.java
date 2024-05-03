
package cn.featherfly.hammer.sqldb.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;

/**
 * SqlUpdaterJoin4Test.
 *
 * @author zhongj
 */
public class SqlUpdaterJoin3Test extends AbstractUpdaterTest {

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
    public void entityUpdateJoin3() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);

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
            .set(order::getTradeNo) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .and().eq4(user1::getUsername) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .and().eq4(User::getUsername, user1.getUsername()) //
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
            .set(order::getTradeNo).where() //
            .eq((e1, e2, e3, e4) -> e2.accept(createUser::getUsername)) //
            .and().eq((e1, e2, e3, e4) -> e3.accept(updateUser::getUsername)) //
            .and().eq((e1, e2, e3, e4) -> e4.accept(user1::getUsername)) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e3.accept(User::getUsername, updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e4.accept(User::getUsername, user1.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);

    }

    @Test
    public void entityUpdateJoin3_2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);

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
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e4.property(User::getUsername).value(user1.getUsername())) //
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
            .property(Order2::getTradeNo).set(tradeNo) //
            .where() //
            .eq((e1, e2, e3, e4) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4) -> e4.property(User::getUsername).value(user1.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);
    }

    @Test
    public void entityUpdateJoin3_3() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);
        User user1 = assertUserExist(userId1);

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
            .set(order::getTradeNo) //
            .where((e1, e2, e3, e4) -> e2.eq(createUser::getUsername) //
                .and(e3.eq(updateUser::getUsername)) //
                .and(e4.eq(user1::getUsername)) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2, e3, e4) -> e2.eq(User::getUsername, createUser.getUsername()) //
                .and(e3.eq(User::getUsername, updateUser.getUsername())) //
                .and(e4.eq(User::getUsername, user1.getUsername())) //
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
            .set(order::getTradeNo) //
            .where((e1, e2, e3, e4) -> e2.eq(createUser::getUsername) //
                .and(e3.eq(updateUser::getUsername)) //
                .and(e4.eq(user1::getUsername)) //
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
            .set(Order2::getTradeNo, tradeNo) //
            .where((e1, e2, e3, e4) -> e2.property(User::getUsername).eq(createUser.getUsername()) //
                .and(e3.property(User::getUsername).eq(updateUser.getUsername())) //
                .and(e4.property(User::getUsername).eq(user1.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertEquals(load.getTradeNo(), tradeNo);
    }
}
