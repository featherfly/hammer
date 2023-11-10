
package cn.featherfly.hammer.expression.condition.eq;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface MulitiEntityEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <R> L eq(int index, String name, R value) {
        return eq(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <R> L eq(int index, String name, R value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, String name, R value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, String name, R value, Predicate<R> ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, String name, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, matchStrategy, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(int index, String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, int value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, long value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, double value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L eq(int index, String name, N value);

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, String name, N value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq(int index, String name, N value, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(int index, String name, E value);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, String name, E value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(int index, String name, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L eq(int index, String name, D value);

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, String name, D value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq(int index, String name, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(int index, String name, String value);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, R> L eq(int index, SerializableFunction<T, R> name, R value);

    /**
     * equals. 等于.
     *
     * @param <T>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L eq(int index, SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L eq(int index, SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <T>           the element type
     * @param <R>           the generic type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T, R> L eq(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L eq(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, matchStrategy, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L eq(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToIntFunction<T> name, int value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLongFunction<T> name, long value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToDoubleFunction<T> name, double value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, N extends Number> L eq(int index, SerializableToNumberFunction<T, N> name, N value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L eq(int index, SerializableToNumberFunction<T, N> name, N value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L eq(int index, SerializableToNumberFunction<T, N> name, N value,
            Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L eq(int index, SerializableToEnumFunction<T, E> name, E value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L eq(int index, SerializableToEnumFunction<T, E> name, E value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L eq(int index, SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, D extends Date> L eq(int index, SerializableToDateFunction<T, D> name, D value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L eq(int index, SerializableToDateFunction<T, D> name, D value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L eq(int index, SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L eq(int index, SerializableToLocalTimeFunction<T> name, LocalTime value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L eq(int index, SerializableToLocalDateFunction<T> name, LocalDate value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L eq(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToStringFunction<T> name, String value);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L eq(int index, SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>           the generic type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L eq(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L eq(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R> L eq(int index, SerializableSupplier<R> property);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableIntSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableLongSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableDoubleSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L eq(int index, SerializableDateSupplier<D> property);

    /**
     * equals. 等于.
     *
     * @param <D>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq(int index, SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L eq(int index, SerializableNumberSupplier<N> property);

    /**
     * equals. 等于.
     *
     * @param <N>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq(int index, SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>      the element type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(int index, SerializableEnumSupplier<E> property);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalDateSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalTimeSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalDateTimeSupplier property);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L eq(int index, SerializableStringSupplier property) {
        return eq(index, property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return eq(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return eq(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index         the index
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(int index, SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value, MatchStrategy matchStrategy) {
        return eq(index, field.name(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value, Predicate<R> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, Field field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, int value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, long value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, double value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, Field field, N value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, Field field, N value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, Field field, N value, Predicate<N> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, Field field, E value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, Field field, E value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, Field field, E value, Predicate<E> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, Field field, D value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, Field field, D value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, Field field, D value, Predicate<D> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalTime value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDate value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDateTime value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value) {
        return eq(index, field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return eq(index, field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value, MatchStrategy matchStrategy) {
        return eq(index, field.name(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value, MatchStrategy matchStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value, Predicate<R> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, AliasField field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, int value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, long value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, double value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, AliasField field, N value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(int index, AliasField field, N value, Predicate<N> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, AliasField field, E value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(int index, AliasField field, E value, Predicate<E> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, AliasField field, D value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(int index, AliasField field, D value, Predicate<D> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalTime value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDate value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDateTime value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value) {
        return eq(index, field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return eq(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}