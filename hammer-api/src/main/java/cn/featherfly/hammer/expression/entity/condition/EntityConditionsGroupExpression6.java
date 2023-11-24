
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression6.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression6<T, T2, T3, T4, T5, T6,
        C extends EntityConditionsGroupExpression6<T, T2, T3, T4, T5, T6, C, L>,
        L extends EntityConditionsGroupLogicExpression6<T, T2, T3, T4, T5, T6, C, L>>
        extends EntityConditionsExpression6<T, T2, T3, T4, T5, T6, C, L>, GroupExpression<C, L> {
}
