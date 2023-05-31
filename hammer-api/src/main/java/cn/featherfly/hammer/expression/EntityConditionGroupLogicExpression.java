
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.type.EntityLogicGroupExpression;

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
