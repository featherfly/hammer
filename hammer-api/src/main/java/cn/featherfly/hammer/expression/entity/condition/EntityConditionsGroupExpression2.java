
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupExpression2<E1, E2, C extends EntityConditionsGroupExpression2<E1, E2, C, L>,
    L extends EntityConditionsGroupLogicExpression2<E1, E2, C, L>>
    extends EntityConditionsExpression2<E1, E2, C, L>, GroupExpression<C, L> {
}
