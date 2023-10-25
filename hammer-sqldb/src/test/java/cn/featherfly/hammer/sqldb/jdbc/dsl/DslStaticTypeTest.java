
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.UserSqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * <p>
 * DslTest
 * </p>
 *
 * @author zhongj
 */
public class DslStaticTypeTest extends JdbcTestBase {

    private void p(User u) {
        System.out.println(u);
    }

    @Test
    public void testQuery() {
        SqlQuery sqlQuery = new SqlQuery(jdbc, metadata, sqlPageFactory, hammerConfig.getDslConfig().getQueryConfig());
        UserSqlQuery userQuery = new UserSqlQuery(sqlQuery, mappingFactory);
        // userQuery.find().properties().name().pwd().limit(1)
        // .single(UserQuery.class);

        p(userQuery.find().properties().username().pwd().limit(1).single());

        p(userQuery.find().limit(1).single());
        p(userQuery.find().where().username().eq("yufei").and().pwd().eq("123456").single());

    }

}
