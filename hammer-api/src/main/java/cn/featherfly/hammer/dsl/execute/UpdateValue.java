
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

/**
 * update value.
 *
 * @author zhongj
 */
public interface UpdateValue
        extends UpdateValueExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
                ExecutableConditionGroupLogic<UpdateConditionConfig>, Object, UpdateValue, UpdateNumberValue> {
}
