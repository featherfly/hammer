
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression4.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression4<T, T2, T3, T4,
        C extends EntityConditionsGroupExpression4<T, T2, T3, T4, C, L>,
        L extends EntityConditionsGroupLogicExpression4<T, T2, T3, T4, C, L>>
        extends EntityConditionsExpression4<T, T2, T3, T4, C, L>, GroupExpression<C, L> {
}
