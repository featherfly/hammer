
package cn.featherfly.hammer.expression.repository.condition.ba;

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
import cn.featherfly.hammer.expression.condition.ba.BetweenExpression;

/**
 * RepositoryBetweenExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends BetweenExpression<C, L> {

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max,
            IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max,
            IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <T> L ba(SerializableToStringFunction<T> name, String min, String max) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ba(SerializableToStringFunction<T> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return ba(LambdaUtils.getLambdaPropertyName(name), min, max, ignoreStrategy);
    }

}