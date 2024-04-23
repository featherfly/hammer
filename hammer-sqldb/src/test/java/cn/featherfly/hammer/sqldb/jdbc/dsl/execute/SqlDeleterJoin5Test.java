
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;

/**
 * The Class SqlDeleterJoin5Test.
 *
 * @author zhongj
 */
public class SqlDeleterJoin5Test extends AbstractDeleterTest {

    @Test
    public void entityDeleteJoin5() {
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

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        int result = deleter.delete(Order2.class) //
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
            .where() //
            .eq2(createUser::getUsername) //
            .and().eq3(updateUser::getUsername) //
            .and().eq4(user1::getUsername) //
            .and().eq5(user2::getUsername) //
            .and().eq6(user3::getUsername) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq2(User::getUsername, createUser.getUsername()) //
            .and().eq3(User::getUsername, updateUser.getUsername()) //
            .and().eq4(User::getUsername, user1.getUsername()) //
            .and().eq5(User::getUsername, user2.getUsername()) //
            .and().eq6(User::getUsername, user3.getUsername()) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.accept(createUser::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.accept(updateUser::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.accept(user1::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.accept(user2::getUsername)) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.accept(user3::getUsername)) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.accept(User::getUsername, createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.accept(User::getUsername, updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.accept(User::getUsername, user1.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.accept(User::getUsername, user2.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.accept(User::getUsername, user3.getUsername())) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where() //
            .eq((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).value(createUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e3.property(User::getUsername).value(updateUser.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e4.property(User::getUsername).value(user1.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e5.property(User::getUsername).value(user2.getUsername())) //
            .and().eq((e1, e2, e3, e4, e5, e6) -> e6.property(User::getUsername).value(user3.getUsername())) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where() //
            .property((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).eq(createUser.getUsername())) //
            .and().property((e1, e2, e3, e4, e5, e6) -> e3.property(User::getUsername).eq(updateUser.getUsername())) //
            .and().property((e1, e2, e3, e4, e5, e6) -> e4.property(User::getUsername).eq(user1.getUsername())) //
            .and().property((e1, e2, e3, e4, e5, e6) -> e5.property(User::getUsername).eq(user2.getUsername())) //
            .and().property((e1, e2, e3, e4, e5, e6) -> e6.property(User::getUsername).eq(user3.getUsername())) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }

    @Test
    public void entityDeleteJoin5_2() {
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

        Order2 load = hammer.get(order);
        assertEquals(load.getId(), order.getId());
        assertEquals(load.getNo(), order.getNo());
        assertEquals(load.getAppId(), order.getAppId());

        int result = deleter.delete(Order2.class) //
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
            .where((e1, e2, e3, e4, e5, e6) -> e2.eq(createUser::getUsername) //
                .and(e3.eq(updateUser::getUsername)) //
                .and(e4.eq(user1::getUsername)) //
                .and(e5.eq(user2::getUsername)) //
                .and(e6.eq(user3::getUsername)) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.eq(User::getUsername, createUser.getUsername()) //
                .and(e3.eq(User::getUsername, updateUser.getUsername())) //
                .and(e4.eq(User::getUsername, user1.getUsername())) //
                .and(e5.eq(User::getUsername, user2.getUsername())) //
                .and(e6.eq(User::getUsername, user3.getUsername())) //
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
            .join(User.class).on((e1, e2, e3, j) -> e1.property(Order2::getUser1) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, j) -> e1.property(Order2::getUser2) //
                .eq(j.property(User::getId))) //
            .join(User.class).on((e1, e2, e3, e4, e5, j) -> e1.property(Order2::getUser3) //
                .eq(j.property(User::getId))) //
            .where((e1, e2, e3, e4, e5, e6) -> e2.property(User::getUsername).eq(createUser.getUsername()) //
                .and(e3.property(User::getUsername).eq(updateUser.getUsername())) //
                .and(e4.property(User::getUsername).eq(user1.getUsername())) //
                .and(e5.property(User::getUsername).eq(user2.getUsername())) //
                .and(e6.property(User::getUsername).eq(user3.getUsername())) //
            ) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(order);
        assertNull(load);
    }
}