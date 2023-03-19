
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
 * TypeLessThanExpressoin. .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessThanExpressoin<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * less than. 小于.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L lt(Consumer<EntityLessThanExpressoin<E, C, L>> consumer);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableFunction<E, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableFunction<E, N> name, N value, Predicate<N> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableFunction<E, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableFunction<E, D> name, D value, Predicate<D> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, String> name, String value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(SerializableFunction<E, String> name, String value, Predicate<String> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt(DateSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R extends Date> L lt(DateSupplier<R> property, Predicate<R> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt(NumberSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R extends Number> L lt(NumberSupplier<R> property, Predicate<R> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(LocalDateSupplier property, Predicate<LocalDate> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(LocalTimeSupplier property, Predicate<LocalTime> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(StringSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L lt(StringSupplier property, Predicate<String> ignorePolicy);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, N extends Number> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, N> property, N value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param <N>        the number type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, N extends Number> L lt(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);

    /**
     * less than. 小于.
     *
     * @param <R>        the date type
     * @param <D>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, D extends Date> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, D> property, D value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param <D>        the date type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, D extends Date> L lt(SerializableSupplier<R> repository, SerializableFunction<R, D> property);

    /**
     * less than. 小于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L lt(SerializableSupplier<R> repository, ReturnLocalTimeFunction<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L lt(SerializableSupplier<R> repository, ReturnLocalDateFunction<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, LocalDateTime> property,
            LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L lt(SerializableSupplier<R> repository, ReturnLocalDateTimeFunction<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>        the date type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L lt(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * less than. 小于.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L lt(SerializableSupplier<R> repository, ReturnStringFunction<R> property);
}