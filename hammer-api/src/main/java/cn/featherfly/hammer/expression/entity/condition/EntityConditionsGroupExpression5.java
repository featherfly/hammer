
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression5.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression5<T, T2, T3, T4, T5,
        C extends EntityConditionsGroupExpression5<T, T2, T3, T4, T5, C, L>,
        L extends EntityConditionsGroupLogicExpression5<T, T2, T3, T4, T5, C, L>>
        extends EntityConditionsExpression5<T, T2, T3, T4, T5, C, L>, GroupExpression<C, L> {
}
