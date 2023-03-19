
package cn.featherfly.hammer.expression.condition.type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
     * @param consumer the consumer
     * @return LogicExpression
     */
    L le(Consumer<EntityLessEqualsExpressoin<E, C, L>> consumer);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableFunction<E, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableFunction<E, N> name, N value, Predicate<N> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableFunction<E, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableFunction<E, D> name, D value, Predicate<D> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(SerializableFunction<E, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(SerializableFunction<E, String> name, String value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(SerializableFunction<E, String> name, String value, Predicate<String> ignorePolicy);

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
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R extends Date> L le(DateSupplier<R> property, Predicate<R> ignorePolicy);

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
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R extends Number> L le(NumberSupplier<R> property, Predicate<R> ignorePolicy);

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
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(LocalDateSupplier property, Predicate<LocalDate> ignorePolicy);

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
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(LocalTimeSupplier property, Predicate<LocalTime> ignorePolicy);

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
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignorePolicy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(StringSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L le(StringSupplier property, Predicate<String> ignorePolicy);

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
    <R, N extends Number> L le(SerializableFunction<E, R> repository, SerializableFunction<R, N> property, N value);

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
    <R, D extends Date> L le(SerializableFunction<E, R> repository, SerializableFunction<R, D> property, D value);

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
    <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);

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
    <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);

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
    <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value);

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
    <R> L le(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

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