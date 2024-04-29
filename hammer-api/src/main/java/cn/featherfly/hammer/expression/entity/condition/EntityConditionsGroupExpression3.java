
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * The Interface EntityConditionsGroupExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupExpression3<E1, E2, E3,
    C extends EntityConditionsGroupExpression3<E1, E2, E3, C, L>,
    L extends EntityConditionsGroupLogicExpression3<E1, E2, E3, C, L>>
    extends EntityConditionsExpression3<E1, E2, E3, C, L>, GroupExpression<C, L> {
}
