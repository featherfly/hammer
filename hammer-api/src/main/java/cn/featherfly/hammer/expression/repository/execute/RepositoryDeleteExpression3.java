
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression3;

/**
 * repository delete expression 3.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryDeleteExpression3<
    C extends RepositoryExecutableConditionsGroupExpression3<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression3<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression3<C, L>,
    ConfigureExpression<RepositoryDeleteExpression3<C, L>, DeleteConfig, DeleteConditionConfig> {
}
