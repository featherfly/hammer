
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsGroupExpression<T, C extends EntityConditionsGroupExpression<T, C, L>,
        L extends EntityLogicGroupExpression<T, C, L>>
        extends EntityConditionsExpression<T, C, L>, GroupExpression<C, L> {
}
