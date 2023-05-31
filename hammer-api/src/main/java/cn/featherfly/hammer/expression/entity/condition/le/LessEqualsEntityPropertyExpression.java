
package cn.featherfly.hammer.expression.entity.condition.le;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;

/**
 * The Interface LessEqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface LessEqualsEntityPropertyExpression<V>
        extends CompareEntityPropertyExpression<V>, LessEqualsEntityValuePropertyExpression<V> {

}
