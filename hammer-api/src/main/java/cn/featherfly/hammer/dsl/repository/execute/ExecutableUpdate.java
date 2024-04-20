
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.ExecutableUpdateExpression;

/**
 * executable update.
 *
 * @author zhongj
 */
public interface ExecutableUpdate extends FieldExecutableUpdate, ExecutableUpdateExpression<ExecutableUpdate,
    ExecutableConditionGroup<UpdateConditionConfig>, ExecutableConditionGroupLogic<UpdateConditionConfig>> {
}
