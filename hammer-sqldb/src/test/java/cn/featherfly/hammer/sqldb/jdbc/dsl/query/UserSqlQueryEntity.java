
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

    SqlQueryEntity queryEntity;

    /**
     * @param queryEntity
     */
    public UserSqlQueryEntity(SqlQueryEntity queryEntity, JdbcMappingFactory mappingFactory) {
        super(queryEntity, mappingFactory);
        this.mappingFactory = mappingFactory;
        this.queryEntity = queryEntity;
    }

    public UserSqlQueryProperties properties() {
        return new UserSqlQueryProperties(queryEntity, mappingFactory);
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
