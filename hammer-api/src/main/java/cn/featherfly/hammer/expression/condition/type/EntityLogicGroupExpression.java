
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLogicGroupExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends EntityLogicGroupExpression<E, C, L>> extends LogicExpression<C, L>, GroupEndExpression<L> {
}
