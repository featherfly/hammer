
package cn.featherfly.hammer.expression.repository.condition.ge;

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
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsSupplierExpression;

/**
 * repository great equals expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends GreatEqualsExpression<C, L>, GreatEqualsSupplierExpression<C, L> {
    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToIntFunction<T> name, int value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLongFunction<T> name, long value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToDoubleFunction<T> name, double value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L ge(SerializableToEnumFunction<T, E> name, E value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L ge(SerializableToEnumFunction<T, E> name, E value, IgnoreStrategy ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, E extends Enum<E>> L ge(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value,
        IgnoreStrategy ignoreStrategy) {
        return ge(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy) {
        return ge(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ge(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableIntSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLongSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableDoubleSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ge(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ge(SerializableNumberSupplier<N> property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ge(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ge(SerializableDateSupplier<D> property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ge(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalTimeSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalDateSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalDateTimeSupplier property) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ge(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy, ignoreStrategy);
    }

}