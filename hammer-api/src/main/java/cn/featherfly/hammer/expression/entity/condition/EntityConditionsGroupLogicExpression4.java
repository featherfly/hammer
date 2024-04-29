
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupLogicExpression4<E1, E2, E3, E4,
    C extends EntityConditionsGroupExpression4<E1, E2, E3, E4, C, L>,
    L extends EntityConditionsGroupLogicExpression4<E1, E2, E3, E4, C, L>> extends GroupEndExpression<C, L> {

}
