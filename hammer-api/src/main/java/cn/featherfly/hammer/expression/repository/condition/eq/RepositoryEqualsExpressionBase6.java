
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
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L eq6(SerializableFunction<T, R> name, R value) {
        return eq6(LambdaUtils.getLambdaPropertyName(name), value);
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
    default <T, R extends Serializable> L eq6(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBooleanSupplier property, boolean value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableCharSupplier property, char value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableIntSupplier property, int value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLongSupplier property, long value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLongSupplier propertyValue, long value, LongPredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableDoubleSupplier property, double value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBoolSupplier property, Boolean value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq6(SerializableNumberSupplier<N> property, N value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L eq6(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L eq6(SerializableDateSupplier<D> property, D value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L eq6(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> property, E value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L eq6(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateSupplier property, LocalDate value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalTimeSupplier property, LocalTime value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq6(SerializableSupplier<R> property, R value) {
        return eq6(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L eq6(SerializableSupplier<R> propertyValue, R value,
        Predicate<R> ignoreStrategy) {
        return eq6(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }
}