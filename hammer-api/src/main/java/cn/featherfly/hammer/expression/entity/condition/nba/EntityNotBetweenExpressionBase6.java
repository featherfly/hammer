
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
import cn.featherfly.hammer.expression.condition.nba.NotBetweenSupplierExpression6;

/**
 * The Interface EntityNotBetweenExpressionBase6.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotBetweenExpressionBase6<T, T2, T3, T4, T5, T6, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityNotBetweenExpressionBase5<T, T2, T3, T4, T5, C, L>, NotBetweenSupplierExpression6<C, L> {

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToIntFunction<T6> name, int min, int max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToIntFunction<T6> name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToLongFunction<T6> name, long min, long max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToLongFunction<T6> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToDoubleFunction<T6> name, double min, double max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToDoubleFunction<T6> name, double min, double max, BiPredicate<Double, Double> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    <N extends Number> L nba6(SerializableToNumberFunction<T6, N> name, N min, N max);

    /**
     * not between and.
     *
     * @param <N> number type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba6(SerializableToNumberFunction<T6, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    <D extends Date> L nba6(SerializableToDateFunction<T6, D> name, D min, D max);

    /**
     * not between and.
     *
     * @param <D> date type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba6(SerializableToDateFunction<T6, D> name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E> enum type
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    <E extends Enum<E>> L nba6(SerializableToEnumFunction<T6, E> name, E min, E max);

    /**
     * between and.
     *
     * @param <E> enum type
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L nba6(SerializableToEnumFunction<T6, E> name, E min, E max, BiPredicate<E, E> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToLocalTimeFunction<T6> name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToLocalDateFunction<T6> name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L nba6(SerializableToStringFunction<T6> name, String min, String max);

    /**
     * not between and.
     *
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba6(SerializableToStringFunction<T6> name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax,
    //            BiPredicate<Integer, Integer> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax,
    //            BiPredicate<Long, Long> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax,
    //            BiPredicate<Double, Double> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <D>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L nba6(SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <D>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L nba6(SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax,
    //            BiPredicate<D, D> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <N>      the generic type
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L nba6(SerializableNumberSupplier<N> propertyMin, SerializableNumberSupplier<N> propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param <N>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L nba6(SerializableNumberSupplier<N> propertyMin, SerializableNumberSupplier<N> propertyMax,
    //            BiPredicate<N, N> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax,
    //            BiPredicate<LocalDate, LocalDate> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax,
    //            BiPredicate<LocalTime, LocalTime> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax,
    //            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax);
    //
    //    /**
    //     * not between and.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L nba6(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax,
    //            BiPredicate<String, String> ignoreStrategy);
}