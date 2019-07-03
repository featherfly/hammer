
package cn.featherfly.juorm.dml.builder.sql.vo;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.property.UpdateNumberValue;

/**
 * <p>
 * SimpleUpdateValue
 * </p>
 * 
 * @author zhongj
 */
public class UserUpdateNumberValue<T extends Number> implements
        UpdateNumberValue<UserPropertyUpdate, ExecutableConditionGroupExpression, T> {

    private UserUpdate userUpdate;

    private String name;

    /**
     */
    public UserUpdateNumberValue(UserUpdate userUpdate, String name) {
        this.name = name;
        this.userUpdate = userUpdate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertyUpdate set(T value) {
        return userUpdate.set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPropertyUpdate increase(T value) {
        return userUpdate.increase(name, value);
    }
}
