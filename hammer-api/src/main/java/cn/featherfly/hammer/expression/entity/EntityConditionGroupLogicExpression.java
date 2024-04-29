
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupLogicExpression;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
//ENHANCE 这一层次接口是否需要删除
public interface EntityConditionGroupLogicExpression<E1, C extends EntityConditionGroupExpression<E1, C, L>,
    L extends EntityConditionGroupLogicExpression<E1, C, L>> extends EntityConditionsGroupLogicExpression<E1, C, L> {
}
