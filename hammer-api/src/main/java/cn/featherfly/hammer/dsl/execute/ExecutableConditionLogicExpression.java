
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * executable condition logic expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionLogicExpression
        extends Executor, ConditionLogicExpression<ExecutableConditionExpression, ExecutableConditionLogicExpression> {
}
