
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryConditionGroupExpression;
import cn.featherfly.juorm.sqldb.jdbc.dsl.query.SqlQueryEntityProperties;
import cn.featherfly.juorm.sqldb.jdbc.dsl.type.StaticTypeQueryEntity;
import cn.featherfly.juorm.sqldb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.sqldb.jdbc.vo.User;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryEntity extends
        StaticTypeQueryEntity<User, UserSqlQueryConditionGroupExpression, UserSqlQueryEntity> {

    private JdbcMappingFactory mappingFactory;

    SqlQueryEntityProperties queryEntityProperties;

    /**
     * @param queryEntityProperties
     */
    public UserSqlQueryEntity(SqlQueryEntityProperties queryEntityProperties,
            JdbcMappingFactory mappingFactory) {
        super(queryEntityProperties, mappingFactory);
        this.mappingFactory = mappingFactory;
        this.queryEntityProperties = queryEntityProperties;
    }

    public UserSqlQueryProperties properties() {
        return new UserSqlQueryProperties(queryEntityProperties,
                mappingFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserSqlQueryConditionGroupExpression createCondition(
            SqlQueryConditionGroupExpression queryConditionGroupExpression) {
        return new UserSqlQueryConditionGroupExpression(
                queryConditionGroupExpression);
    }
}
