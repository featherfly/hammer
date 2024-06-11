
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
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression2;
import cn.featherfly.hammer.expression.condition.le.LessEqualsSupplierExpression2;

/**
 * repository less equals expression2 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpressionBase2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessEqualsExpression<C, L>, LessEqualsExpression2<C, L>, LessEqualsSupplierExpression2<C, L> {
    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le2(SerializableToIntFunction<T> name, int value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le2(SerializableToLongFunction<T> name, long value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L le2(SerializableToDoubleFunction<T> name, double value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T, E extends Enum<E>> L le2(SerializableToEnumFunction<T, E> name, E value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, E extends Enum<E>> L le2(SerializableToEnumFunction<T, E> name, E value,
        IgnoreStrategy ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T, E extends Enum<E>> L le2(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T, N extends Number> L le2(SerializableToNumberFunction<T, N> name, N value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, N extends Number> L le2(SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return le2(name, value, (Predicate<N>) ignoreStrategy::test);
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
    default <T, N extends Number> L le2(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T, D extends Date> L le2(SerializableToDateFunction<T, D> name, D value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, D extends Date> L le2(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return le2(name, value, (Predicate<D>) ignoreStrategy::test);
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
    default <T, D extends Date> L le2(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le2(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
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
    default <T> L le2(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le2(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
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
    default <T> L le2(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le2(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
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
    default <T> L le2(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
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
    default <T> L le2(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableIntSupplier property, int value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLongSupplier property, long value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableDoubleSupplier property, double value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L le2(SerializableEnumSupplier<E> property, E value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L le2(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L le2(SerializableNumberSupplier<N> property, N value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L le2(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L le2(SerializableDateSupplier<D> property, D value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L le2(SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalTimeSupplier property, LocalTime value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalDateSupplier property, LocalDate value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L le2(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return le2(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}