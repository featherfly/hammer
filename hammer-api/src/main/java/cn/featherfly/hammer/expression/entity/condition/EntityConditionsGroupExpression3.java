
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression3.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression3<T, T2, T3,
        C extends EntityConditionsGroupExpression3<T, T2, T3, C, L>,
        L extends EntityConditionsGroupLogicExpression3<T, T2, T3, C, L>>
        extends EntityConditionsExpression3<T, T2, T3, C, L>, GroupExpression<C, L> {
}
