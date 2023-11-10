
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
 * equals supplier expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsSupplierExpression2<C, L> {
    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableBooleanSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableCharSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableIntSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableLongSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableDoubleSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableBoolSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableBoolSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<Boolean>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N>           the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    <N extends Number> L eq3(SerializableNumberSupplier<N> propertyValue);

    /**
     * equals. 等于.
     *
     * @param <N>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L eq3(SerializableNumberSupplier<N> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <N>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq3(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D>           the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    <D extends Date> L eq3(SerializableDateSupplier<D> propertyValue);

    /**
     * equals. 等于.
     *
     * @param <D>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L eq3(SerializableDateSupplier<D> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L eq3(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>           the element type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> propertyValue);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableLocalDateSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableLocalDateSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableLocalTimeSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableLocalTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    L eq3(SerializableLocalDateTimeSupplier propertyValue);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableLocalDateTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @return LogicExpression
     */
    default L eq3(SerializableStringSupplier propertyValue) {
        return eq3(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return eq3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue the propertyValue value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param propertyValue  the propertyValue value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param propertyValue bean propertyValue
     * @return LogicExpression
     */
    <R extends Serializable> L eq3(SerializableSupplier<R> propertyValue);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq3(SerializableSupplier<R> propertyValue, IgnoreStrategy ignoreStrategy) {
        return eq3(propertyValue, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the propertyValue value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L eq3(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy);
}