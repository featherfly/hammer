
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression5;

/**
 * executable condition group expression,.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface RepositoryExecutableConditionsGroupExpression5<
    C extends RepositoryExecutableConditionsGroupExpression5<C, L, C2>,
    L extends RepositoryExecutableConditionsGroupLogicExpression5<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
    extends RepositoryConditionsGroupExpression5<C, L>, ConditionConfigureExpression<C, C2> {
}
