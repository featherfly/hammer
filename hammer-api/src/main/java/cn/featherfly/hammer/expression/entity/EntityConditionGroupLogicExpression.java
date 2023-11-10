
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupLogicExpression;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
//ENHANCE 这一层次接口是否需要删除
public interface EntityConditionGroupLogicExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
    L extends EntityConditionGroupLogicExpression<E, C, L>> extends EntityConditionsGroupLogicExpression<E, C, L> {
}
