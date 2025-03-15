
package cn.featherfly.hammer.sqldb.dsl.repository;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
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
public class RepositorySqlQuerySortTest extends JdbcTestBase {

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

    @Test
    void testSort() {
        List<Integer> ids = query.find(USER)//
            .fetch(ID) //
            .sort() //
            .asc(ID)//
            .limit(2) //
            .list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER)//
            .fetch("id").sort()//
            .order(SortOperator.ASC, ID)//
            .limit(2) //
            .list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER)//
            .fetch(ID) //
            .sort() //
            .desc(ID)//
            .limit(2) //
            .list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER)//
            .fetch("id") //
            .sort()//
            .order(SortOperator.DESC, ID)//
            .limit(2) //
            .list();
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER)//
            .fetch("id") //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc(ID)//
            .list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER)//
            .fetch("id") //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.ASC, ID)//
            .list();
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER)//
            .fetch("id") //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc(ID)//
            .list();
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER)//
            .fetch("id") //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.DESC, ID)//
            .list();
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort2() {
        List<Integer> ids = query.find(USER)//
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .sort()//
            .asc2(ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .sort()//
            .order2(SortOperator.ASC, ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .sort().desc2(ID)//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .sort().order2(SortOperator.DESC, ID)//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .asc2(ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .order2(SortOperator.ASC, ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .desc2(ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .order2(SortOperator.DESC, ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        List<Tuple2<User2, UserInfo2>> list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().desc2(ID)//
            .limit(2) //
            .list(User2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get1().getId() > list.get(1).get1().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().order2(SortOperator.DESC, ID)//
            .limit(2) //
            .list(User2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get1().getId() > list.get(1).get1().getId());
    }

    @Test
    void testSort2_2() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc((e1, e2) -> e2.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order(SortOperator.ASC, (e1, e2) -> e2.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort().desc((e1, e2) -> e2.field(ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort().order(SortOperator.DESC, (e1, e2) -> e2.field(ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .asc((e1, e2) -> e2.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2) -> e2.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .desc((e1, e2) -> e2.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2) -> e2.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort2_3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2) -> e2.asc(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2) -> e2.order(SortOperator.ASC, ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2) -> e2.desc(ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2) -> e2.order(SortOperator.DESC, ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort((e1, e2) -> e2.asc(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort((e1, e2) -> e2.order(SortOperator.ASC, ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort((e1, e2) -> e2.desc(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id")))//
            .where()//
            .gt(ID, 0).and().lt(ID, 20).and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().ge(ID, 0).and().le(ID, 50)//
            .sort((e1, e2) -> e2.order(SortOperator.DESC, ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc3(ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order3(SortOperator.ASC, ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        List<Tuple3<User2, UserInfo2, UserInfo2>> list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().desc3(ID)//
            .limit(2).list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().order3(SortOperator.DESC, ID)//
            .limit(2).list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and().group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc3(ID)//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and().group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order3(SortOperator.ASC, ID)//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and().group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc3(ID)//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and().group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and().group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order3(SortOperator.DESC, ID)//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());
    }

    @Test
    void testSort3_2() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc((e1, e2, e3) -> e3.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3) -> e3.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        List<Tuple3<User2, UserInfo2, UserInfo2>> list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().desc((e1, e2, e3) -> e3.field(ID))//
            .limit(2) //
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort().order(SortOperator.DESC, (e1, e2, e3) -> e3.field(ID))//
            .limit(2).list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc((e1, e2, e3) -> e3.field(ID))//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3) -> e3.field(ID))//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc((e1, e2, e3) -> e3.field(ID))//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3) -> e3.field(ID))//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());
    }

    @Test
    void testSort3_3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3) -> e3.asc(ID)) //
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3) -> e3.order(SortOperator.ASC, ID)) //
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        List<Tuple3<User2, UserInfo2, UserInfo2>> list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort((e1, e2, e3) -> e3.desc(ID)) //
            .limit(2).list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .sort((e1, e2, e3) -> e3.order(SortOperator.DESC, ID)) //
            .limit(2).list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc((e1, e2, e3) -> e3.field(ID))//
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3) -> e3.asc(ID)) //
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3) -> e3.order(SortOperator.ASC, ID)) //
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() < list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3) -> e3.desc(ID)) //
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());

        list = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))).fetch() //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))).fetch() //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3) -> e3.order(SortOperator.DESC, ID)) //
            .list(User2.class, UserInfo2.class, UserInfo2.class);
        assertTrue(list.get(0).get2().getId() > list.get(1).get2().getId());
    }

    @Test
    void testSort4() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc4(ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order4(SortOperator.ASC, ID)//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort().desc4(ID)//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort().order4(SortOperator.DESC, ID)//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc4(ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order4(SortOperator.ASC, ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc4(ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order4(SortOperator.DESC, ID)//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort4_2() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .asc((e1, e2, e3, e4) -> e4.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort()//
            .order(SortOperator.ASC, (e1, e2, e3, e4) -> e4.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort().desc((e1, e2, e3, e4) -> e4.field(ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort().order(SortOperator.DESC, (e1, e2, e3, e4) -> e4.field(ID))//
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .asc((e1, e2, e3, e4) -> e4.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.ASC, (e1, e2, e3, e4) -> e4.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .desc((e1, e2, e3, e4) -> e4.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort() //
            .order(SortOperator.DESC, (e1, e2, e3, e4) -> e4.field(ID))//
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));
    }

    @Test
    void testSort4_3() {
        List<Integer> ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4) -> e4.asc(ID)) //
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4) -> e4.order(SortOperator.ASC, ID)) //
            .order(SortOperator.ASC, (e1, e2, e3, e4) -> e4.field(ID))//
            .limit(2) //
            .list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4) -> e4.desc(ID)) //
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .sort((e1, e2, e3, e4) -> e4.order(SortOperator.DESC, ID)) //
            .limit(2).list(Integer.class);
        assertTrue(ids.size() == 2);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4) -> e4.asc(ID)) //
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20) //
            .and() //
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and() //
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and() //
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4) -> e4.order(SortOperator.ASC, ID)) //
            .list(Integer.class);
        assertTrue(ids.get(0) < ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4) -> e4.desc(ID)) //
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));

        ids = query.find(USER) //
            .fetch(ID) //
            .join(USER_INFO).on((r1, r2) -> r2.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3) -> r3.field("user_id").eq(r1.field("id"))) //
            .join(USER_INFO).on((r1, r2, r3, r4) -> r4.field("user_id").eq(r1.field("id"))) //
            .where()//
            .gt(ID, 0).and().lt(ID, 20)//
            .and()//
            .group().gt2(ID, 0).or().lt2(ID, 20).endGroup()//
            .and()//
            .group().gt3(ID, 0).or().lt3(ID, 20).endGroup()//
            .and()//
            .group().gt4(ID, 0).or().lt4(ID, 20).endGroup()//
            .and().ge(AGE, 0).and().le(AGE, 50)//
            .sort((e1, e2, e3, e4) -> e4.order(SortOperator.DESC, ID)) //
            .list(Integer.class);
        assertTrue(ids.get(0) > ids.get(1));
    }

    // sort 5-6 在 EntitySqlQuerySortTest2 中
}
