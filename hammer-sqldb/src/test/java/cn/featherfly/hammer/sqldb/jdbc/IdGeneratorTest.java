
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UuidTable;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class IdGeneratorTest extends JdbcTestBase {

    protected Hammer hammer;

    @Nullable
    List<Serializable> emptyList = new ArrayList<>();
    Serializable[] emptyArray = new Serializable[0];

    @BeforeClass
    void before() {
        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig);
    }

    @Test
    public void auto() {
        Role r = role();
        hammer.save(r);
        assertNotNull(r.getId());

        hammer.delete(r);

        Role role = hammer.get(r);
        assertNull(role);

        r = role();
        r.setName("name_" + Randoms.getInt(100));
        hammer.save(r);
        assertNotNull(r.getId());

        role = hammer.get(r);
        assertEquals(role.getId(), r.getId());
        assertEquals(role.getName(), r.getName());

        hammer.delete(r);

        role = hammer.get(r);
        assertNull(role);
    }

    @Test
    public void uuid() {
        UuidTable u = new UuidTable();

        u.setDescp("descp");

        hammer.save(u);
        assertNotNull(u.getId());

        hammer.delete(u);

        List<UuidTable> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            u = new UuidTable();
            u.setDescp("descp_" + i);
            list.add(u);
        }
        hammer.save(list);

        for (UuidTable uu : list) {
            assertNotNull(uu.getId());
        }

        hammer.delete(list);

    }
}
