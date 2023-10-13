
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.expression.execute.DeleteExpression;

/**
 * Delete.
 *
 * @author zhongj
 */
public interface Delete extends DeleteExpression<ExecutableConditionGroup<DeleteConditionConfig>,
        ExecutableConditionGroupLogic<DeleteConditionConfig>> {

}
