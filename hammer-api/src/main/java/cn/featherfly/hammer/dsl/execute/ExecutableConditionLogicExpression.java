
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * <p>
 * ConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableConditionLogicExpression
        extends Executor, ConditionLogicExpression<ExecutableConditionExpression, ExecutableConditionLogicExpression> {
}
