
package cn.featherfly.hammer.expression.entity.compatible;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * entity conditions group expression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupCompatibleExpression<E1, C extends EntityConditionsGroupCompatibleExpression<E1, C, L>,
    L extends EntityConditionsGroupLogicCompatibleExpression<E1, C, L>>
    extends EntityConditionsCompatibleExpression<E1, C, L>, GroupExpression<C, L> {
}
