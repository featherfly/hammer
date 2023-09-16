
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
 * LessThanExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field name, N value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field name, N value, Predicate<N> ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>      the number type
     * @param property 对象属性
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableNumberSupplier<N> property);

    /**
     * less than. 小于.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>            the number type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field name, D value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field name, D value, Predicate<D> ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableDateSupplier<D> property);

    /**
     * less than. 小于.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalTime value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalDate value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalDateTime value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, String value) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field name, String value, Predicate<String> ignoreStrategy) {
        return lt(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, String value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, String value, Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy);

}