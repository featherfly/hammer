
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}