
package cn.featherfly.hammer.expression.condition.type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatEqualsExpressoin.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatEqualsExpressoin<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L ge(SerializableFunction<E, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L ge(SerializableFunction<E, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(SerializableFunction<E, String> name, String value);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ge(DateSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ge(NumberSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(LocalDateSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(LocalTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(LocalDateTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(StringSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, N extends Number> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, N> property, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, N extends Number> L ge(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);

    /**
     * great equals. 大于等于.
     *
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, D extends Date> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, D> property, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <R>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, D extends Date> L ge(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property);

    /**
     * great equals. 大于等于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);

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
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);

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
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value);

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
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L ge(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

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