
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdateExpression;

/**
 * Update.
 *
 * @author zhongj
 */
public interface Update extends PropertyUpdate,
        UpdateExpression<ExecutableUpdate, ExecutableConditionGroup, ExecutableConditionGroupLogic, UpdateValue, UpdateNumberValue> {

}
