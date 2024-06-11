
package cn.featherfly.hammer.expression.condition.eq;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.serializable.SerializableBoolSupplier;
import cn.featherfly.common.function.serializable.SerializableBooleanSupplier;
import cn.featherfly.common.function.serializable.SerializableCharSupplier;
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * equals supplier expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableBooleanSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableCharSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableIntSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableLongSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableDoubleSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableBoolSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableBoolSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <N extends Number> L eq(SerializableNumberSupplier<N> propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(SerializableNumberSupplier<N> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <D extends Date> L eq(SerializableDateSupplier<D> propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(SerializableDateSupplier<D> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(SerializableDateSupplier<D> propertyValue, Predicate<D> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableLocalTimeSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateTimeSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return eq(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue) {
        return eq(propertyValue, propertyValue.get());
    }

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableBooleanSupplier property, boolean value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableCharSupplier property, char value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableIntSupplier property, int value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableLongSupplier property, long value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableDoubleSupplier property, double value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableBoolSupplier property, Boolean value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableBoolSupplier property, Boolean value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<Boolean>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L eq(SerializableNumberSupplier<N> property, N value);

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L eq(SerializableDateSupplier<D> property, D value);

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value);

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier property, String value) {
        return eq(property, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return eq(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return eq(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return eq(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L eq(SerializableSupplier<R> property, R value);

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, R value,
        IgnoreStrategy ignoreStrategy) {
        return eq(propertyValue, value, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, R value, Predicate<R> ignoreStrategy);
}