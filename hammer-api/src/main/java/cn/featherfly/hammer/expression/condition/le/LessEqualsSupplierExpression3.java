
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
 * less equals supplier expression3 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface LessEqualsSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableIntSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableLongSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableDoubleSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <E>      the element type
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property);

    /**
     * less equals. 小于等于.
     *
     * @param <E>            the element type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L le3(SerializableNumberSupplier<N> property);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le3(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return le3(property, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le3(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L le3(SerializableDateSupplier<D> property);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le3(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return le3(property, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le3(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableLocalTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le3(property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableLocalDateSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return le3(property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le3(SerializableLocalDateTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le3(property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L le3(SerializableStringSupplier property) {
        return le3(property, MatchStrategy.AUTO);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return le3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L le3(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return le3(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}