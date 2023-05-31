
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.api.Where;

/**
 * The Interface EntityWhereExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityWhereExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends Where<C, L> {

}
