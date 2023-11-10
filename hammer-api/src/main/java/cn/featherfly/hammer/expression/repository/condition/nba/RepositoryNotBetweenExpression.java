
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
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression;

/**
 * repository not between and expression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotBetweenExpression<C, L> {

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max, BiPredicate<String, String> ignoreStrategy);

}