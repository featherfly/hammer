
package cn.featherfly.juorm.dml.builder.sql.vo;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.expression.query.Query;

/**
 * <p>
 * UserUpdate
 * </p>
 * 
 * @author zhongj
 */
public class UserQuery implements
        Query<UserQueryConditionGroupExpression, UserQueryEntity, UserQueryEntity> {

    // Q extends QueryEntity<QP, C>, QP extends QueryPropertiesData<QP, C>
    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryEntity find(Repository repository) {
        return null;
    }

    public UserQueryEntity find() {
        return null;
    }
}
