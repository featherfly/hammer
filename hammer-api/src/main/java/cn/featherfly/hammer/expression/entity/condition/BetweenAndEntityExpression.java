
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * between and entity expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface BetweenAndEntityExpression<T> {

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToIntFunction<T> name, int min, int max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToIntFunction<T> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToLongFunction<T> name, long min, long max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLongFunction<T> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToDoubleFunction<T> name, double min, double max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToDoubleFunction<T> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    <N extends Number> void accept(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    <N extends Number> void accept(SerializableToNumberFunction<T, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    <D extends Date> void accept(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    <D extends Date> void accept(SerializableToDateFunction<T, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>  the element type
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    <E extends Enum<E>> void accept(SerializableToEnumFunction<T, E> name, E min, E max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    <E extends Enum<E>> void accept(SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     */
    void accept(SerializableToStringFunction<T> name, String min, String max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToStringFunction<T> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy);
}
