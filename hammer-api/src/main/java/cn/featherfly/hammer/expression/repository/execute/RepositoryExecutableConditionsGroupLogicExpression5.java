
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression5;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogicExpression5<
        C extends RepositoryExecutableConditionsGroupExpression5<C, L, C2>,
        L extends RepositoryExecutableConditionsGroupLogicExpression5<C, L, C2>,
        C2 extends ExecutableConditionConfig<C2>> extends Executor, RepositoryConditionsGroupLogicExpression5<C, L> {

}
