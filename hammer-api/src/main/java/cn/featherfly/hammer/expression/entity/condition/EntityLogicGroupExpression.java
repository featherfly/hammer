
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLogicGroupExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends EntityLogicGroupExpression<E, C, L>> extends LogicExpression<C, L>, GroupEndExpression<C, L> {
}
