
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface PropertyNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L ne(V value);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(V value, IgnoreStrategy ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(V value, Predicate<V> ignoreStrategy);
}