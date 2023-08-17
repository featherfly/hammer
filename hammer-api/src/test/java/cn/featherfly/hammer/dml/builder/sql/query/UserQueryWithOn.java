
package cn.featherfly.hammer.dml.builder.sql.query;

import cn.featherfly.hammer.expression.query.QueryRelateOnExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserQueryWithOn implements QueryRelateOnExpression<UserQueryWith, UserQueryWithOn, UserQueryWithEntity,
        UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName, String repositoryName, String repositoryPropertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryWithEntity on(String propertyName, String findRepositoryPropertyName) {

        return null;
    }

}
