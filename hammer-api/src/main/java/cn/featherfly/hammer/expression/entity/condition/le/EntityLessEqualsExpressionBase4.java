
package cn.featherfly.hammer.expression.entity.condition.le;

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
import cn.featherfly.common.lang.function.SerializableToDoubleFunction4;
import cn.featherfly.common.lang.function.SerializableToIntFunction4;
import cn.featherfly.common.lang.function.SerializableToLongFunction4;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessEqualsExpressionBase3<E, E2, E3, C, L> {

    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L le4(Consumer<EntityGreatEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToIntFunction4<E4> name, int value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToIntFunction4<E4> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToLongFunction4<E4> name, long value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToLongFunction4<E4> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToDoubleFunction4<E4> name, double value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToDoubleFunction4<E4> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le4(SerializableFunction<E4, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le4(SerializableFunction<E4, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le4(SerializableFunction<E4, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le4(SerializableFunction<E4, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalTime> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalDate> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, String> name, String value);

    /**
     * less and equals. 小于等于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableIntSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLongSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableDoubleSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le4(SerializableDateSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L le4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le4(SerializableNumberSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L le4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalDateSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalDateTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableStringSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableStringSupplier property, Predicate<String> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).le(v)来设置
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, N> property, N value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L le4(SerializableSupplier<R> repository, SerializableToNumberFunction<R, N> property);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param <D>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, D> property, D value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <D>        the date type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L le4(SerializableSupplier<R> repository, SerializableToDateFunction<R, D> property);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L le4(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L le4(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, LocalDateTime> property,
    //            LocalDateTime value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L le4(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L le4(SerializableFunction<E4, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * less and equals. 小于等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L le4(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}