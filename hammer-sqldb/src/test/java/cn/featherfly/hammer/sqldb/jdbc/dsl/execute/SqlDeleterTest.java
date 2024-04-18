
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlUpdaterTest.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.execute
 * @Description: SqlUpdaterTest
 * @author: zhongj
 * @date: 2023-02-10 16:28:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.Serializable;
import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.common.db.model.SimpleTable;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.config.dsl.EmptyConditionStrategy;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * The Class SqlDeleterTest.
 *
 * @author zhongj
 */
public class SqlDeleterTest extends AbstractDeleterTest {

    //    /**
    //     * Test exception.
    //     */
    //    @Test(expectedExceptions = SqldbHammerException.class)
    //    public void testException() {
    //        new SqlDeleter(jdbc, hammerConfig.getDslConfig().getDeleteConfig()).delete(User.class);
    //    }

    @Test
    public void repositoryDelete() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete("role").where().eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void repositoryDelete1() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        SimpleTable table = new SimpleTable();
        table.setName("role");

        int result = deleter.delete(table).where().eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void repositoryDelete2() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(new SimpleRepository("role")).where().eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void repositoryDelete3() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(new SimpleAliasRepository("role", "r")).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)).eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void repositoryDeleteNoCondition_default() {
        int result = deleter.delete("user_role")
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.NON_EXECUTION)) //
            .where().eq("user_id", (Serializable) null).execute();
        assertEquals(result, 0);

        result = deleter.delete("user_role").configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
            .where().eq("user_id", (Serializable) null).execute();
        assertEquals(result, 0);

        result = deleter.delete("user_role").where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.NON_EXECUTION))
            .eq("user_id", (Serializable) null).execute();
        assertEquals(result, 0);

        result = deleter.delete("user_role").where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY))
            .eq("user_id", (Serializable) null).execute();
        assertEquals(result, 0);

    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void repositoryDeleteNoCondition_exeception() {
        deleter.delete("user_role")
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXCEPTION))
            .where().eq("user_id", (Serializable) null).execute();
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void repositoryDeleteNoCondition_exeception2() {
        deleter.delete("user_role").where().configure(
            c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY).setEmptyConditionStrategy(EmptyConditionStrategy.EXCEPTION))
            .eq("user_id", (Serializable) null).execute();
    }

    @Test
    public void repositoryDeleteNoCondition_execute() {
        List<UserRole> urs = hammer.query(UserRole.class).list();

        int result = deleter.delete("user_role").where().configure(
            c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY).setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .eq("user_id", (Serializable) null).execute();
        assertEquals(result, urs.size());

        hammer.save(urs);

        result = deleter.delete("user_role")
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .where().eq("user_id", (Serializable) null).execute();
        assertEquals(result, urs.size());

        hammer.save(urs);
    }

    @Test
    public void entityDelete() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(Role.class).where().eq(Role::getId, role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void entityDelete2() {
        final Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(Role.class).where(r -> r.eq(Role::getId, role.getId())).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void entityDelete3() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(Role.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY))
            .eq(Role::getId, role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void entityDeleteNoCondition_exception() {
        deleter.delete(UserRole.class)
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXCEPTION))
            .where().eq(UserRole::getUserId, null) //
            .execute();
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void entityDeleteNoCondition_exception2() {
        deleter.delete(UserRole.class).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXCEPTION))
            .eq(UserRole::getUserId, null) //
            .execute();
    }

    @Test
    public void entityDeleteNoCondition_default() {
        //  没有参数，返回的0
        int result = deleter.delete(UserRole.class)
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.NON_EXECUTION))
            .where().eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, 0);

        result = deleter.delete(UserRole.class).configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)).where()
            .eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, 0);

        result = deleter.delete(UserRole.class).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.NON_EXECUTION))
            .eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, 0);

        result = deleter.delete(UserRole.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY))
            .eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, 0);
    }

    @Test
    public void entityDeleteNoCondition_execute() {
        List<UserRole> urs = hammer.query(UserRole.class).list();

        int result = deleter.delete(UserRole.class)
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .where().eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, urs.size());

        hammer.save(urs);

        result = deleter.delete(UserRole.class).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .eq(UserRole::getUserId, null) //
            .execute();
        assertEquals(result, urs.size());

        hammer.save(urs);
    }

    @Test
    public void entityDeleteJoin() {
        Integer uid = 10;
        User user = hammer.get(uid, User.class);

        assertEquals(user.getId(), uid);

        UserInfo2 ui = userInfo2();
        ui.setUserId(uid);
        hammer.save(ui);

        UserInfo2 load = hammer.get(ui);

        assertEquals(load.getId(), ui.getId());
        assertEquals(load.getName(), ui.getName());

        int result = deleter.delete(UserInfo2.class) //
            .join(User.class).on((e1, e2) -> //
            e1.property(UserInfo2::getUserId) //
                .eq(e2.property(User::getId))) //
            .where() //
            .eq2(user::getUsername) //
            .execute();
        assertEquals(result, 1);

        load = hammer.get(ui);
        assertNull(load);
    }
}
