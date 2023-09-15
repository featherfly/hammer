
package cn.featherfly.hammer.dml.builder.sql.update;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.hammer.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.execute.ExecutableUpdateSetExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserUpdate implements UserPropertiesUpdate, ExecutableUpdateSetExpression<UserUpdate,
        UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

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

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserUpdate set(SerializableFunction<T, R> name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UserUpdateNumberValue propertyNumber(SerializableFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UserUpdate increase(SerializableFunction<T, R> name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserUpdate set(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(SerializableSupplier<N> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdate set(Consumer<UserUpdate> consumer) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where(
            Consumer<ConditionGroupConfig<UserQueryConditionGroupExpression>> consumer) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdate set(BooleanSupplier whether, String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(BooleanSupplier whether, String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserUpdate set(BooleanSupplier whether, SerializableFunction<T, R> name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserUpdate set(BooleanSupplier whether, SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UserUpdate increase(BooleanSupplier whether, SerializableFunction<T, R> name,
            R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(BooleanSupplier whether, SerializableSupplier<N> property) {

        return null;
    }

}
