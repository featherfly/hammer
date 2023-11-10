
package cn.featherfly.hammer.expression.repository.condition.eq;

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
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression4;

/**
 * RepositoryEqualsExpressionBase4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression4<C, L>, RepositoryEqualsExpressionBase3<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq4(SerializableFunction<T, R> name, R value) {
        return eq4(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq4(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableBooleanSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsBoolean());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableCharSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableIntSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLongSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableDoubleSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableBoolSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq4(SerializableNumberSupplier<N> propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq4(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq4(SerializableDateSupplier<D> propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq4(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq4(SerializableEnumSupplier<E> propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq4(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalDateSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalTimeSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalDateTimeSupplier propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
                ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq4(SerializableSupplier<R> propertyValue) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq4(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }
}