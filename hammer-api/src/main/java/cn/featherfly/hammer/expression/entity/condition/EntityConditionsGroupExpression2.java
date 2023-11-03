
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression2.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression2<T, T2, C extends EntityConditionsGroupExpression2<T, T2, C, L>,
        L extends EntityConditionsGroupLogicExpression2<T, T2, C, L>>
        extends EntityConditionsExpression2<T, T2, C, L>, GroupExpression<C, L> {
}
