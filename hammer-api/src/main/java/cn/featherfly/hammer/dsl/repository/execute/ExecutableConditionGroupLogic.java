
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.ExecutableConditionGroupLogicExpression;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogic<C extends ExecutableConditionConfig<C>> extends Executor,
        ExecutableConditionGroupLogicExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C> {

}
