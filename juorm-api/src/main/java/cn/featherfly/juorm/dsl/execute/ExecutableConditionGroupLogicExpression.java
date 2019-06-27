
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.ConditionGroupLogicExpression;

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
