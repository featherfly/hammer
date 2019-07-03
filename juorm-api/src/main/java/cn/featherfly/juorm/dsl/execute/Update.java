
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.expression.execute.UpdateExpression;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface Update extends PropertyUpdate,
        UpdateExpression<ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, UpdateValue, UpdateNumberValue> {

}
