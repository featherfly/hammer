
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;

/**
 * TypeGreatEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatEqualsExpression<C, L> {

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L ge(SerializableFunction<T, R> repository, SerializableToNumberFunction<R, N> property, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableSupplier<T> repository, SerializableToNumberFunction<T, N> property);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L ge(SerializableFunction<T, R> repository, SerializableToDateFunction<R, D> property, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableSupplier<T> repository, SerializableToDateFunction<T, D> property);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> repository, SerializableToLocalTimeFunction<R> property, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> repository, SerializableToLocalDateFunction<R> property, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> repository, SerializableToLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> repository, SerializableToStringFunction<R> property, String value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}