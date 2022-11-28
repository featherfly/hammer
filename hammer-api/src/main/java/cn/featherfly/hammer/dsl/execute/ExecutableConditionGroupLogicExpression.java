
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogicExpression extends Executor,
        ConditionGroupLogicExpression<ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression> {

}
