
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
 * TypeLessEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface TypeLessEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessEqualsExpression<C, L> {

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L le(SerializableFunction<T, R> repository, SerializableToNumberFunction<R, N> property, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableSupplier<T> repository, SerializableToNumberFunction<T, N> property);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L le(SerializableFunction<T, R> repository, SerializableToDateFunction<R, D> property, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableSupplier<T> repository, SerializableToDateFunction<T, D> property);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> repository, SerializableToLocalTimeFunction<R> property, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L le(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> repository, SerializableToLocalDateFunction<R> property, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L le(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> repository, SerializableToLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L le(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> repository, SerializableToStringFunction<R> property, String value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L le(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}