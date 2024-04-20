
package cn.featherfly.hammer.expression.execute;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * update value .
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface UpdateValueExpressionBase<T, U, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * Sets the.
     *
     * @param value the value
     * @return the u
     */
    U set(T value);

    /**
     * Sets the.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    default U set(T value, IgnoreStrategy ignoreStrategy) {
        return set(value, ignoreStrategy::test);
    }

    /**
     * Sets the.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    U set(T value, Predicate<T> ignoreStrategy);
}
