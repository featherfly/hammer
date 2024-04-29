
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;

/**
 * executable condition group expression,.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface RepositoryExecutableConditionsGroupExpression<
    C extends RepositoryExecutableConditionsGroupExpression<C, L, C2>,
    L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
    extends RepositoryConditionsGroupExpression<C, L>, ConditionConfigureExpression<C, C2> {
}
