
package cn.featherfly.hammer.sqldb.dsl.repository;

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

/**
 * sql entity query sort test.
 *
 * @author zhongj
 */
public class RepositorySqlQuerySortTest2 extends JdbcTestBase {

    private static final String USER = "user";
    private static final String ID = "id";
    private static final String AGE = "id";
    private static final String USER_INFO = "user_info";

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
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc5(ID)//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order5(SortOperator.ASC, ID)//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort().desc5(ID)//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort().order5(SortOperator.DESC, ID)//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc5(ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order5(SortOperator.ASC, ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc5(ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order5(SortOperator.DESC, ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort5_2() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc((e1, e2, e3, e4, e5) -> e5.field(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5) -> e5.field(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort().desc((e1, e2, e3, e4, e5) -> e5.field(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort().order(SortOperator.DESC, (e1, e2, e3, e4, e5) -> e5.field(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc((e1, e2, e3, e4, e5) -> e5.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5) -> e5.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc((e1, e2, e3, e4, e5) -> e5.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3, e4, e5) -> e5.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort5_3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5) -> e5.asc(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5) -> e5.order(SortOperator.ASC, ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5) -> e5.desc(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5) -> e5.order(SortOperator.DESC, ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5) -> e5.asc(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5) -> e5.order(SortOperator.ASC, ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5) -> e5.desc(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5) -> e5.order(SortOperator.DESC, ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort6() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc6(ID)//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order6(SortOperator.ASC, ID)//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort().desc6(ID)//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort().order6(SortOperator.DESC, ID)//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc6(ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order6(SortOperator.ASC, ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc6(ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order6(SortOperator.DESC, ID)//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort6_2() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc((e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort().desc((e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort().order(SortOperator.DESC, (e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc((e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc((e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3, e4, e5, e6) -> e6.field(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort6_3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5, e6) -> e6.asc(ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5, e6) -> e6.order(SortOperator.ASC, ID))//
            .limit(2) //
            .mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5, e6) -> e6.desc(ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4, e5, e6) -> e6.order(SortOperator.DESC, ID))//
            .limit(2).mapper(Integer.class).list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5, e6) -> e6.asc(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and() //
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and() //
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5, e6) -> e6.order(SortOperator.ASC, ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5, e6) -> e6.desc(ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5) -> r5.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4, r5, r6) -> r6.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and()//
            .group().gt5(ID, 0).or().lt5(ID, 20).endGroup()//
            .and()//
            .group().gt6(ID, 0).or().lt6(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4, e5, e6) -> e6.order(SortOperator.DESC, ID))//
            .mapper(Integer.class).list();
        assertTrue(ids.get(0) > ids.get(1));
    }
}
