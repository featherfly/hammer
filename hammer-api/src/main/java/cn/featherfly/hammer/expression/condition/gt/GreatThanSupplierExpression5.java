
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
 * great than supplier expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableIntSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableLongSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableDoubleSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @return LogicExpression
     */
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <D extends Date> L gt5(SerializableDateSupplier<D> property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt5(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt5(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableLocalTimeSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateTimeSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property) {
        return gt5(property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt5(property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt5(property, property.get(), matchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return gt5(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt5(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableIntSupplier property, int value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableLongSupplier property, long value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableDoubleSupplier property, double value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, E value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L gt5(SerializableNumberSupplier<N> property, N value);

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L gt5(SerializableDateSupplier<D> property, D value);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt5(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, String value) {
        return gt5(property, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L gt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return gt5(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    L gt5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}