
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction5;
import cn.featherfly.common.lang.function.SerializableToIntFunction5;
import cn.featherfly.common.lang.function.SerializableToLongFunction5;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpressionBase5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatThanExpressionBase4<E, E2, E3, E4, C, L> {

    //    /**
    //     * great than. 大于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L gt5(Consumer<EntityGreatEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableToIntFunction5<E5> name, int value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableToIntFunction5<E5> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableToLongFunction5<E5> name, long value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableToLongFunction5<E5> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableToDoubleFunction5<E5> name, double value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableToDoubleFunction5<E5> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt5(SerializableFunction<E5, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt5(SerializableFunction<E5, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, String> name, String value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableIntSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableLongSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableDoubleSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt5(SerializableDateSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L gt5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt5(SerializableNumberSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L gt5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableLocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt5(SerializableStringSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(SerializableStringSupplier property, Predicate<String> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).gt(v)来设置
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, N> property, N value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L gt5(SerializableSupplier<R> repository, SerializableToNumberFunction<R, N> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the date type
    //     * @param <D>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, D> property, D value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <D>        the date type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L gt5(SerializableSupplier<R> repository, SerializableToDateFunction<R, D> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt5(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt5(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, LocalDateTime> property,
    //            LocalDateTime value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt5(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L gt5(SerializableFunction<E5, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt5(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}