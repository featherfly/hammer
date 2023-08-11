
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
@Test(groups = "TypeJoin")
public class SqlQueryTypeJoinTest extends AbstractEntitySqlQueryJoinTest {

    @Test
    void testJoin_where_condition() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser)
                .where(t -> t.setIgnoreStrategy(IgnoreStrategy.NONE)).eq(UserInfo::getId, null).single();
        assertNull(userInfo);
    }

    @Test
    void testJoin_count() {
        Long count = query.find(UserInfo.class).join(UserInfo::getUser).count();
        assertTrue(count > 0);
    }

    @Test
    void testJoin_limit() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).limit(1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).limit(0, 1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).limit(new SimplePage(1, 1)).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid1);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

    }

    //    @Test(groups = "TypeJoin")
    //    void testTypeJoin() {
    //
    //    }
}
