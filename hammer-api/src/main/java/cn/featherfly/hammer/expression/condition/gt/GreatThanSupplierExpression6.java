
package cn.featherfly.hammer.expression.condition.gt;

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
 * great than supplier expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableIntSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableLongSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableDoubleSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @return LogicExpression
     */
    default <N extends Number> L gt6(SerializableNumberSupplier<N> property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt6(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt6(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <D extends Date> L gt6(SerializableDateSupplier<D> property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt6(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt6(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableLocalTimeSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateTimeSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property) {
        return gt6(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt6(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt6(property, property.get(), matchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return gt6(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt6(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableIntSupplier property, int value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableLongSupplier property, long value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableDoubleSupplier property, double value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, E value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt6(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt6(SerializableNumberSupplier<N> property, N value);

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt6(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt6(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt6(SerializableDateSupplier<D> property, D value);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt6(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt6(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, String value) {
        return gt6(property, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L gt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return gt6(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}