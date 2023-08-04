
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityLogicGroupExpression;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionGroupLogicExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends EntityLogicGroupExpression<E, C, L> {
}
