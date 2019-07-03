
package cn.featherfly.juorm.dml.builder.sql.vo;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.property.UpdateValue;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 * 
 * @author zhongj
 */
public class UserUpdateValue<T> implements
        UpdateValue<UserPropertyUpdate, ExecutableConditionGroupExpression, T> {

    private UserPropertyUpdate update;
    private UserUpdate userUpdate;

    private String name;

    /**
     */
    public UserUpdateValue(UserPropertyUpdate update, String name,
            UserUpdate userUpdate) {
        this.update = update;
        this.name = name;
        this.userUpdate = userUpdate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertyUpdate set(T value) {
        userUpdate.set(name, value);
        return update;
    }
}
