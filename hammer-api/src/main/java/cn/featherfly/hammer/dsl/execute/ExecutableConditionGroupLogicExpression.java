
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * <p>
 * ConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogicExpression extends Executor,
        ConditionGroupLogicExpression<ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression> {

}
