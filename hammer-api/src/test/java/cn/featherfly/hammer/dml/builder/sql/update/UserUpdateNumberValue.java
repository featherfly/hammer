
package cn.featherfly.hammer.dml.builder.sql.update;

import java.util.function.BooleanSupplier;

import cn.featherfly.hammer.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 *
 * @author zhongj
 */
public class UserUpdateNumberValue
        implements UpdateNumberValueExpression<UserPropertiesUpdate, UserQueryConditionGroupExpression,
                UserQueryConditionGroupExpression, Number, UserUpdateValue, UserUpdateNumberValue> {

    private UserUpdate update;

    private String name;

    /**
     * @param userUpdate
     * @param name
     */
    public UserUpdateNumberValue(UserUpdate update, String name) {
        this.name = name;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate set(Number value) {
        return update.set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate increase(Number value) {
        return update.increase(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate set(BooleanSupplier whether, Number value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate increase(BooleanSupplier whether, Number value) {

        return null;
    }
}
