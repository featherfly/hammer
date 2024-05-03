
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-22 18:05:22
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.order.OrderInfo;

/**
 * AbstractRepositorySqlQuery.
 *
 * @author zhongj
 */
public abstract class AbstractRepositorySqlQueryTest extends HammerJdbcTestBase {

    SqlQuery query;

    List<Map<String, Object>> list = null;

    Map<String, Object> map = null;

    static final String ORDER_REPO = "order";
    static final Repository ORDER_REPO2 = new SimpleRepository(ORDER_REPO);

    static final String USER_REPO = "user";
    static final Repository USER_REPO2 = new SimpleRepository(USER_REPO);

    UserInfo userInfo = null;
    User user = null;
    Integer uid1 = 1;
    Integer uid2 = 2;
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
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig.getDslConfig().getQueryConfig());
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

    void assertFields(Map<String, Object> data, String[]... fields) {
        for (String[] fs : fields) {
            for (String field : fs) {
                assertTrue(data.containsKey(field));
            }
        }
    }

    void assertFields(List<Map<String, Object>> list, String[]... fields) {
        for (String[] fs : fields) {
            for (String field : fs) {
                for (Map<String, Object> data : list) {
                    assertTrue(data.containsKey(field));
                    //                    if (field.contains(".")) {
                    //                        String[] tokens = field.split(".");
                    //                        assertTrue(data.containsKey(tokens[tokens.length - 1]));
                    //                    } else {
                    //                        assertTrue(data.containsKey(field));
                    //                    }
                }
            }
        }
    }
}
