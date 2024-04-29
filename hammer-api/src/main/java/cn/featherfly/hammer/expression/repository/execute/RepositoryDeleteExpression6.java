
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression6;

/**
 * repository delete expression 6.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryDeleteExpression6<
    C extends RepositoryExecutableConditionsGroupExpression6<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression6<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression6<C, L>,
    ConfigureExpression<RepositoryDeleteExpression6<C, L>, DeleteConfig, DeleteConditionConfig> {
}
