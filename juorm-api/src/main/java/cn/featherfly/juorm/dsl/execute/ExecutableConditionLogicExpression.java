
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.ConditionLogicExpression;

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
