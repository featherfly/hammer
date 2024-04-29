
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupLogicExpression2;

/**
 * The Interface EntityConditionGroupLogicExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupLogicExpression2<E1, E2, C extends EntityConditionGroupExpression2<E1, E2, C, L>,
    L extends EntityConditionGroupLogicExpression2<E1, E2, C, L>>
    extends EntityConditionsGroupLogicExpression2<E1, E2, C, L> {
}
