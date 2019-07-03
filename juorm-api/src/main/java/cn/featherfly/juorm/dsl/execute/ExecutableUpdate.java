
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.expression.execute.ExecutableUpdateExpression;

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
