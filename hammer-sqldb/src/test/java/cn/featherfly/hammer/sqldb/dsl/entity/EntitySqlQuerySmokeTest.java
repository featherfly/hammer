
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * 冒烟测试.
 *
 * @author zhongj
 */
public class EntitySqlQuerySmokeTest extends JdbcTestBase {

    /** The query. */
    SqlQuery query;

    /** The user info. */
    UserInfo userInfo = null;

    /** The user. */
    User user = null;

    /** The uid. */
    Integer uid = 1;

    /** The trees. */
    List<Tree> trees = new ArrayList<>();

    /**
     * Setup test.
     */
    @BeforeTest
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);
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

    @Test
    void testEntityOrmSort() {
        List<User> users = query.find(User.class)//
            .join(UserInfo::getUser)//
            .where((e1, e2) -> e2.property(UserInfo::getUser).property(User::getId).eq(e1.property(User::getId))).sort()//
            .asc2(UserInfo::getId)//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User.class).join(UserInfo::getUser).sort().desc2(UserInfo::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    /**
     * Test join.
     */
    @Test
    void testJoin() {
        List<User2> users = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).list();
        System.out.println(users);
    }

    @Test
    void testJoinConditions() {
        List<User2> users = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20).and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .list();
        System.out.println(users);
    }

    /**
     * Test join fetch list.
     */
    @Test
    void testJoinFetchList() {
        List<Tuple2<User2, UserInfo2>> users = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId)
            .fetch().list();
        System.out.println(users);
    }

    /**
     * Test join fetch single.
     */
    @Test
    void testJoinFetchSingle() {
        Tuple2<User2, UserInfo2> tuple = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch()
            .limit(1).single();
        System.out.println(tuple);
    }

    /**
     * Test join fetch unique.
     */
    @Test
    void testJoinFetchUnique() {
        Tuple2<User2, UserInfo2> tuple = query.find(User2.class).join(UserInfo2.class).on(UserInfo2::getUserId).fetch()
            .limit(1).unique();
        System.out.println(tuple);
    }

    /**
     * Test join fetch pagination.
     */
    @Test
    void testJoinFetchPagination() {
        PaginationResults<Tuple2<User2, UserInfo2>> page = query.find(User2.class).join(UserInfo2.class)
            .on(UserInfo2::getUserId).fetch().limit(1).pagination();
        System.out.println(page);
    }
}
