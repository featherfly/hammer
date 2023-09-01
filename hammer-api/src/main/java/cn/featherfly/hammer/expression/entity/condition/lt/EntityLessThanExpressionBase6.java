
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction6;
import cn.featherfly.common.function.serializable.SerializableToIntFunction6;
import cn.featherfly.common.function.serializable.SerializableToLongFunction6;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpressionBase6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessThanExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessThanExpressionBase5<E, E2, E3, E4, E5, C, L> {

    //    /**
    //     *less than. 小于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L lt6(Consumer<EntityGreatEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableToIntFunction6<E6> name, int value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableToIntFunction6<E6> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableToLongFunction6<E6> name, long value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableToLongFunction6<E6> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableToDoubleFunction6<E6> name, double value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableToDoubleFunction6<E6> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L lt6(SerializableFunction<E6, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt6(SerializableFunction<E6, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L lt6(SerializableFunction<E6, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt6(SerializableFunction<E6, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, String> name, String value);

    /**
     * less than. 小于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableIntSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableLongSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableDoubleSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt6(SerializableDateSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L lt6(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt6(SerializableNumberSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L lt6(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt6(SerializableStringSupplier property);

    /**
     * less than. 小于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt6(SerializableStringSupplier property, Predicate<String> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).lt(v)来设置
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, N> property, N value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <N>        the number type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, N extends Number> L lt6(SerializableSupplier<R> repository, SerializableToNumberFunction<R, N> property);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the date type
    //     * @param <D>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, D> property, D value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <D>        the date type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, D extends Date> L lt6(SerializableSupplier<R> repository, SerializableToDateFunction<R, D> property);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L lt6(SerializableSupplier<T> repository, SerializableToLocalTimeFunction<T> property);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L lt6(SerializableSupplier<T> repository, SerializableToLocalDateFunction<T> property);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, LocalDateTime> property,
    //            LocalDateTime value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L lt6(SerializableSupplier<T> repository, SerializableToLocalDateTimeFunction<T> property);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <R>        the date type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lt6(SerializableFunction<E6, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * less than. 小于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L lt6(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}