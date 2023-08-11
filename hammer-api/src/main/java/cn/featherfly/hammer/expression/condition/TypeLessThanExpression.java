
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * TypeLessThanExpression. .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanExpression<C, L> {

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L lt(SerializableFunction<T, R> repository, SerializableToNumberFunction<R, N> property, N value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableSupplier<T> repository, SerializableToNumberFunction<T, N> property);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L lt(SerializableFunction<T, R> repository, SerializableToDateFunction<R, D> property, D value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableSupplier<T> repository, SerializableToDateFunction<T, D> property);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L lt(SerializableFunction<T, R> repository, SerializableToLocalTimeFunction<R> property, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L lt(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L lt(SerializableFunction<T, R> repository, SerializableToLocalDateFunction<R> property, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L lt(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L lt(SerializableFunction<T, R> repository, SerializableToLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L lt(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L lt(SerializableFunction<T, R> repository, SerializableToStringFunction<R> property, String value);

    /**
     * less than. 小于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L lt(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}