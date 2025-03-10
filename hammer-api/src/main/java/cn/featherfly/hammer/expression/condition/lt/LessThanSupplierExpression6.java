
package cn.featherfly.hammer.expression.condition.lt;

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
 * less than supplier expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessThanSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableIntSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableLongSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableDoubleSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @return LogicExpression
     */
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <D extends Date> L lt6(SerializableDateSupplier<D> property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt6(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt6(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableLocalTimeSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateTimeSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property) {
        return lt6(property, property.get());
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt6(property, property.get(), ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt6(property, property.get(), matchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lt6(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt6(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableIntSupplier property, int value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableLongSupplier property, long value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableDoubleSupplier property, double value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, E value);

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt6(SerializableNumberSupplier<N> property, N value);

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt6(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt6(SerializableDateSupplier<D> property, D value);

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt6(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt6(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, String value) {
        return lt6(property, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lt6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lt6(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}