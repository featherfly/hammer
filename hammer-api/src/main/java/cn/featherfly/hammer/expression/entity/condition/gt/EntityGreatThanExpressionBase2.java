
package cn.featherfly.hammer.expression.entity.condition.gt;

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
import cn.featherfly.common.lang.function.SerializableToDoubleFunction2;
import cn.featherfly.common.lang.function.SerializableToIntFunction2;
import cn.featherfly.common.lang.function.SerializableToLongFunction2;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatThanExpression<E, C, L> {

    //    /**
    //     * great than. 大于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L gt2(Consumer<EntityGreatEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableToIntFunction2<E2> name, int value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableToLongFunction2<E2> name, long value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableToDoubleFunction2<E2> name, double value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableToDoubleFunction2<E2> name, double value, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt2(SerializableFunction<E2, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>          number type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt2(SerializableFunction<E2, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt2(SerializableFunction<E2, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>          date type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt2(SerializableFunction<E2, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, String> name, String value);

    /**
     * great than. 大于.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(SerializableIntSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(SerializableLongSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(SerializableDoubleSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt2(DateSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L gt2(DateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt2(NumberSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L gt2(NumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(LocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(LocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(LocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt2(StringSupplier property);

    /**
     * great than. 大于.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt2(StringSupplier property, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).eq(v)来设置
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
    //    <R, N extends Number> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, N> property, N value);
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
    //    <R, N extends Number> L gt2(SerializableSupplier<R> repository, ReturnNumberFunction<R, N> property);
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
    //    <R, D extends Date> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, D> property, D value);
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
    //    <R, D extends Date> L gt2(SerializableSupplier<R> repository, ReturnDateFunction<R, D> property);
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
    //    <R> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, LocalTime> property, LocalTime value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt2(SerializableSupplier<T> repository, ReturnLocalTimeFunction<T> property);
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
    //    <R> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, LocalDate> property, LocalDate value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt2(SerializableSupplier<T> repository, ReturnLocalDateFunction<T> property);
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
    //    <R> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, LocalDateTime> property,
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
    //    <T> L gt2(SerializableSupplier<T> repository, ReturnLocalDateTimeFunction<T> property);
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
    //    <R> L gt2(SerializableFunction<E2, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <T>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <T> L gt2(SerializableSupplier<T> repository, ReturnStringFunction<T> property);
}