
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * DeleteExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryDeleteExpression<C extends ExecutableConditionGroupExpression<C, L, DeleteConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, DeleteConditionConfig>>
        extends RepositoryWhereExpression<C, L>,
        ConfigureExpression<RepositoryDeleteExpression<C, L>, DeleteConfig, DeleteConditionConfig> {
}
