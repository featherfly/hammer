
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
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression3;

/**
 * RepositoryEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression3<C, L>, RepositoryEqualsExpressionBase2<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq3(SerializableFunction<T, R> name, R value) {
        return eq3(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, R extends Serializable> L eq3(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableBooleanSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsBoolean());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableCharSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableIntSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLongSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableDoubleSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableBoolSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq3(SerializableNumberSupplier<N> propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq3(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq3(SerializableDateSupplier<D> propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq3(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq3(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalDateSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalTimeSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalDateTimeSupplier propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
                ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq3(SerializableSupplier<R> propertyValue) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq3(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }
}