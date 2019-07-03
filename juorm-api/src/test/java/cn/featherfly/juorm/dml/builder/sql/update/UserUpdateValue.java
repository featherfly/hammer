
package cn.featherfly.juorm.dml.builder.sql.update;

import cn.featherfly.juorm.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.UpdateValueExpression;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 *
 * @author zhongj
 */
public class UserUpdateValue implements
        UpdateValueExpression<UserPropertiesUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression, Object, UserUpdateValue, UserUpdateNumberValue> {

    private String name;

    private UserUpdate update;

    /**
     */
    public UserUpdateValue(String name, UserUpdate update) {
        this.update = update;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate set(Object value) {
        return update.set(name, value);
    }
}
