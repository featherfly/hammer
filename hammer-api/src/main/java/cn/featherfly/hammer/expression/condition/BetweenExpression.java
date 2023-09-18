
package cn.featherfly.hammer.expression.condition;

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
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * BetweenExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface BetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringBetweenExpression<C, L> {

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field name, N min, N max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field name, N min, N max, Predicate<N> ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    <N extends Number> L ba(String name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <N extends Number> L ba(String name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <N extends Number> L ba(String name, N min, N max, Predicate<N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ba(SerializableToNumberFunction<T, N> name, N min, N max, Predicate<N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>      the number type
     * @param property 对象属性
     * @return LogicExpression
     */
    <N extends Number> L ba(SerializableNumberSupplier<N> property);

    /**
     * between and.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field name, D min, D max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field name, D min, D max, Predicate<D> ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    <D extends Date> L ba(String name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <D extends Date> L ba(String name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <D extends Date> L ba(String name, D min, D max, Predicate<D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ba(SerializableToDateFunction<T, D> name, D min, D max, Predicate<D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <D extends Date> L ba(SerializableDateSupplier<D> property);

    /**
     * between and.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba(Field name, LocalTime min, LocalTime max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalTime min, LocalTime max, Predicate<LocalTime> ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalTime min, LocalTime max, Predicate<LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            Predicate<LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ba(SerializableLocalTimeSupplier property);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba(Field name, LocalDate min, LocalDate max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalDate min, LocalDate max, Predicate<LocalDate> ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDate min, LocalDate max, Predicate<LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            Predicate<LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ba(SerializableLocalDateSupplier property);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba(Field name, LocalDateTime min, LocalDateTime max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, LocalDateTime min, LocalDateTime max, Predicate<LocalDateTime> ignoreStrategy) {
        return ba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, LocalDateTime min, LocalDateTime max, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ba(SerializableLocalDateTimeSupplier property);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba(Field name, String min, String max) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field name, String min, String max, Predicate<String> ignoreStrategy) {
        return ba(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L ba(String name, String min, String max);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L ba(String name, String min, String max, Predicate<String> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ba(SerializableToStringFunction<T> name, String min, String max, Predicate<String> ignoreStrategy);

    /**
     * between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ba(SerializableStringSupplier property);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}