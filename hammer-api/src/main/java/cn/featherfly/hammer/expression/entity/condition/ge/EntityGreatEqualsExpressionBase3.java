
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction3;
import cn.featherfly.common.lang.function.SerializableToIntFunction3;
import cn.featherfly.common.lang.function.SerializableToLongFunction3;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpressionBase3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatEqualsExpressionBase2<E, E2, C, L> {

    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L ge3(Consumer<EntityGreatEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableToIntFunction3<E3> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableToIntFunction3<E3> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableToLongFunction3<E3> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableToLongFunction3<E3> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableToDoubleFunction3<E3> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableToDoubleFunction3<E3> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L ge3(SerializableFunction<E3, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge3(SerializableFunction<E3, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L ge3(SerializableFunction<E3, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge3(SerializableFunction<E3, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, String> name, String value);

    /**
     * great and equals. 大于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(SerializableIntSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(SerializableLongSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(SerializableDoubleSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ge3(DateSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ge3(DateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ge3(NumberSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L ge3(NumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(LocalDateSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(LocalTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(LocalDateTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge3(StringSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge3(StringSupplier property, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).eq(v)来设置
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, N> property, N value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L ge3(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param <D>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, D> property, D value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <D>        the date type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L ge3(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L ge3(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L ge3(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, LocalDateTime> property,
    //            LocalDateTime value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L ge3(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ge3(SerializableFunction<E3, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * great equals. 大于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L ge3(SerializableSupplier<T> repository, ReturnStringFunction<T> property);
}