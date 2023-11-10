
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * set value in or not in expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface SetValueInOrNotInExpression<V> {

    /**
     * Value.
     *
     * @param value the value
     * @return LogicExpression
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V value, Predicate<V> ignoreStrategy);

    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    void value(int value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(int value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    void value(long value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(long value, Predicate<Long> ignoreStrategy);

    /**
     * Value,.
     *
     * @param value values with Array
     * @return LogicExpression
     */
    void value(@SuppressWarnings("unchecked") V... value);

    //    /**
    //     * Value,.
    //     *
    //     * @param value values with Array
    //     * @return LogicExpression
    //     */
    //    void value(int... value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value values with Array
    //     * @return LogicExpression
    //     */
    //    void value(long... value);

    /**
     * Value,.
     *
     * @param value          values with Array
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V[] value, Predicate<V[]> ignoreStrategy);

    //    /**
    //     * Value,.
    //     *
    //     * @param value        values with Array
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(int[] value, Predicate<int[]> ignoreStrategy);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value        values with Array
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * Value,.
     *
     * @param value values with Collection
     * @return LogicExpression
     */
    void value(Collection<V> value);

    /**
     * Value,.
     *
     * @param value          values with Collection
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(Collection<V> value, Predicate<Collection<V>> ignoreStrategy);
}
