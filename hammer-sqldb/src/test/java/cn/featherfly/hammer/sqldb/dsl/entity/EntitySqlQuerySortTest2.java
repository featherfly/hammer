
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * sql entity query sort test.
 *
 * @author zhongj
 */
public class EntitySqlQuerySortTest2 extends JdbcTestBase {

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

    // sort 1-4 在EntitySqlQuerySortTest中

    @Test
    void testSort5() {
        List<User2> users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .asc5(UserInfo2::getId)//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .order5(SortOperator.ASC, UserInfo2::getId)//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().desc5(UserInfo2::getId)//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().order5(SortOperator.DESC, UserInfo2::getId)//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .asc5(UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order5(SortOperator.ASC, UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .desc5(UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order5(SortOperator.DESC, UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    @Test
    void testSort5_2() {
        List<User2> users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .asc((e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().desc((e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().order(SortOperator.DESC, (e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .asc((e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .desc((e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3, e4, e5) -> e5.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    @Test
    void testSort6() {
        List<User2> users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .asc6(UserInfo2::getId)//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .order6(SortOperator.ASC, UserInfo2::getId)//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().desc6(UserInfo2::getId)//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().order6(SortOperator.DESC, UserInfo2::getId)//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .asc6(UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order6(SortOperator.ASC, UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .desc6(UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order6(SortOperator.DESC, UserInfo2::getId)//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    @Test
    void testSort6_2() {
        List<User2> users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .asc((e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .limit(2) //
            .list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().desc((e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .sort().order(SortOperator.DESC, (e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .asc((e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class) //
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20) //
            .and() //
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and() //
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .desc((e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());

        users = query.find(User2.class)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .join(UserInfo2.class).on(UserInfo2::getUserId)//
            .where()//
            .gt(User2::getId, 0).and().lt(User2::getId, 20)//
            .and()//
            .group().gt2(UserInfo2::getId, 0).or().lt2(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt3(UserInfo2::getId, 0).or().lt3(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt4(UserInfo2::getId, 0).or().lt4(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt5(UserInfo2::getId, 0).or().lt5(UserInfo2::getId, 20).endGroup()//
            .and()//
            .group().gt6(UserInfo2::getId, 0).or().lt6(UserInfo2::getId, 20).endGroup()//
            .and().ge(User2::getAge, 0).and().le(User2::getAge, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3, e4, e5, e6) -> e6.property(UserInfo2::getId))//
            .list();
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }
}
