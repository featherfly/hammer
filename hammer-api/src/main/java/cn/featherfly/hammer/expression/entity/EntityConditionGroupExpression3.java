
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression3;

/**
 * The Interface EntityConditionGroupExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupExpression3<E1, E2, E3,
    C extends EntityConditionGroupExpression3<E1, E2, E3, C, L>,
    L extends EntityConditionGroupLogicExpression3<E1, E2, E3, C, L>>
    extends EntityConditionsGroupExpression3<E1, E2, E3, C, L> {
}
