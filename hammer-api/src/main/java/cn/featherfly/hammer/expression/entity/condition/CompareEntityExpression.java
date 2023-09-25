
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
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface ConpareEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface CompareEntityExpression<E> {

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToDoubleFunction<E> name, double value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> void accept(SerializableToNumberFunction<E, N> name, N value);

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> void accept(SerializableToNumberFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> void accept(SerializableToDateFunction<E, D> name, D value);

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> void accept(SerializableToDateFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLocalTimeFunction<E> name, LocalTime value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLocalTimeFunction<E> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLocalDateFunction<E> name, LocalDate value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLocalDateFunction<E> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLocalDateTimeFunction<E> name, LocalDateTime value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLocalDateTimeFunction<E> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToStringFunction<E> name, String value);

    /**
     * compare. 比较
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToStringFunction<E> name, String value, Predicate<String> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableIntSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableLongSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableDoubleSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> void accept(SerializableDateSupplier<R> property);

    /**
     * compare. 比较
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> void accept(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> void accept(SerializableNumberSupplier<R> property);

    /**
     * compare. 比较
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableLocalDateSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableLocalTimeSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableLocalDateTimeSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableStringSupplier property);

    /**
     * compare. 比较
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}
