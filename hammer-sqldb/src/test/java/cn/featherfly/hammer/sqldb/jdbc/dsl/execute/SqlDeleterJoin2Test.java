
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
}
