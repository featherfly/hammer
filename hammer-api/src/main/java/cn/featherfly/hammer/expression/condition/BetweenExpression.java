
package cn.featherfly.hammer.expression.condition;

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

/**
 * BetweenExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface BetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends BetweenExpressionBase<C, L> {

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max, BiPredicate<String, String> ignoreStrategy);

}