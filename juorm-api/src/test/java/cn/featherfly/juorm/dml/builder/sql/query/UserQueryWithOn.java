
package cn.featherfly.juorm.dml.builder.sql.query;

import cn.featherfly.juorm.expression.query.QueryWithOnExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserQueryWithOn implements
        QueryWithOnExpression<UserQueryWith, UserQueryWithOn, UserQueryWithEntity, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName, String repositoryName, String repositoryPropertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName, String findRepositoryPropertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
