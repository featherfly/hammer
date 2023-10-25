
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.PropertyUpdateExpression;

/**
 * property update.
 *
 * @author zhongj
 */
public interface PropertyUpdate
        extends PropertyUpdateExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
                ExecutableConditionGroupLogic<UpdateConditionConfig>, UpdateValue, UpdateNumberValue> {

}
