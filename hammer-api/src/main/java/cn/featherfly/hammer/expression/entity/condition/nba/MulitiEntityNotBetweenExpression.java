
package cn.featherfly.hammer.expression.entity.condition.nba;

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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityNotBetweenExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityNotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max,
            BiPredicate<Long, Long> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>   the generic type
     * @param <E>   the enum type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <E>            the enum type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy);

    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax,
    //            BiPredicate<Integer, Integer> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax,
    //            BiPredicate<Long, Long> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax,
    //            BiPredicate<Double, Double> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <D>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L nba(int index, SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <D>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L nba(int index, SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax,
    //            BiPredicate<D, D> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <N>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L nba(int index, SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <N>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L nba(int index, SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax, BiPredicate<N, N> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax,
    //            BiPredicate<LocalDate, LocalDate> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax,
    //            BiPredicate<LocalTime, LocalTime> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax,
    //            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba(int index, SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax,
    //            BiPredicate<String, String> ignoreStrategy);
}