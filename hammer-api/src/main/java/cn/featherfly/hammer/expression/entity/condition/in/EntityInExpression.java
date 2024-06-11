
package cn.featherfly.hammer.expression.entity.condition.in;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.in.InSupplierExpression;

/**
 * The Interface EntityInExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityInExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression, InSupplierExpression<C, L> {

    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L in(SerializableFunction<T, R> name, R value);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>            the generic type
    //     * @param name           the name
    //     * @param value          the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L in(SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
    //        return in(name, value, ignoreStrategy::test);
    //    }
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>            the generic type
    //     * @param name           the name
    //     * @param value          the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L in(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L in(SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in(SerializableFunction<T, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in(SerializableFunction<T, R> name, Collection<R> value,
        IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in(SerializableFunction<T, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in(SerializableFunction<T, R> name, R[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L in(SerializableFunction<T, N> name, N value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L in(SerializableFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L in(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L in(SerializableFunction<T, N> name, N[] value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L in(SerializableFunction<T, N> name, N[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <N> the number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L in(SerializableFunction<T, N> name, N[] value, Predicate<N[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableFunction<T, Integer> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableFunction<T, Integer> name, int[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableFunction<T, Integer> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableFunction<T, Long> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableFunction<T, Long> name, long[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableFunction<T, Long> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L in(SerializableFunction<T, D> name, D value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L in(SerializableFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L in(SerializableFunction<T, D> name, @SuppressWarnings("unchecked") D... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L in(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L in(SerializableFunction<T, D> name, D[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <D> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L in(SerializableFunction<T, D> name, D[] value, Predicate<D[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L in(SerializableFunction<T, E> name, E value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L in(SerializableFunction<T, E> name, E value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L in(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L in(SerializableFunction<T, E> name, @SuppressWarnings("unchecked") E... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L in(SerializableFunction<T, E> name, E[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L in(SerializableFunction<T, E> name, E[] value, Predicate<E[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalDateTimeFunction<T> name, LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalDateFunction<T> name, LocalDate... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalDateFunction<T> name, LocalDate[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalDateFunction<T> name, LocalDate[] value, Predicate<LocalDate[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLocalTimeFunction<T> name, LocalTime... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToLocalTimeFunction<T> name, LocalTime[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLocalTimeFunction<T> name, LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToStringFunction<T> name, String[] value, IgnoreStrategy ignoreStrategy) {
        return in(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String value[], Predicate<String[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return in(name, value, matchStrategy, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return in(name, value, matchStrategy, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToIntFunction<T> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToIntFunction<T> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLongFunction<T> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToLongFunction<T> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToDoubleFunction<T> name, double value);

    /**
     * values in. 包含指定，sql中的in. * @param name the name
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in(SerializableToDoubleFunction<T> name, double... value);

    /**
     * values in. 包含指定，sql中的in. * @param name the name
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(SerializableToDoubleFunction<T> name, double[] value, Predicate<double[]> ignoreStrategy);
}