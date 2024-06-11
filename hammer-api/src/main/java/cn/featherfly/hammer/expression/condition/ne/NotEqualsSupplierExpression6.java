
package cn.featherfly.hammer.expression.condition.ne;

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
 * not equals supplier expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableBooleanSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableCharSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableIntSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableLongSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableDoubleSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableBoolSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableBoolSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <N extends Number> L ne6(SerializableNumberSupplier<N> propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne6(SerializableNumberSupplier<N> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne6(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <D extends Date> L ne6(SerializableDateSupplier<D> propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne6(SerializableDateSupplier<D> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne6(SerializableDateSupplier<D> propertyValue, Predicate<D> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableLocalTimeSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateTimeSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return ne6(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    default <R extends Serializable> L ne6(SerializableSupplier<R> propertyValue) {
        return ne6(propertyValue, propertyValue.get());
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne6(SerializableSupplier<R> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne6(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return ne6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableBooleanSupplier property, boolean value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableCharSupplier property, char value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableIntSupplier property, int value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableLongSupplier property, long value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableDoubleSupplier property, double value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableBoolSupplier property, Boolean value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableBoolSupplier property, Boolean value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<Boolean>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne6(SerializableNumberSupplier<N> property, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne6(SerializableNumberSupplier<N> property, N value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne6(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne6(SerializableDateSupplier<D> property, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne6(SerializableDateSupplier<D> property, D value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <D> the generic type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne6(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> property, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> property, E value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne6(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableLocalDateSupplier property, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateSupplier property, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalTimeSupplier property, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L ne6(SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableLocalDateTimeSupplier property, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableLocalDateTimeSupplier property, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier property, String value) {
        return ne6(property, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ne6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne6(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ne6(SerializableSupplier<R> property, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne6(SerializableSupplier<R> propertyValue, R value,
        IgnoreStrategy ignoreStrategy) {
        return ne6(propertyValue, value, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param propertyValue the propertyValue value
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ne6(SerializableSupplier<R> propertyValue, R value, Predicate<R> ignoreStrategy);
}