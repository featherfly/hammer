
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression;

/**
 * Delete.
 *
 * @author zhongj
 */
public interface RepositoryDelete extends RepositoryDeleteExpression<ExecutableConditionGroup<DeleteConditionConfig>,
        ExecutableConditionGroupLogic<DeleteConditionConfig>> {

}
