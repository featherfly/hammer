
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsLogicExpression2<E1, E2, C extends EntityConditionsExpression2<E1, E2, C, L>,
    L extends EntityConditionsLogicExpression2<E1, E2, C, L>> extends GroupEndExpression<C, L> {
}
