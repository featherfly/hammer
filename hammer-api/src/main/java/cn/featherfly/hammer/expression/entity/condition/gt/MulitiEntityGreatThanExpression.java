
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityGreatThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityGreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToIntFunction<E> name, int value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToLongFunction<E> name, long value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, String> name, String value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableIntSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableLongSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableDoubleSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt(int index, SerializableDateSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L gt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt(int index, SerializableNumberSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L gt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(int index, SerializableStringSupplier property);

    /**
     * great than. 大于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}