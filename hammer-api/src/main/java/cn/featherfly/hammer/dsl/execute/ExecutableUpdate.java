
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.ExecutableUpdateExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableUpdate extends PropertyExecutableUpdate,
        ExecutableUpdateExpression<ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, UpdateValue, UpdateNumberValue> {
}
