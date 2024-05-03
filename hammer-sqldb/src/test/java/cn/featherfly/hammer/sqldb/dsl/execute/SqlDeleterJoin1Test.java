
package cn.featherfly.hammer.sqldb.dsl.execute;

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
public class SqlDeleterJoin1Test extends AbstractDeleterTest {

    @Test
    public void entityDeleteJoin1() {
        User createUser = assertUserExist(createUserId);

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
            .where() //
            .eq2(createUser::getUsername) //
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
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
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
            .where() //
            .eq((e1, e2) -> e2.accept(createUser::getUsername)) //
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
            .where() //
            .eq((e1, e2) -> e2.accept(User::getUsername, createUser.getUsername())) //
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
            .where() //
            .eq((e1, e2) -> e2.property(User::getUsername).value(createUser.getUsername())) //
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
            .where() //
            .property((e1, e2) -> e2.property(User::getUsername).eq(createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }

    @Test
    public void entityDeleteJoin2_2() {
        User createUser = assertUserExist(createUserId);

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
            .where((e1, e2) -> e1.eq(order::getNo) //
                .and(e2.eq(createUser::getUsername)) //
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
            .where((e1, e2) -> e1.eq(Order2::getNo, order.getNo()) //
                .and(e2.eq(User::getUsername, createUser.getUsername())) //
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
            .where((e1, e2) -> e1.property(Order2::getNo).eq(order.getNo()) //
                .and(e2.property(User::getUsername).eq(createUser.getUsername())) //
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
            .where((e1, e2) -> e1.property(Order2::getNo).eq(order.getNo()) //
                .and(e2).property(User::getUsername).eq(createUser.getUsername()) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }

    // ****************************************************************************************************************
    //	repository
    // ****************************************************************************************************************

    @Test
    public void repositoryDeleteJoin1() {
        User createUser = assertUserExist(createUserId);

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
            .where() //
            .eq2(createUser::getUsername) //
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
            .where() //
            .eq2(USER_FIELD_USERNAME, createUser.getUsername()) //
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
            .where() //
            .eq2(createUser::getUsername) //
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
            .where() //
            .eq2(createUser::getUsername) //
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
            .where() //
            .eq2(createUser::getUsername) //
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
            .where() //
            .eq2(USER_FIELD_USERNAME, createUser.getUsername()) //
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
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
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
            .where() //
            .eq((e1, e2) -> e2.accept(createUser::getUsername)) //
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
            .where() //
            .eq((e1, e2) -> e2.accept(USER_FIELD_USERNAME, createUser.getUsername())) //
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
            .where() //
            .eq((e1, e2) -> e2.accept(User::getUsername, createUser.getUsername())) //
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
            .where() //
            .eq((e1, e2) -> e2.field(User::getUsername).value(createUser.getUsername())) //
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
            .where() //
            .eq((e1, e2) -> e2.field(USER_FIELD_USERNAME).value(createUser.getUsername())) //
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
                .eq(j.field(USER_FIELD_ID))) ///
            .where() //
            .field((e1, e2) -> e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);

        //        // ----------------------------------------------------------------------------------------------------------------
        //
        //        hammer.save(order);
        //        load = hammer.get(order);
        //        assertEquals(load.getId(), order.getId());
        //        assertEquals(load.getNo(), order.getNo());
        //        assertEquals(load.getAppId(), order.getAppId());
        //
        //        result = deleter.delete(ORDER_TABLE) //
        //            .join(USER_TABLE).on((e1, j) -> e1.field(ORDER_FIELD_CREATE_USER) //
        //                .eq(j.field(USER_FIELD_ID))) ///
        //            .where() //
        //            .field((e1, e2) -> e2.field(User::getUsername).eq(createUser.getUsername()))
        //              YUFEI_TODO 没有定义field(User::getUsername)
        //            .execute();
        //        assertEquals(result, 1);
        //
        //        load = hammer.get(order);
        //        assertNull(load);
    }

    @Test
    public void repositoryDeleteJoin2_2() {
        int result = -1;

        User createUser = assertUserExist(createUserId);

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
            .where((e1, e2) -> e1.field(ORDER_FIELD_NO).eq(order.getNo()) //
                .and(e2.field(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
            .where((e1, e2) -> e1.fieldAsString(ORDER_FIELD_NO).eq(order.getNo()) //
                .and(e2.fieldAsString(USER_FIELD_USERNAME).eq(createUser.getUsername())) //
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
