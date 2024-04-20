
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogicExpression<C extends ExecutableConditionGroupExpression<C, L, C2>,
        L extends ExecutableConditionGroupLogicExpression<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
        extends Executor, RepositoryConditionsGroupLogicExpression<C, L> {

}
