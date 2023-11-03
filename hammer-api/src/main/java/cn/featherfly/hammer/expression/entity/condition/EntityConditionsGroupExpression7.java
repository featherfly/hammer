
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression7.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 * @param <T7> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression7<T, T2, T3, T4, T5, T6, T7,
        C extends EntityConditionsGroupExpression7<T, T2, T3, T4, T5, T6, T7, C, L>,
        L extends EntityConditionsGroupLogicExpression7<T, T2, T3, T4, T5, T6, T7, C, L>>
        extends EntityConditionsExpression7<T, T2, T3, T4, T5, T6, T7, C, L>, GroupExpression<C, L> {
}
