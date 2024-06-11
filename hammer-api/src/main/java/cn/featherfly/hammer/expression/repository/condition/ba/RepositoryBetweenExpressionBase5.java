
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ba.BetweenExpression5;
import cn.featherfly.hammer.expression.condition.ba.BetweenSupplierExpression5;

/**
 * repository between expression5 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryBetweenExpressionBase4<C, L>, BetweenExpression5<C, L>, BetweenSupplierExpression5<C, L> {

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T, N extends Number> L ba5(SerializableToNumberFunction<T, N> name, N min, N max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ba5(SerializableToNumberFunction<T, N> name, N min, N max,
        IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ba5(SerializableToNumberFunction<T, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T, D extends Date> L ba5(SerializableToDateFunction<T, D> name, D min, D max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ba5(SerializableToDateFunction<T, D> name, D min, D max,
        IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ba5(SerializableToDateFunction<T, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToStringFunction<T> name, String min, String max) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba5(SerializableToStringFunction<T> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ba5(SerializableNumberSupplier<N> property, N min, N max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ba5(SerializableNumberSupplier<N> property, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ba5(SerializableDateSupplier<D> property, D min, D max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ba5(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableStringSupplier property, String min, String max) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ba5(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return ba5(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }
}