
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyLessThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface PropertyLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 小于.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(V value);
}