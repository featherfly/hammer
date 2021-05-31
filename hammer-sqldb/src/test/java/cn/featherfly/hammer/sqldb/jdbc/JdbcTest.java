
package cn.featherfly.hammer.sqldb.jdbc;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JdbcTest extends JdbcTestBase {

    @BeforeClass
    void before() {
    }

    @Test
    public void testQuery() {
        List<Long> idList = jdbc.query("select id from role order by id", Long.class);
        System.out.println(idList);
        assertTrue(idList.size() > 0);
        Long pid = Long.MIN_VALUE;
        for (Long id : idList) {
            assertTrue(pid < id);
            pid = id;
        }
    }
}
