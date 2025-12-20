
package cn.featherfly.hammer.expression.entity.compatible;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsLogicCompatibleExpression<E1, C extends EntityConditionsCompatibleExpression<E1, C, L>,
    L extends EntityConditionsLogicCompatibleExpression<E1, C, L>> extends GroupEndExpression<C, L> {
}
