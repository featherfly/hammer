
package cn.featherfly.hammer.expression.condition.le;

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
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * less equals supplier expression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface LessEqualsSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableIntSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableLongSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableDoubleSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L le(SerializableEnumSupplier<E> property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @return LogicExpression
     */
    default <N extends Number> L le(SerializableNumberSupplier<N> property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <D extends Date> L le(SerializableDateSupplier<D> property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableLocalTimeSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableLocalDateSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableLocalDateTimeSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property) {
        return le(property, property.get());
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(property, property.get(), ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return le(property, property.get(), matchStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return le(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableIntSupplier property, int value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableLongSupplier property, long value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableDoubleSupplier property, double value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, E value);

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, String value) {
        return le(property, value, MatchStrategy.AUTO);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return le(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return le(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return le(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}