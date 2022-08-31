
package cn.featherfly.hammer.expression.condition;

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

/**
 * The Interface EntityLessEqualsExpressoin.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface EntityLessEqualsExpressoin<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * less and equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le(ReturnNumberFunction<E, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le(ReturnDateFunction<E, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(ReturnLocalTimeFunction<E> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(ReturnLocalDateFunction<E> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(ReturnLocalDateTimeFunction<E> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(ReturnStringFunction<E> name, String value);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le(DateSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le(NumberSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalDateSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalDateTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(StringSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, N extends Number> L le(SerializableFunction<E, R> repository, ReturnNumberFunction<R, N> property, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, N extends Number> L le(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, D extends Date> L le(SerializableFunction<E, R> repository, ReturnDateFunction<R, D> property, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, D extends Date> L le(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L le(SerializableFunction<E, R> repository, ReturnLocalTimeFunction<R> property, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L le(SerializableSupplier<R> repository, ReturnLocalTimeFunction<R> property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L le(SerializableFunction<E, R> repository, ReturnLocalDateFunction<R> property, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L le(SerializableSupplier<R> repository, ReturnLocalDateFunction<R> property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L le(SerializableFunction<E, R> repository, ReturnLocalDateTimeFunction<R> property, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L le(SerializableSupplier<R> repository, ReturnLocalDateTimeFunction<R> property);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L le(SerializableFunction<E, R> repository, ReturnStringFunction<R> property, String value);

    /**
     * less equals. 小于等于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L le(SerializableSupplier<R> repository, ReturnStringFunction<R> property);
}