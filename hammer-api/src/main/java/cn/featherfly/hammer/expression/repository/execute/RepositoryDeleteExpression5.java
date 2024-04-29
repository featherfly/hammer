
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression5;

/**
 * repository delete expression 5.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryDeleteExpression5<
    C extends RepositoryExecutableConditionsGroupExpression5<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression5<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression5<C, L>,
    ConfigureExpression<RepositoryDeleteExpression5<C, L>, DeleteConfig, DeleteConditionConfig> {
}
