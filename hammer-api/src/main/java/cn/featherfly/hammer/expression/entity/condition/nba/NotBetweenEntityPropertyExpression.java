
package cn.featherfly.hammer.expression.entity.condition.nba;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityPropertyExpression;

/**
 * The Interface NotBetweenEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotBetweenEntityPropertyExpression<E>
        extends BetweenAndEntityPropertyExpression<E>, NotBetweenEntityValuePropertyExpression<E> {
}
