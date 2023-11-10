
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsLogicExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends EntityConditionsLogicExpression<E, C, L>> extends GroupEndExpression<C, L> {
}
