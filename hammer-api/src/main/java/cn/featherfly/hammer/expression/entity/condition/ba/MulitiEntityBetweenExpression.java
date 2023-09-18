
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityBetweenExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L ba(int index, SerializableFunction<E, N> name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L ba(int index, SerializableFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L ba(int index, SerializableFunction<E, D> name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L ba(int index, SerializableFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, String> name, String min, String max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableFunction<E, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy);

    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax,
    //            BiPredicate<Integer, Integer> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax,
    //            BiPredicate<Long, Long> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax,
    //            BiPredicate<Double, Double> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <D>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L ba(int index, SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <D>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <D extends Date> L ba(int index, SerializableDateSupplier<D> propertyMin, SerializableDateSupplier<D> propertyMax,
    //            BiPredicate<D, D> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <N>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L ba(int index, SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param <N>            the generic type
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <N extends Number> L ba(int index, SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax, BiPredicate<N, N> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax,
    //            BiPredicate<LocalDate, LocalDate> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax,
    //            BiPredicate<LocalTime, LocalTime> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax,
    //            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax);
    //
    //    /**
    //     * between and.
    //     *
    //     * @param property       对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ba(int index, SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax,
    //            BiPredicate<String, String> ignoreStrategy);
}