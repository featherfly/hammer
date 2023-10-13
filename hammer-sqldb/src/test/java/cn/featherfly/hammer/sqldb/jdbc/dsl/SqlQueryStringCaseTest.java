
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * SqlQueryTest.
 *
 * @author zhongj
 */
public class SqlQueryStringCaseTest extends JdbcTestBase {

    @Test(groups = "mysql")
    void testQueryEqCaseInsensitive() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        Long one = 1L;
        Long zero = 0L;

        Long count = query.find(User.class).where().eq(User::getUsername, "yufei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "YUfei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "yufei", MatchStrategy.CASE_SENSITIVE).count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "YUfei", MatchStrategy.CASE_INSENSITIVE).count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "YUfei", MatchStrategy.CASE_SENSITIVE).count();

        assertEquals(count, zero);

        // ------------------------

        count = query.find(User.class).where().property(User::getUsername).eq("yufei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("yufei", MatchStrategy.CASE_SENSITIVE)
                .count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei", MatchStrategy.CASE_INSENSITIVE)
                .count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei", MatchStrategy.CASE_SENSITIVE)
                .count();

        assertEquals(count, zero);

    }

    @Test(groups = "mysql")
    void testQueryLikeCaseInsensitive() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long zero = 0L;

        long count = query.find(User.class).where().lk(User::getUsername, "y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().lk(User::getUsername, "Y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().lk(User::getUsername, "y%", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().lk(User::getUsername, "Y%", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().lk(User::getUsername, "Y%", MatchStrategy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).lk("y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("y%", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%", MatchStrategy.CASE_INSENSITIVE)
                .count();

        assertTrue(count > zero);

    }

    @Test(groups = "mysql")
    void testQuerySwCaseInsensitive() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long zero = 0L;

        long count = query.find(User.class).where().sw(User::getUsername, "y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().sw(User::getUsername, "Y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().sw(User::getUsername, "y", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().sw(User::getUsername, "Y", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().sw(User::getUsername, "Y", MatchStrategy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).sw("y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("y", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y", MatchStrategy.CASE_INSENSITIVE)
                .count();

        assertTrue(count > zero);

    }

    @Test(groups = "mysql")
    void testQueryEwCaseInsensitive() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long zero = 0L;

        long count = query.find(User.class).where().ew(User::getUsername, "ei").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().ew(User::getUsername, "EI").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().ew(User::getUsername, "ei", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().ew(User::getUsername, "EI", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().ew(User::getUsername, "EI", MatchStrategy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).ew("ei").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("ei", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI", MatchStrategy.CASE_INSENSITIVE)
                .count();

        assertTrue(count > zero);
    }

    @Test(groups = "mysql")
    void testQueryCoCaseInsensitive() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);

        long zero = 0L;

        long count = query.find(User.class).where().co(User::getUsername, "uf").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().co(User::getUsername, "UF").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().co(User::getUsername, "uf", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().co(User::getUsername, "UF", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().co(User::getUsername, "UF", MatchStrategy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).co("uf").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("uf", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF", MatchStrategy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF", MatchStrategy.CASE_INSENSITIVE)
                .count();

        assertTrue(count > zero);
    }

    // TODO 后续加入DSL的关联查询的大小写查询测试（join查询）
}
