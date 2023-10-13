
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
@Test(groups = "TypeJoin")
public class AbstractEntitySqlQueryJoinTest extends HammerJdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid1 = 1;
    Integer uid2 = 1;
    Long id1 = 1L;
    Long id2 = 2L;
    Long oid1 = 1L;
    Long oid2 = 2L;
    Long oid3 = 3L;
    Integer tid = 7;
    Integer tid1 = 1;
    Integer tid2 = 2;
    List<Tree> trees = new ArrayList<>();
    Tree tree;
    Order order;
    OrderInfo orderInfo;

    @BeforeClass
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid1 = 1;
        tree = null;
        order = null;
        orderInfo = null;
        trees = new ArrayList<>();
    }

    void assertTree(Tree tree, boolean fetched) {
        assertNotNull(tree.getParent());
        assertNotNull(tree.getParent().getId());
        if (fetched) {
            assertNotNull(tree.getParent().getName());
        } else {
            assertNull(tree.getParent().getName());
        }
    }
}
