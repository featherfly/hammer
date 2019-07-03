
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.expression.ConditionLogicExpression;
import cn.featherfly.juorm.expression.execute.Executor;

/**
 * <p>
 * ConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableConditionLogicExpression extends Executor,
        ConditionLogicExpression<ExecutableConditionExpression, ExecutableConditionLogicExpression> {
}
