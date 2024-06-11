
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
import cn.featherfly.hammer.expression.condition.eq.EqualsSupplierExpression;

/**
 * RepositoryEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EqualsExpression<C, L>, EqualsSupplierExpression<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq(SerializableFunction<T, R> name, R value) {
        return eq(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * equals. 等于.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
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
    default L eq(SerializableBooleanSupplier property, boolean value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableCharSupplier property, char value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableIntSupplier property, int value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLongSupplier property, long value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLongSupplier propertyValue, long value, LongPredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableDoubleSupplier property, double value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableBoolSupplier property, Boolean value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq(SerializableNumberSupplier<N> property, N value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq(SerializableDateSupplier<D> property, D value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateSupplier property, LocalDate value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq(SerializableSupplier<R> property, R value) {
        return eq(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq(SerializableSupplier<R> propertyValue, R value, Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }
}