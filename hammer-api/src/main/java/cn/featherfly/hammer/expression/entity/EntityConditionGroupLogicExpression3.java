
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupLogicExpression3;

/**
 * The Interface EntityConditionGroupLogicExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupLogicExpression3<E1, E2, E3,
    C extends EntityConditionGroupExpression3<E1, E2, E3, C, L>,
    L extends EntityConditionGroupLogicExpression3<E1, E2, E3, C, L>>
    extends EntityConditionsGroupLogicExpression3<E1, E2, E3, C, L> {

}
