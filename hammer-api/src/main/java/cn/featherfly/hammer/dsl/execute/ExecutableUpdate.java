
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.ExecutableUpdateExpression;

/**
 * executable update.
 *
 * @author zhongj
 */
public interface ExecutableUpdate extends PropertyExecutableUpdate,
        ExecutableUpdateExpression<ExecutableUpdate, ExecutableConditionGroup, ExecutableConditionGroupLogic, UpdateValue, UpdateNumberValue> {
}
