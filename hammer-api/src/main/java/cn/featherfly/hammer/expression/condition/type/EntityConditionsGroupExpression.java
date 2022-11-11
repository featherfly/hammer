
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsGroupExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends EntityConditionsExpression<E, C, L>, GroupExpression<C, L> {
}
