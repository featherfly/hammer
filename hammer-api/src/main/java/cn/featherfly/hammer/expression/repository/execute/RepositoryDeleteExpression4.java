
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression4;

/**
 * repository delete expression 4.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface RepositoryDeleteExpression4<
    C extends RepositoryExecutableConditionsGroupExpression4<C, L, DeleteConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression4<C, L, DeleteConditionConfig>>
    extends RepositoryWhereExpression4<C, L>,
    ConfigureExpression<RepositoryDeleteExpression4<C, L>, DeleteConfig, DeleteConditionConfig> {
}
