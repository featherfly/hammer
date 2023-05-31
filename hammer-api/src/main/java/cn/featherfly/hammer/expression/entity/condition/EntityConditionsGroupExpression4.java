
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsGroupExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression4<E, E2, E3, E4,
        C extends EntityConditionsGroupExpression4<E, E2, E3, E4, C, L>, L extends LogicExpression<C, L>>
        extends EntityConditionsExpression4<E, E2, E3, E4, C, L>, GroupExpression<C, L> {
}
