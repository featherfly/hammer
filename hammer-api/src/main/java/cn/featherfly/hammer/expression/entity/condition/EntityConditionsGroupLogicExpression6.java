
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression6.
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
public interface EntityConditionsGroupLogicExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityConditionsGroupExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    L extends EntityConditionsGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L>> extends GroupEndExpression<C, L> {
}
