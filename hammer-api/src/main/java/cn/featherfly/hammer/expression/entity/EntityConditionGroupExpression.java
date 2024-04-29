
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;

/**
 * The Interface EntityConditionGroupExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
// ENHANCE 这一层次接口是否需要删除
public interface EntityConditionGroupExpression<E1, C extends EntityConditionGroupExpression<E1, C, L>,
    L extends EntityConditionGroupLogicExpression<E1, C, L>> extends EntityConditionsGroupExpression<E1, C, L> {
}
