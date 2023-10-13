
package cn.featherfly.hammer.expression.entity.condition.lt;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;

/**
 * The Interface LessThanEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface LessThanEntityPropertyExpression<V>
        extends CompareEntityPropertyExpression<V>, LessThanEntityValuePropertyExpression<V> {

}
