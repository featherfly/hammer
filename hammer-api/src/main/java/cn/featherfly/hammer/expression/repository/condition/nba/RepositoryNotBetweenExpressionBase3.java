
package cn.featherfly.hammer.expression.repository.condition.nba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

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
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression3;

/**
 * repository not between and expression3 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotBetweenExpressionBase2<C, L>, NotBetweenExpression3<C, L> {

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T, N extends Number> L nba3(SerializableToNumberFunction<T, N> name, N min, N max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L nba3(SerializableToNumberFunction<T, N> name, N min, N max,
            IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L nba3(SerializableToNumberFunction<T, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T, D extends Date> L nba3(SerializableToDateFunction<T, D> name, D min, D max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L nba3(SerializableToDateFunction<T, D> name, D min, D max,
            IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L nba3(SerializableToDateFunction<T, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToStringFunction<T> name, String min, String max) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nba3(SerializableToStringFunction<T> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return nba3(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }
}