
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsLogicExpression<E1, C extends EntityConditionsExpression<E1, C, L>,
    L extends EntityConditionsLogicExpression<E1, C, L>> extends GroupEndExpression<C, L> {
}
