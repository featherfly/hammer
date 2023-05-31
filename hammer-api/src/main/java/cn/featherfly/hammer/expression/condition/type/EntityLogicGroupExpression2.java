
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLogicGroupExpression2<E, E2, C extends EntityConditionsGroupExpression2<E, E2, C, L>,
        L extends EntityLogicGroupExpression2<E, E2, C, L>> extends LogicExpression<C, L>, GroupEndExpression<L> {
}
