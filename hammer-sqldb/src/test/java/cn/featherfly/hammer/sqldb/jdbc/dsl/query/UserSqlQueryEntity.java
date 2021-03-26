
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.type.StaticTypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryEntity
        extends StaticTypeQueryEntity<User, UserSqlQueryConditionGroupExpression, UserSqlQueryEntity> {

    private JdbcMappingFactory mappingFactory;

    SqlQueryEntityProperties queryEntityProperties;

    /**
     * @param queryEntityProperties
     */
    public UserSqlQueryEntity(SqlQueryEntityProperties queryEntityProperties, JdbcMappingFactory mappingFactory) {
        super(queryEntityProperties, mappingFactory);
        this.mappingFactory = mappingFactory;
        this.queryEntityProperties = queryEntityProperties;
    }

    public UserSqlQueryProperties properties() {
        return new UserSqlQueryProperties(queryEntityProperties, mappingFactory);
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
