
package cn.featherfly.hammer.expression.repository.condition.nba;

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
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression4;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenSupplierExpression4;

/**
 * repository not between and expression4 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotBetweenExpressionBase3<C, L>, NotBetweenExpression4<C, L>,
    NotBetweenSupplierExpression4<C, L> {

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T, N extends Number> L nba4(SerializableToNumberFunction<T, N> name, N min, N max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L nba4(SerializableToNumberFunction<T, N> name, N min, N max,
        IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L nba4(SerializableToNumberFunction<T, N> name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T, D extends Date> L nba4(SerializableToDateFunction<T, D> name, D min, D max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L nba4(SerializableToDateFunction<T, D> name, D min, D max,
        IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L nba4(SerializableToDateFunction<T, D> name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToStringFunction<T> name, String min, String max) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T> the generic type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba4(SerializableToStringFunction<T> name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    default <N extends Number> L nba4(SerializableNumberSupplier<N> property, N min, N max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default <N extends Number> L nba4(SerializableNumberSupplier<N> property, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    @Override
    default <D extends Date> L nba4(SerializableDateSupplier<D> property, D min, D max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default <D extends Date> L nba4(SerializableDateSupplier<D> property, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    @Override
    default L nba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default L nba4(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    @Override
    default L nba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default L nba4(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    @Override
    default L nba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default L nba4(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }

    @Override
    default L nba4(SerializableStringSupplier property, String min, String max) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max);
    }

    @Override
    default L nba4(SerializableStringSupplier property, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {
        return nba4(LambdaUtils.getLambdaPropertyName(property), min, max, ignoreStrategy);
    }
}