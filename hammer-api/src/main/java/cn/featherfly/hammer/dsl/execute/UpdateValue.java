
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

/**
 * update value.
 *
 * @author zhongj
 */
public interface UpdateValue extends
        UpdateValueExpression<ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, Object, UpdateValue, UpdateNumberValue> {
}
