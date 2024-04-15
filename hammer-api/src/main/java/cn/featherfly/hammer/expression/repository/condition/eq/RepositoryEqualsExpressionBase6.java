
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
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression6;
import cn.featherfly.hammer.expression.condition.eq.EqualsSupplierExpression6;

/**
 * RepositoryEqualsExpressionBase6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpressionBase6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEqualsExpressionBase5<C, L>, EqualsExpression6<C, L>, EqualsSupplierExpression6<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq6(SerializableFunction<T, R> name, R value) {
        return eq6(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, R extends Serializable> L eq6(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBooleanSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsBoolean());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableCharSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsChar(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableIntSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLongSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableDoubleSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBoolSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq6(SerializableNumberSupplier<N> propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq6(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq6(SerializableDateSupplier<D> propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq6(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalTimeSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateTimeSupplier propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq6(SerializableSupplier<R> propertyValue) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq6(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }
}