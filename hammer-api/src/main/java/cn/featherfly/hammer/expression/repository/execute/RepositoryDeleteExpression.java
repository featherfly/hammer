
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * repository delete expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryDeleteExpression<
    C extends RepositoryExecutableConditionsGroupExpression<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression<C, L>,
    ConfigureExpression<RepositoryDeleteExpression<C, L>, DeleteConfig, DeleteConditionConfig> {
}
