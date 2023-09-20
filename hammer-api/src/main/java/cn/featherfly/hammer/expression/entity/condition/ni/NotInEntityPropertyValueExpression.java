
package cn.featherfly.hammer.expression.entity.condition.ni;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * The Interface NotInEntityPropertyValueExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface NotInEntityPropertyValueExpression<E, V> {

    //    /**
    //     * entity not in function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity not in function property expression.
    //     */
    //    <R> EntityNotInFunctionPropertyValueExpression<V, R, C, L> property(SerializableFunction<V, R> name);

    /**
     * Value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V value, Predicate<V> ignoreStrategy);

    //    /**
    //     * Value,.
    //     *
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void value(int value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(int value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void value(long value);
    //
    //    /**
    //     * Value,.
    //     *
    //     * @param value        参数值
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
     * @param value        values with Array
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
     * @param value        values with Collection
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(Collection<V> value, Predicate<Collection<V>> ignoreStrategy);
}
