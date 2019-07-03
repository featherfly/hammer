
package cn.featherfly.juorm.dml.builder.sql.vo;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.ExecutableUpdate;
import cn.featherfly.juorm.expression.execute.property.UpdateNumberValue;
import cn.featherfly.juorm.expression.execute.property.UpdateValue;

/**
 * <p>
 * UserUpdate
 * </p>
 * 
 * @author zhongj
 */
public class UserUpdate implements
        ExecutableUpdate<UserUpdate, ExecutableConditionGroupExpression>,
        UserPropertyUpdate {

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdate set(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V extends UpdateValue<UserPropertyUpdate, ExecutableConditionGroupExpression, Object>> V property(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V extends UpdateNumberValue<UserPropertyUpdate, ExecutableConditionGroupExpression, Number>> V propertyNumber(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValue<UserPropertyUpdate, ExecutableConditionGroupExpression, String> name() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValue<UserPropertyUpdate, ExecutableConditionGroupExpression, String> pwd() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValue<UserPropertyUpdate, ExecutableConditionGroupExpression, Integer> age() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
