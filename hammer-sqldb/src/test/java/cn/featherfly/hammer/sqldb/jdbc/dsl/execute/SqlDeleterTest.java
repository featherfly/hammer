
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

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.model.SimpleTable;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole;

/**
 * The Class SqlDeleterTest.
 *
 * @author zhongj
 */
public class SqlDeleterTest extends HammerJdbcTestBase {

    /** The deleter. */
    SqlDeleter deleter;

    /**
     * Setup.
     */
    @BeforeClass
    void setup() {
        deleter = new SqlDeleter(jdbc, mappingFactory);
    }

    /**
     * Test exception.
     */
    @Test(expectedExceptions = SqldbHammerException.class)
    public void testException() {
        new SqlDeleter(jdbc).delete(User.class);
    }

    @Test
    public void testDelete() {
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
    public void testDelete1() {
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
    public void testDelete2() {
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
    public void testDelete3() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(new SimpleAliasRepository("role", "r"))
                .where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)).eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void testDeleteNoCondition() {
        List<UserRole> urs = hammer.query(UserRole.class).list();

        int result = deleter.delete("user_role").where().setIgnoreStrategy(IgnoreStrategy.EMPTY).eq("user_id", null)
                .execute();
        assertEquals(result, urs.size());

        hammer.save(urs);
    }

    @Test
    public void testDeleteEntity() {
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
    public void testDeleteEntity2() {
        Role role = role();

        hammer.save(role);

        Role load = hammer.get(role);

        assertEquals(load.getId(), role.getId());
        assertEquals(load.getName(), role.getName());

        int result = deleter.delete(Role.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY))
                .eq(Role::getId, role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }

    @Test
    public void testDeleteEntityNoCondition() {
        List<UserRole> urs = hammer.query(UserRole.class).list();

        // YUFEI_TEST 没有参数，返回的0，后续设置没有参数的行为策略
        int result = deleter.delete(UserRole.class).where().setIgnoreStrategy(IgnoreStrategy.EMPTY)
                .eq(UserRole::getUserId, null) //
                .execute();
        assertEquals(result, urs.size());

        hammer.save(urs);
    }
}
