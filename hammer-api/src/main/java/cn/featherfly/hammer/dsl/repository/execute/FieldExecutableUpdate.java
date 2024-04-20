
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.FieldExecutableUpdateExpression;

/**
 * property executable update.
 *
 * @author zhongj
 */
public interface FieldExecutableUpdate extends FieldExecutableUpdateExpression<ExecutableUpdate,
    ExecutableConditionGroup<UpdateConditionConfig>, ExecutableConditionGroupLogic<UpdateConditionConfig>> {
}
