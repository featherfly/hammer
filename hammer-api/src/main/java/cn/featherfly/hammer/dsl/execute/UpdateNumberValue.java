
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;

/**
 * update number value.
 *
 * @author zhongj
 */
public interface UpdateNumberValue
        extends UpdateNumberValueExpression<ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
                ExecutableConditionGroupLogic<UpdateConditionConfig>, Number, UpdateValue, UpdateNumberValue> {
}
