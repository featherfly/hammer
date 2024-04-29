
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression6;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogicExpression6<
    C extends RepositoryExecutableConditionsGroupExpression6<C, L, C2>,
    L extends RepositoryExecutableConditionsGroupLogicExpression6<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
    extends Executor, RepositoryConditionsGroupLogicExpression6<C, L> {

}
