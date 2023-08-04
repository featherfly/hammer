
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLogicGroupExpression3<E, E2, E3, C extends EntityConditionsGroupExpression3<E, E2, E3, C, L>,
        L extends EntityLogicGroupExpression3<E, E2, E3, C, L>>
        extends LogicExpression<C, L>, GroupEndExpression<C, L> {
}
