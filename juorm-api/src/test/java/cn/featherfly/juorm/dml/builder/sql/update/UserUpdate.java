
package cn.featherfly.juorm.dml.builder.sql.update;

import cn.featherfly.juorm.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.SetExecutableUpdateExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserUpdate implements UserPropertiesUpdate,
        SetExecutableUpdateExpression<UserUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue property(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateNumberValue propertyNumber(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdate set(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue name() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue pwd() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateNumberValue age() {

        return null;
    }

}
