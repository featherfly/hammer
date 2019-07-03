
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.execute.Executor;

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
