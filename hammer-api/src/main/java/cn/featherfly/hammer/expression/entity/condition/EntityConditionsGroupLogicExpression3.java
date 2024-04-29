
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupLogicExpression3<E1, E2, E3,
    C extends EntityConditionsGroupExpression3<E1, E2, E3, C, L>,
    L extends EntityConditionsGroupLogicExpression3<E1, E2, E3, C, L>> extends GroupEndExpression<C, L> {
}
