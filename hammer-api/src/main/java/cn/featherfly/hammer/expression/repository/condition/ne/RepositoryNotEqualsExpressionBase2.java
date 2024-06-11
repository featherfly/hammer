
package cn.featherfly.hammer.expression.repository.condition.ne;

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
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression2;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsSupplierExpression2;

/**
 * RepositoryNotEqualsExpressionBase2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpressionBase2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotEqualsExpression<C, L>, NotEqualsExpression2<C, L>, NotEqualsSupplierExpression2<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ne2(SerializableFunction<T, R> name, R value) {
        return ne2(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ne2(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableBooleanSupplier property, boolean value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableCharSupplier property, char value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableCharSupplier property, char value, CharPredicate ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableIntSupplier property, int value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLongSupplier property, long value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLongSupplier propertyValue, long value, LongPredicate ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableDoubleSupplier property, double value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableBoolSupplier property, Boolean value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableBoolSupplier property, Boolean value, Predicate<Boolean> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ne2(SerializableNumberSupplier<N> property, N value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ne2(SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ne2(SerializableDateSupplier<D> property, D value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L ne2(SerializableDateSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property, E value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalDateSupplier property, LocalDate value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalTimeSupplier property, LocalTime value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne2(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ne2(SerializableSupplier<R> property, R value) {
        return ne2(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ne2(SerializableSupplier<R> propertyValue, R value,
        Predicate<R> ignoreStrategy) {
        return ne2(LambdaUtils.getLambdaPropertyName(propertyValue), value, ignoreStrategy);
    }
}