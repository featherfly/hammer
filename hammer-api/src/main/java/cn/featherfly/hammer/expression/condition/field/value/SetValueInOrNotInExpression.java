
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * set value in or not in expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface SetValueInOrNotInExpression<V> {

    /**
     * Value.
     *
     * @param value the value
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void value(V value, Predicate<V> ignoreStrategy);

    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     *
    //     */
    //    void value(int value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     *
    //     */
    //    void value(int value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     *
    //     */
    //    void value(long value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     *
    //     */
    //    void value(long value, Predicate<Long> ignoreStrategy);

    /**
     * Value,.
     *
     * @param value values with Array
     */
    void value(@SuppressWarnings("unchecked") V... value);

    //    /**
    //     * Value,.
    //     *
    //     * @param value values with Array
    //     *
    //     */
    //    void value(int... value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value values with Array
    //     *
    //     */
    //    void value(long... value);

    /**
     * Value,.
     *
     * @param value          values with Array
     * @param ignoreStrategy the ignore strategy
     */
    void value(V[] value, Predicate<V[]> ignoreStrategy);

    //    /**
    //     * Value,.
    //     *
    //     * @param value        values with Array
    //     * @param ignoreStrategy the ignore strategy
    //     *
    //     */
    //    void value(int[] value, Predicate<int[]> ignoreStrategy);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value        values with Array
    //     * @param ignoreStrategy the ignore strategy
    //     *
    //     */
    //    void value(long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * Value,.
     *
     * @param value values with Collection
     */
    void value(Collection<V> value);

    /**
     * Value,.
     *
     * @param value          values with Collection
     * @param ignoreStrategy the ignore strategy
     */
    void value(Collection<V> value, Predicate<Collection<V>> ignoreStrategy);
}
