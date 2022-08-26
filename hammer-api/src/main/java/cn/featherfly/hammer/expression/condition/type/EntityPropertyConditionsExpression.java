
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyConditionsExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends EntityPropertyExpression<E, C, L> {

}
