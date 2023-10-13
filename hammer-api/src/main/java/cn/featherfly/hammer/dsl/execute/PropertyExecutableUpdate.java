
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.PropertyExecutableUpdateExpression;

/**
 * property executable update.
 *
 * @author zhongj
 */
public interface PropertyExecutableUpdate
        extends PropertyExecutableUpdateExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
                ExecutableConditionGroupLogic<UpdateConditionConfig>, UpdateValue, UpdateNumberValue> {
}
