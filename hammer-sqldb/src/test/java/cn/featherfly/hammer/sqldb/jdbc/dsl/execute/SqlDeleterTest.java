
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

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;

/**
 * The Class SqlDeleterTest.
 *
 * @author zhongj
 */
public class SqlDeleterTest extends JdbcTestBase {

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
                .where(c -> c.setIgnorePolicy(IgnorePolicy.EMPTY)).eq("id", role.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(role);
        assertNull(load);
    }
}
