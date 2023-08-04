
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

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
    <T, R, N extends Number> L ge(SerializableFunction<T, R> repository, ReturnNumberFunction<R, N> property, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableSupplier<T> repository, ReturnNumberFunction<T, N> property);

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
    <T, R, D extends Date> L ge(SerializableFunction<T, R> repository, ReturnDateFunction<R, D> property, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableSupplier<T> repository, ReturnDateFunction<T, D> property);

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
    <T, R> L ge(SerializableFunction<T, R> repository, ReturnLocalTimeFunction<R> property, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property);

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
    <T, R> L ge(SerializableFunction<T, R> repository, ReturnLocalDateFunction<R> property, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property);

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
    <T, R> L ge(SerializableFunction<T, R> repository, ReturnLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property);

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
    <T, R> L ge(SerializableFunction<T, R> repository, ReturnStringFunction<R> property, String value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T> L ge(SerializableSupplier<T> repository, ReturnStringFunction<T> property);
}