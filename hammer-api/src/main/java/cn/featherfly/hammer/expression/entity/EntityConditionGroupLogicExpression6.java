
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupLogicExpression6;

/**
 * The Interface EntityConditionGroupLogicExpression6.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <E6> sixth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    L extends EntityConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L>>
    extends EntityConditionsGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L> {

}
