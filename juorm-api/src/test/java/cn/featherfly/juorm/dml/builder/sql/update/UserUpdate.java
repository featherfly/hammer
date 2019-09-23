
package cn.featherfly.juorm.dml.builder.sql.update;

import cn.featherfly.common.lang.function.SerializableFunction;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserUpdateValue property(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserUpdate set(SerializableFunction<T, R> name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UserUpdateNumberValue propertyNumber(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number, N extends Number> UserUpdate increase(SerializableFunction<T, R> name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
