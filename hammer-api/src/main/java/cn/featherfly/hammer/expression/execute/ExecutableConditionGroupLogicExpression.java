
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogicExpression<C extends ExecutableConditionGroupExpression<C, L>,
        L extends ExecutableConditionGroupLogicExpression<C, L>> extends Executor, ConditionGroupLogicExpression<C, L> {

}
