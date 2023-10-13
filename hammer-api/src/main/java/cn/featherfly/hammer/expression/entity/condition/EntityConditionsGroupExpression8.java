
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsGroupExpression8.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <E8> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression8<E, E2, E3, E4, E5, E6, E7, E8,
        C extends EntityConditionsGroupExpression8<E, E2, E3, E4, E5, E6, E7, E8, C, L>,
        L extends LogicExpression<C, L>>
        extends EntityConditionsExpression8<E, E2, E3, E4, E5, E6, E7, E8, C, L>, GroupExpression<C, L> {
}