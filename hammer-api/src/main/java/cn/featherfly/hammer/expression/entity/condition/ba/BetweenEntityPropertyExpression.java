
package cn.featherfly.hammer.expression.entity.condition.ba;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityPropertyExpression;

/**
 * The Interface BetweenEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface BetweenEntityPropertyExpression<V>
        extends BetweenAndEntityPropertyExpression<V>, BetweenEntityValuePropertyExpression<V> {
}
