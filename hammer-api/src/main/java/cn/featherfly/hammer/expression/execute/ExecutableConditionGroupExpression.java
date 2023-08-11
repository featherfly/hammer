
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;

/**
 * executable condition group expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupExpression<C extends ExecutableConditionGroupExpression<C, L>,
        L extends ExecutableConditionGroupLogicExpression<C, L>> extends ConditionGroupExpression<C, L> {
}
