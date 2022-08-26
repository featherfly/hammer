
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
 * The Interface EntityGreatThanExpressoin.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatThanExpressoin<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableFunction<E, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableFunction<E, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(SerializableFunction<E, String> name, String value);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt(NumberSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt(DateSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(StringSupplier property);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, N extends Number> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, N> property, N value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, N extends Number> L gt(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);

    /**
     * great than. 大于.
     *
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, D extends Date> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, D> property, D value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, D extends Date> L gt(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property);

    /**
     * great than. 大于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L gt(SerializableSupplier<R> repository, ReturnLocalTimeFunction<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L gt(SerializableSupplier<R> repository, ReturnLocalDateFunction<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L gt(SerializableSupplier<R> repository, ReturnLocalDateTimeFunction<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L gt(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * great than. 大于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L gt(SerializableSupplier<R> repository, ReturnStringFunction<R> property);
}