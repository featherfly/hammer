
package cn.featherfly.hammer.expression.repository.condition.gt;

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
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression5;
import cn.featherfly.hammer.expression.condition.gt.GreatThanSupplierExpression5;

/**
 * repository great than expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase4<C, L>, GreatThanExpression5<C, L>, GreatThanSupplierExpression5<C, L> {
    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToIntFunction<T> name, int value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLongFunction<T> name, long value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToDoubleFunction<T> name, double value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L gt5(SerializableToEnumFunction<T, E> name, E value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L gt5(SerializableToEnumFunction<T, E> name, E value,
        IgnoreStrategy ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L gt5(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, N extends Number> L gt5(SerializableToNumberFunction<T, N> name, N value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L gt5(SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return gt5(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L gt5(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, D extends Date> L gt5(SerializableToDateFunction<T, D> name, D value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L gt5(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return gt5(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L gt5(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt5(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great than. 大于.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L gt5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableIntSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLongSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableDoubleSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L gt5(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L gt5(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L gt5(SerializableDateSupplier<D> property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L gt5(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalTimeSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalDateSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalDateTimeSupplier property) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L gt5(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt5(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy, ignoreStrategy);
    }
}