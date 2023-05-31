
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsGroupExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression3<E, E2, E3,
        C extends EntityConditionsGroupExpression3<E, E2, E3, C, L>, L extends LogicExpression<C, L>>
        extends EntityConditionsExpression3<E, E2, E3, C, L>, GroupExpression<C, L> {
}
