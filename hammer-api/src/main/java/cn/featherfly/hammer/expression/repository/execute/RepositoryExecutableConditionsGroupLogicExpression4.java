
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression4;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogicExpression4<
    C extends RepositoryExecutableConditionsGroupExpression4<C, L, C2>,
    L extends RepositoryExecutableConditionsGroupLogicExpression4<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
    extends Executor, RepositoryConditionsGroupLogicExpression4<C, L> {

}
