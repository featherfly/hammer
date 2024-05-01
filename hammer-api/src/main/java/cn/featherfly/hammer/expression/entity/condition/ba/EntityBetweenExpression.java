
package cn.featherfly.hammer.expression.entity.condition.ba;

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

/**
 * The Interface EntityBetweenExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityBetweenExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToIntFunction<T> name, int min, int max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToIntFunction<T> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToLongFunction<T> name, long min, long max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToLongFunction<T> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToDoubleFunction<T> name, double min, double max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToDoubleFunction<T> name, double min, double max, BiPredicate<Double, Double> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>  enum type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <E extends Enum<E>> L ba(SerializableToEnumFunction<T, E> name, E min, E max);

    /**
     * between and.
     *
     * @param <E>            enum type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ba(SerializableToEnumFunction<T, E> name, E min, E max, BiPredicate<E, E> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(SerializableToStringFunction<T> name, String min, String max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableToStringFunction<T> name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax,
    //            BiPredicate<Integer, Integer> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax,
    //            BiPredicate<Long, Long> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax,
    //            BiPredicate<Double, Double> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    <R extends Date> L ba(SerializableDateSupplier<R> propertyMin, SerializableDateSupplier<R> propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Date> L ba(SerializableDateSupplier<R> propertyMin, SerializableDateSupplier<R> propertyMax,
    //            BiPredicate<R, R> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    <R extends Number> L ba(SerializableNumberSupplier<R> propertyMin, SerializableNumberSupplier<R> propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Number> L ba(SerializableNumberSupplier<R> propertyMin, SerializableNumberSupplier<R> propertyMax,
    //            BiPredicate<R, R> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax,
    //            BiPredicate<LocalDate, LocalDate> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax,
    //            BiPredicate<LocalTime, LocalTime> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax,
    //            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax,
    //            BiPredicate<String, String> ignoreStrategy);

}