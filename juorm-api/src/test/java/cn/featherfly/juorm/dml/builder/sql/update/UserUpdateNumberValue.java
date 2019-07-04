
package cn.featherfly.juorm.dml.builder.sql.update;

import cn.featherfly.juorm.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.UpdateNumberValueExpression;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 *
 * @author zhongj
 */
public class UserUpdateNumberValue implements
        UpdateNumberValueExpression<UserPropertiesUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression, Number, UserUpdateValue, UserUpdateNumberValue> {

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
}
