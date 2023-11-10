
package cn.featherfly.hammer.expression.repository.condition.le;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression;

/**
 * RepositoryLessEqualsExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryLessEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessEqualsExpression<C, L> {

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N>      the number type
     * @param property 对象属性
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}