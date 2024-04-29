
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;

/**
 * The Class SqlDeleterJoin4Test.
 *
 * @author zhongj
 */
public class SqlDeleterJoin2Test extends AbstractDeleterTest {

    @Test
    public void entityDeleteJoin2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        int result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3) -> e2.accept(createUser::getUsername)) //
            .and().eq((e1, e2, e3) -> e3.accept(updateUser::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((e1, e2, e3) -> e3.accept(User::getUsername, updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where() //
            .property((e1, e2, e3) -> e2.property(User::getUsername).eq(createUser.getUsername())) //
            .and().property((e1, e2, e3) -> e3.property(User::getUsername).eq(updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }

    @Test
    public void entityDeleteJoin2_2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        int result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3) -> e1.eq(order::getNo) //
                .and(e2.eq(createUser::getUsername)) //
                .and(e3.eq(updateUser::getUsername)) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3) -> e1.eq(Order2::getNo, order.getNo()) //
                .and(e2.eq(User::getUsername, createUser.getUsername())) //
                .and(e3.eq(User::getUsername, updateUser.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3) -> e1.property(Order2::getNo).eq(order.getNo()) //
                .and(e2.property(User::getUsername).eq(createUser.getUsername())) //
                .and(e3.property(User::getUsername).eq(updateUser.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(Order2.class) //
            .join(User.class).on((e1, j) -> e1.property(Order2::getCreateUser) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, j) -> e1.property(Order2::getUpdateUser) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3) -> e1.property(Order2::getNo).eq(order.getNo()) //
                .and(e2).property(User::getUsername).eq(createUser.getUsername()) //
                .and(e3).property(User::getUsername).eq(updateUser.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }

    // ****************************************************************************************************************
    //  repository
    // ****************************************************************************************************************

    @Test
    public void repositoryDeleteJoin2() {
        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        int result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on(USER_FIELD_ID, ORDER_FIELD_CREATE_USER) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on(USER_FIELD_ID, ORDER_FIELD_CREATE_USER) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on(on -> on.joinField(USER_FIELD_ID).sourceField(ORDER_FIELD_CREATE_USER)) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on(on -> on.sourceField(ORDER_FIELD_CREATE_USER)) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER).eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(USER_FIELD_USERNAME, createUser.getUsername()) //
            .and().eq3(USER_FIELD_USERNAME, updateUser.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq((r1, r2, r3) -> r2.accept(createUser::getUsername)) //
            .and().eq((r1, r2, r3) -> r3.accept(updateUser::getUsername)) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq((r1, r2, r3) -> r2.accept(USER_FIELD_USERNAME, createUser.getUsername())) //
            .and().eq((r1, r2, r3) -> r3.accept(USER_FIELD_USERNAME, updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq((r1, r2, r3) -> r2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((r1, r2, r3) -> r3.accept(User::getUsername, updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq((r1, r2, r3) -> r2.field(User::getUsername).value(createUser.getUsername())) //
            .and().eq((r1, r2, r3) -> r3.field(User::getUsername).value(updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .eq((r1, r2, r3) -> r2.field(USER_FIELD_USERNAME).value(createUser.getUsername())) //
            .and().eq((r1, r2, r3) -> r3.field(USER_FIELD_USERNAME).value(updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);
        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where() //
            .field((r1, r2, r3) -> r2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
            .and().field((r1, r2, r3) -> r3.field(USER_FIELD_USERNAME).eq(updateUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        //                // ----------------------------------------------------------------------------------------------------------------
        //
        //                hammer.save(order);
        //                load = hammer.get(order);
        //                assertEquals(load.getId(), order.getId());
        //                assertEquals(load.getNo(), order.getNo());
        //                assertEquals(load.getAppId(), order.getAppId());
        //
        //                result = deleter.delete(ORDER_TABLE) //
        //                    .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                        .eq(j.field(USER_FIELD_ID))) //
        //                    .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
        //                        .eq(j.field(USER_FIELD_ID))) //
        //                    .join(USER_TABLE).on((e1, e2, e3, j) -> e1.field(ORDER_FIELD_USER1) //
        //                        .eq(j.field(USER_FIELD_ID))) //
        //                    .join(USER_TABLE).on((e1, e2, e3, e4, j) -> e1.field(ORDER_FIELD_USER2) //
        //                        .eq(j.field(USER_FIELD_ID))) //
        //                    .where() //
        //                    .field((r1, r2, r3) -> r2.field(User::getUsername).eq(createUser.getUsername()))
        //                    .and().field((r1, r2, r3) -> r3.field(User::getUsername).eq(updateUser.getUsername())) //
        //                    .and().field((r1, r2, r3) -> r4.field(User::getUsername).eq(user1.getUsername())) //
        //                    .and().field((r1, r2, r3) -> r5.field(User::getUsername).eq(user2.getUsername())) //
        ////                      YUFEI_TODO 没有定义field(User::getUsername)
        //                    .execute();
        //                assertEquals(result, 1);
        //
        //                load = hammer.get(order);
        //                assertNull(load);
    }

    @Test
    public void repositoryDeleteJoin2_2() {
        int result = -1;

        User createUser = assertUserExist(createUserId);
        User updateUser = assertUserExist(updateUserId);

        Order2 order = order2();
        order.setCreateUser(createUserId);
        order.setUpdateUser(updateUserId);
        order.setUser1(userId1);
        order.setUser2(userId2);
        order.setUser3(userId3);

        hammer.save(order);

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        // ----------------------------------------------------------------------------------------------------------------

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where((r1, r2, r3) -> r1.field(ORDER_FIELD_NO).eq(order.getNo()) //
                .and(r2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
                .and(r3.field(USER_FIELD_USERNAME).eq(updateUser.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        // ----------------------------------------------------------------------------------------------------------------

        hammer.save(order);

        load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        result = deleter.delete(ORDER_TABLE) //
            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .join(USER_TABLE).on((e1, e2, j) -> e1.field(ORDER_FIELD_UPDATE_USER) //
                .eq(j.field(USER_FIELD_ID))) //
            .where((r1, r2, r3) -> r1.field(ORDER_FIELD_NO).eq(order.getNo()) //
                .and(r2).field(USER_FIELD_USERNAME).eq(createUser.getUsername()) //
                .and(r3).field(USER_FIELD_USERNAME).eq(updateUser.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        hammer.save(order);
        //
        //        load = hammer.get(order);
        //        assertEquals(load.getId(), order.getId());
        //        assertEquals(load.getNo(), order.getNo());
        //        assertEquals(load.getAppId(), order.getAppId());
        //
        //        result = deleter.delete(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) //
        //            .where((e1, e2) -> e1.eq(ORDER_FIELD_NO, order.getNo()) // YUFEI_TODO 后续来加入eq(repo, value)
        //                .and(e2.eq(USER_FIELD_USERNAME, createUser.getUsername())) //
        //            ) //
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertNull(load);
    }
}
