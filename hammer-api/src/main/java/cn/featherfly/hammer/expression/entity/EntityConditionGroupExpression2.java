
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression2;

/**
 * The Interface EntityConditionGroupExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupExpression2<E1, E2, C extends EntityConditionGroupExpression2<E1, E2, C, L>,
    L extends EntityConditionGroupLogicExpression2<E1, E2, C, L>>
    extends EntityConditionsGroupExpression2<E1, E2, C, L> {
}
