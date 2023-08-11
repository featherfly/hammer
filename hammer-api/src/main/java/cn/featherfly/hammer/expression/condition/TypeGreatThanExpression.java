
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
 * TypeGreatThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeGreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatThanExpression<C, L> {

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L gt(SerializableFunction<T, R> repository, SerializableToNumberFunction<R, N> property, N value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, N extends Number> L gt(SerializableSupplier<T> repository, SerializableToNumberFunction<T, N> property);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L gt(SerializableFunction<T, R> repository, SerializableToDateFunction<R, D> property, D value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, D extends Date> L gt(SerializableSupplier<T> repository, SerializableToDateFunction<T, D> property);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L gt(SerializableFunction<T, R> repository, SerializableToLocalTimeFunction<R> property, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L gt(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L gt(SerializableFunction<T, R> repository, SerializableToLocalDateFunction<R> property, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L gt(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L gt(SerializableFunction<T, R> repository, SerializableToLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L gt(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L gt(SerializableFunction<T, R> repository, SerializableToStringFunction<R> property, String value);

    /**
     * great than. 大于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L gt(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}