
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-14 15:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field;

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
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;

/**
 * compare supplier expression.
 *
 * @author zhongj
 */
public interface CompareSupplierExpression extends IgnorableExpression {

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableIntSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableLongSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableDoubleSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D> the generic type
     * @param property bean property
     */
    default <D extends Date> void accept(SerializableDateSupplier<D> property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param <D> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <N> the generic type
     * @param property bean property
     */
    default <N extends Number> void accept(SerializableNumberSupplier<N> property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param <N> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableLocalDateSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableLocalTimeSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableLocalDateTimeSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     */
    default void accept(SerializableStringSupplier property) {
        accept(property, property.get());
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        accept(property, property.get(), ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        accept(property, property.get(), matchStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        accept(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableIntSupplier property, int value) {
        accept(property, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableLongSupplier property, long value) {
        accept(property, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableDoubleSupplier property, double value) {
        accept(property, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     */
    default <D extends Date> void accept(SerializableDateSupplier<D> property, D value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <D> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <D extends Date> void accept(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <N> the generic type
     * @param property bean property
     * @param value the value
     */
    default <N extends Number> void accept(SerializableNumberSupplier<N> property, N value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <N> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <N extends Number> void accept(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableLocalDateSupplier property, LocalDate value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableLocalTimeSupplier property, LocalTime value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     */
    default void accept(SerializableStringSupplier property, String value) {
        accept(property, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        accept(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        accept(property, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}
