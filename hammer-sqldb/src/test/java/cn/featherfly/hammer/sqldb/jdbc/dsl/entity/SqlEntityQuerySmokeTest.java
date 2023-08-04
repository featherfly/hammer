
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * 冒烟测试.
 *
 * @author zhongj
 */
public class SqlEntityQuerySmokeTest extends JdbcTestBase {

    /** The query. */
    SqlQuery query;

    /** The user info. */
    UserInfo userInfo = null;

    /** The user. */
    User user = null;

    /** The uid. */
    Integer uid = 1;

    /** The trees. */
    List<Tree2> trees = new ArrayList<>();

    /**
     * Setup test.
     */
    @BeforeTest
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    /**
     * Setup method.
     */
    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        trees = new ArrayList<>();
    }

    /**
     * Test sort.
     */
    @Test
    void testSort() {
        List<User> users = query.find(User.class).join(UserInfo::getUser).sort().asc2(UserInfo::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User.class).join(UserInfo::getUser).sort().asc2(UserInfo::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    /**
     * Test join.
     */
    @Test
    void testJoin() {
        List<User2> users = query.find(User2.class).join(UserInfo2::getUserId).list();
        System.out.println(users);
    }

    /**
     * Test join fetch list.
     */
    @Test
    void testJoinFetchList() {
        List<Tuple2<User2, UserInfo2>> users = query.find(User2.class).join(UserInfo2::getUserId).fetch().list();
        System.out.println(users);
    }

    /**
     * Test join fetch single.
     */
    @Test
    void testJoinFetchSingle() {
        Tuple2<User2, UserInfo2> tuple = query.find(User2.class).join(UserInfo2::getUserId).fetch().limit(1).single();
        System.out.println(tuple);
    }

    /**
     * Test join fetch unique.
     */
    @Test
    void testJoinFetchUnique() {
        Tuple2<User2, UserInfo2> tuple = query.find(User2.class).join(UserInfo2::getUserId).fetch().limit(1).unique();
        System.out.println(tuple);
    }

    /**
     * Test join fetch pagination.
     */
    @Test
    void testJoinFetchPagination() {
        PaginationResults<Tuple2<User2, UserInfo2>> page = query.find(User2.class).join(UserInfo2::getUserId).fetch()
                .limit(1).pagination();
        System.out.println(page);
    }
}
