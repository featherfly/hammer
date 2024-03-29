
package cn.featherfly.hammer.dml.builder.sql.update;

import java.util.function.Consumer;

import cn.featherfly.hammer.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertiesUpdate set(
            Consumer<UpdateValueExpression<UserPropertiesUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression, Object, UserUpdateValue, UserUpdateNumberValue>> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
