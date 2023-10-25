
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogic<C extends ExecutableConditionConfig<C>> extends Executor,
        ExecutableConditionGroupLogicExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C> {

}
