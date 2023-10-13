
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLogicGroupExpression6<E, E2, E3, E4, E5, E6,
        C extends EntityConditionsGroupExpression6<E, E2, E3, E4, E5, E6, C, L>,
        L extends EntityLogicGroupExpression6<E, E2, E3, E4, E5, E6, C, L>>
        extends LogicExpression<C, L>, GroupEndExpression<C, L> {
}
