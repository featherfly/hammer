
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryConditionGroupExpression;
import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.sqldb.jdbc.dsl.type.StaticTypeQueryProperties;
import cn.featherfly.juorm.sqldb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.sqldb.jdbc.vo.User;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryProperties
        extends StaticTypeQueryProperties<User, UserSqlQueryConditionGroupExpression, UserSqlQueryProperties> {

    /**
     * @param queryEntityProperties
     * @param mappingFactory
     */
    public UserSqlQueryProperties(SqlQueryEntityProperties queryEntityProperties, JdbcMappingFactory mappingFactory) {
        super(queryEntityProperties, mappingFactory);
    }

    public UserSqlQueryProperties username() {
        property("username");
        return this;
    }

    public UserSqlQueryProperties pwd() {
        property("password", "pwd");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserSqlQueryConditionGroupExpression createCondition(
            SqlQueryConditionGroupExpression queryConditionGroupExpression) {
        return new UserSqlQueryConditionGroupExpression(queryConditionGroupExpression);
    }
}
