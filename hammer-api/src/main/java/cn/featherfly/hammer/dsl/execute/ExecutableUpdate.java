
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.ExecutableUpdateExpression;

/**
 * executable update.
 *
 * @author zhongj
 */
public interface ExecutableUpdate extends PropertyExecutableUpdate,
        ExecutableUpdateExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
                ExecutableConditionGroupLogic<UpdateConditionConfig>, UpdateValue, UpdateNumberValue> {
}
