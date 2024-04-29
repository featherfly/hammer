
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression4;

/**
 * The Interface EntityConditionGroupExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionGroupExpression4<E1, E2, E3, E4,
    C extends EntityConditionGroupExpression4<E1, E2, E3, E4, C, L>,
    L extends EntityConditionGroupLogicExpression4<E1, E2, E3, E4, C, L>>
    extends EntityConditionsGroupExpression4<E1, E2, E3, E4, C, L> {
}
