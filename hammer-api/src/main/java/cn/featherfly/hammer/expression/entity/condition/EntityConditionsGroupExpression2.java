
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsGroupExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsGroupExpression2<E, E2, C extends EntityConditionsGroupExpression2<E, E2, C, L>,
        L extends LogicExpression<C, L>> extends EntityConditionsExpression2<E, E2, C, L>, GroupExpression<C, L> {
}
