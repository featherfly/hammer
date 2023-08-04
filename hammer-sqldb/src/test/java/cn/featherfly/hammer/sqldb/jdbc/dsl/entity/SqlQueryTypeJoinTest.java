
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
@Test(groups = "TypeJoin")
public class SqlQueryTypeJoinTest extends JdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid = 1;
    Long id1 = 1L;
    Long id2 = 2L;
    Integer tid = 7;
    List<Tree2> trees = new ArrayList<>();
    Tree2 tree;
    Order2 order;
    OrderInfo orderInfo;

    @BeforeClass
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        tree = null;
        order = null;
        orderInfo = null;
        trees = new ArrayList<>();
    }

    void assertTree(Tree2 tree, boolean fetched) {
        assertNotNull(tree.getParent());
        assertNotNull(tree.getParent().getId());
        if (fetched) {
            assertNotNull(tree.getParent().getName());
        } else {
            assertNull(tree.getParent().getName());
        }
    }

    @Test
    void testJoin_where_condition() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).where(t -> t.setIgnoreStrategy(IgnoreStrategy.NONE))
                .eq(UserInfo::getId, null).single();
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
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).limit(0, 1).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).limit(new SimplePage(1, 1)).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());

    }

    //    @Test(groups = "TypeJoin")
    //    void testTypeJoin() {
    //
    //    }
}
