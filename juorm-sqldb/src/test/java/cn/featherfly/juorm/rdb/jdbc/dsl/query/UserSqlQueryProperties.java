
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.vo.User;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryProperties
        extends TypeQueryProperties<User, UserSqlQueryConditionGroupExpression, UserSqlQueryProperties> {

    /**
     * @param queryEntityProperties
     * @param mappingFactory
     */
    public UserSqlQueryProperties(SqlQueryEntityProperties queryEntityProperties, MappingFactory mappingFactory) {
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
