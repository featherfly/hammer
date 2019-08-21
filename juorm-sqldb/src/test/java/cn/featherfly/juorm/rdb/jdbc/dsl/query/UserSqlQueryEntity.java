
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.rdb.jdbc.dsl.type.TypeQueryEntity;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.jdbc.vo.User;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryEntity extends
        TypeQueryEntity<User, UserSqlQueryConditionGroupExpression, UserSqlQueryEntity> {

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
