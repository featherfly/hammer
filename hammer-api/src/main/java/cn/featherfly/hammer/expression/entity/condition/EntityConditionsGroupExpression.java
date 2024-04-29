
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * entity conditions group expression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupExpression<E1, C extends EntityConditionsGroupExpression<E1, C, L>,
    L extends EntityConditionsGroupLogicExpression<E1, C, L>>
    extends EntityConditionsExpression<E1, C, L>, GroupExpression<C, L> {
}
