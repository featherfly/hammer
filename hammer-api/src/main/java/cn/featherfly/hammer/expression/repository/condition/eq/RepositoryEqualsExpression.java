
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
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression;

/**
 * RepositoryEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq(SerializableFunction<T, R> name, R value) {
        return eq(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, R extends Serializable> L eq(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableBooleanSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsBoolean());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableCharSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableIntSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLongSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableDoubleSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableBoolSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq(SerializableNumberSupplier<N> propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq(SerializableDateSupplier<D> propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalTimeSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateTimeSupplier propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }
}