
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdateExpression;

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
