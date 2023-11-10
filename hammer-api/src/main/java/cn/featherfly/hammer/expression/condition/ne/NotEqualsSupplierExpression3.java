
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
 * not equals supplier expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsSupplierExpression2<C, L> {
    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableBooleanSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableCharSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableIntSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableLongSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableDoubleSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableBoolSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableBoolSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<Boolean>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L ne3(SerializableNumberSupplier<N> property);

    /**
     * not equals. 不等于.
     *
     * @param <N>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ne3(SerializableNumberSupplier<N> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <N>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne3(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L ne3(SerializableDateSupplier<D> property);

    /**
     * not equals. 不等于.
     *
     * @param <D>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ne3(SerializableDateSupplier<D> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ne3(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>      the element type
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> property);

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne3(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableLocalDateSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableLocalDateSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableLocalTimeSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableLocalTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L ne3(SerializableLocalDateTimeSupplier propertyValue);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableLocalDateTimeSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L ne3(SerializableStringSupplier propertyValue) {
        return ne3(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return ne3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Serializable> L ne3(SerializableSupplier<R> property);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne3(SerializableSupplier<R> propertyValue, IgnoreStrategy ignoreStrategy) {
        return ne3(propertyValue, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ne3(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy);
}