
package cn.featherfly.hammer.expression.repository.condition.le;

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
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression5;
import cn.featherfly.hammer.expression.condition.le.LessEqualsSupplierExpression5;

/**
 * repository less equals expression5 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpressionBase4<C, L>, LessEqualsExpression5<C, L>,
    LessEqualsSupplierExpression5<C, L> {
    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToIntFunction<T> name, int value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLongFunction<T> name, long value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToDoubleFunction<T> name, double value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L le5(SerializableToEnumFunction<T, E> name, E value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L le5(SerializableToEnumFunction<T, E> name, E value,
        IgnoreStrategy ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L le5(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, N extends Number> L le5(SerializableToNumberFunction<T, N> name, N value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L le5(SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return le5(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L le5(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, D extends Date> L le5(SerializableToDateFunction<T, D> name, D value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L le5(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return le5(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L le5(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le5(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le5(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le5(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L le5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableIntSupplier property, int value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLongSupplier property, long value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableDoubleSupplier property, double value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L le5(SerializableEnumSupplier<E> property, E value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L le5(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L le5(SerializableNumberSupplier<N> property, N value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L le5(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L le5(SerializableDateSupplier<D> property, D value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L le5(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalTimeSupplier property, LocalTime value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalDateSupplier property, LocalDate value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le5(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}