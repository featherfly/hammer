
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogic extends Executor,
        ExecutableConditionGroupLogicExpression<ExecutableConditionGroup, ExecutableConditionGroupLogic> {

}
