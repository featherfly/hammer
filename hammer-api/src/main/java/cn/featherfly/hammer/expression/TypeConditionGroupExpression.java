
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.TypeConditionsGroupExpression;

/**
 * <p>
 * ConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public interface TypeConditionGroupExpression<C extends TypeConditionGroupExpression<C, L>,
        L extends TypeConditionGroupLogicExpression<C, L>>
        extends ConditionGroupExpression<C, L>, TypeConditionsGroupExpression<C, L> {

}
