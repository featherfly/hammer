
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression2;

/**
 * repository delete expression 2.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryDeleteExpression2<
    C extends RepositoryExecutableConditionsGroupExpression2<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression2<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression2<C, L>,
    ConfigureExpression<RepositoryDeleteExpression2<C, L>, DeleteConfig, DeleteConditionConfig> {
}
