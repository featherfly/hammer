
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionsGroupExpression;

/**
 * <p>
 * ConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends ConditionsGroupExpression<C, L> {

}
