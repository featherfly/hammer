
package cn.featherfly.hammer.expression.condition.ne;

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
 * muliti not equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <R> L ne(int index, String name, R value) {
        return ne(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <R> L ne(int index, String name, R value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, String name, R value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, String name, R value, Predicate<R> ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, String name, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, matchStrategy, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(int index, String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, int value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, long value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, double value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne(int index, String name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, String name, N value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne(int index, String name, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(int index, String name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, String name, E value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(int index, String name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne(int index, String name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, String name, D value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne(int index, String name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, String name, String value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T, R> L ne(int index, SerializableFunction<T, R> name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L ne(int index, SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L ne(int index, SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T, R> L ne(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L ne(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, matchStrategy, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the element type
     * @param <R> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L ne(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
        Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToIntFunction<T> name, int value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLongFunction<T> name, long value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToDoubleFunction<T> name, double value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToStringFunction<T> name, String value);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(int index, SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <R> L ne(int index, SerializableSupplier<R> property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R> L ne(int index, SerializableSupplier<R> property, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, SerializableSupplier<R> property, R value, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(int index, SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableIntSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableIntSupplier property, int value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableLongSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableLongSupplier property, long value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableDoubleSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableDoubleSupplier property, double value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, SerializableDateSupplier<D> property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne(int index, SerializableDateSupplier<D> property, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, SerializableDateSupplier<D> property, D value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne(int index, SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, SerializableNumberSupplier<N> property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, N value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, E value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalDateSupplier property, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalTimeSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateTimeSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property) {
        return ne(index, property, property.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, String value) {
        return ne(index, property, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ne(index, property, property.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ne(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ne(index, property, property.get(), matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value, MatchStrategy matchStrategy) {
        return ne(index, field.name(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value, Predicate<R> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, Field field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, int value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, long value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, double value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, Field field, N value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, Field field, N value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, Field field, N value, Predicate<N> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, Field field, E value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, Field field, E value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, Field field, E value, Predicate<E> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, Field field, D value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, Field field, D value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, Field field, D value, Predicate<D> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalTime value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDate value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDateTime value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value) {
        return ne(index, field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return ne(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value, MatchStrategy matchStrategy) {
        return ne(index, field.name(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value, MatchStrategy matchStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value, Predicate<R> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, AliasField field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, int value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, long value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, double value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, AliasField field, N value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne(int index, AliasField field, N value, Predicate<N> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, AliasField field, E value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne(int index, AliasField field, E value, Predicate<E> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, AliasField field, D value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne(int index, AliasField field, D value, Predicate<D> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalTime value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDate value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDateTime value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value) {
        return ne(index, field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(int index, AliasField field, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}