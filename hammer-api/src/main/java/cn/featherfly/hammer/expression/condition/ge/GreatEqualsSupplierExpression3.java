
package cn.featherfly.hammer.expression.condition.ge;

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
 * great equals supplier expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * great and equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableIntSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableLongSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableDoubleSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>      the element type
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L ge3(SerializableNumberSupplier<N> property);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge3(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge3(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L ge3(SerializableDateSupplier<D> property);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge3(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge3(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableLocalTimeSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableLocalDateSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge3(SerializableLocalDateTimeSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ge3(SerializableStringSupplier property) {
        return ge3(property, MatchStrategy.AUTO);
    }

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return ge3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ge3(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge3(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ge3(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}