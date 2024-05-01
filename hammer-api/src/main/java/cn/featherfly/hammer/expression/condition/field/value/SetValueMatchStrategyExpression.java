
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * set value match strategy expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface SetValueMatchStrategyExpression<V> extends SetValueExpression<V> {

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(V value) {
        value(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(V value, Predicate<V> ignoreStrategy) {
        value(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    void value(V value, MatchStrategy matchStrategy);

    /**
     * Value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void value(V value, MatchStrategy matchStrategy, Predicate<V> ignoreStrategy);
}
