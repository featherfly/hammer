
package cn.featherfly.hammer.expression.entity.condition.nba;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityPropertyExpression;

/**
 * The Interface NotBetweenEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface NotBetweenEntityPropertyExpression<V>
        extends BetweenAndEntityPropertyExpression<V>, NotBetweenEntityValuePropertyExpression<V> {
}
