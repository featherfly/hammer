
package cn.featherfly.hammer.expression.repository.condition.lt;

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
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression6;
import cn.featherfly.hammer.expression.condition.lt.LessThanSupplierExpression6;

/**
 * repository less than expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpressionBase6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase5<C, L>, LessThanExpression6<C, L>, LessThanSupplierExpression6<C, L> {
    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToIntFunction<T> name, int value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLongFunction<T> name, long value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToDoubleFunction<T> name, double value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L lt6(SerializableToEnumFunction<T, E> name, E value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L lt6(SerializableToEnumFunction<T, E> name, E value,
        IgnoreStrategy ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L lt6(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, N extends Number> L lt6(SerializableToNumberFunction<T, N> name, N value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L lt6(SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return lt6(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L lt6(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, D extends Date> L lt6(SerializableToDateFunction<T, D> name, D value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L lt6(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return lt6(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L lt6(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt6(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt6(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt6(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * less than. 小于.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lt6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableIntSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLongSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableDoubleSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L lt6(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L lt6(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L lt6(SerializableDateSupplier<D> property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L lt6(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalTimeSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalDateSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalDateTimeSupplier property) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L lt6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt6(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy, ignoreStrategy);
    }
}