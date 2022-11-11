
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;

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

        count = query.find(User.class).where().eq(User::getUsername, "yufei", QueryPolicy.CASE_SENSITIVE).count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "YUfei", QueryPolicy.CASE_INSENSITIVE).count();

        assertEquals(count, one);

        count = query.find(User.class).where().eq(User::getUsername, "YUfei", QueryPolicy.CASE_SENSITIVE).count();

        assertEquals(count, zero);

        // ------------------------

        count = query.find(User.class).where().property(User::getUsername).eq("yufei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei").count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("yufei", QueryPolicy.CASE_SENSITIVE)
                .count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei", QueryPolicy.CASE_INSENSITIVE)
                .count();

        assertEquals(count, one);

        count = query.find(User.class).where().property(User::getUsername).eq("YUfei", QueryPolicy.CASE_SENSITIVE)
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

        count = query.find(User.class).where().lk(User::getUsername, "y%", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().lk(User::getUsername, "Y%", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().lk(User::getUsername, "Y%", QueryPolicy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).lk("y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("y%", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).lk("Y%", QueryPolicy.CASE_INSENSITIVE)
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

        count = query.find(User.class).where().sw(User::getUsername, "y", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().sw(User::getUsername, "Y", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().sw(User::getUsername, "Y", QueryPolicy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).sw("y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("y", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).sw("Y", QueryPolicy.CASE_INSENSITIVE)
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

        count = query.find(User.class).where().ew(User::getUsername, "ei", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().ew(User::getUsername, "EI", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().ew(User::getUsername, "EI", QueryPolicy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).ew("ei").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("ei", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).ew("EI", QueryPolicy.CASE_INSENSITIVE)
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

        count = query.find(User.class).where().co(User::getUsername, "uf", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().co(User::getUsername, "UF", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().co(User::getUsername, "UF", QueryPolicy.CASE_INSENSITIVE).count();

        assertTrue(count > zero);

        // -----------------------------------------

        count = query.find(User.class).where().property(User::getUsername).co("uf").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF").count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("uf", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count > zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF", QueryPolicy.CASE_SENSITIVE).count();

        assertTrue(count == zero);

        count = query.find(User.class).where().property(User::getUsername).co("UF", QueryPolicy.CASE_INSENSITIVE)
                .count();

        assertTrue(count > zero);
    }

    // TODO 后续加入DSL的关联查询的大小写查询测试（join查询）
}
