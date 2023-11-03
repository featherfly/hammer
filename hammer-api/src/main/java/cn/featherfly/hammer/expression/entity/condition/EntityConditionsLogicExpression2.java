
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsLogicExpression2<T, T2, C extends EntityConditionsExpression2<T, T2, C, L>,
        L extends EntityConditionsLogicExpression2<T, T2, C, L>> extends GroupEndExpression<C, L> {
}
