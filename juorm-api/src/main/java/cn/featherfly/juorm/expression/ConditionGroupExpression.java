
package cn.featherfly.juorm.expression;

import cn.featherfly.juorm.expression.condition.ConditionsGroupExpression;

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
