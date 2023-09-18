
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
 * NotBetweenExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface NotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringNotBetweenExpression<C, L> {

    /**
     * not between and.
     *
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max, Predicate<N> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    <N extends Number> L nba(String name, N min, N max);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <N extends Number> L nba(String name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <N extends Number> L nba(String name, N min, N max, Predicate<N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L nba(SerializableToNumberFunction<T, N> name, N min, N max, Predicate<N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N>      the number type
     * @param property 对象属性
     * @return LogicExpression
     */
    <N extends Number> L nba(SerializableNumberSupplier<N> property);

    /**
     * not between and.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max, Predicate<D> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    <D extends Date> L nba(String name, D min, D max);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <D extends Date> L nba(String name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <D extends Date> L nba(String name, D min, D max, Predicate<D> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L nba(SerializableToDateFunction<T, D> name, D min, D max, Predicate<D> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <D extends Date> L nba(SerializableDateSupplier<D> property);

    /**
     * not between and.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max, Predicate<LocalTime> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalTime min, LocalTime max, Predicate<LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            Predicate<LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L nba(SerializableLocalTimeSupplier property);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max, Predicate<LocalDate> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDate min, LocalDate max, Predicate<LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            Predicate<LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L nba(SerializableLocalDateSupplier property);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max, Predicate<LocalDateTime> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, LocalDateTime min, LocalDateTime max, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L nba(SerializableLocalDateTimeSupplier property);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max, Predicate<String> ignoreStrategy) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    @Override
    L nba(String name, String min, String max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    L nba(String name, String min, String max, Predicate<String> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>  the generic type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L nba(SerializableToStringFunction<T> name, String min, String max, Predicate<String> ignoreStrategy);

    /**
     * not between and.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L nba(SerializableStringSupplier property);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}