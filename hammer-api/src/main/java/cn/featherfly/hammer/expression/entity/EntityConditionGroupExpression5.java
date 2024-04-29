
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression5;

/**
 * The Interface EntityConditionGroupExpression5.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupExpression5<E1, E2, E3, E4, E5,
    C extends EntityConditionGroupExpression5<E1, E2, E3, E4, E5, C, L>,
    L extends EntityConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L>>
    extends EntityConditionsGroupExpression5<E1, E2, E3, E4, E5, C, L> {
}
