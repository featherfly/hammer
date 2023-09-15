
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

/**
 * LessEqualsExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface LessEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * less equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <N extends Number> L le(Field name, N value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(Field name, N value, Predicate<N> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le(String name, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(String name, N value, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <D extends Date> L le(Field name, D value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(Field name, D value, Predicate<D> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le(String name, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(String name, D value, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalTime value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalDate value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalDateTime value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, String value) {
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field name, String value, Predicate<String> ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, String value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, String value, Predicate<String> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value);

    /**
     * less equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <R>           the generic type
     * @param propertyValue the property value
     * @return LogicExpression
     */
    <R extends Date> L le(SerializableDateSupplier<R> propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L le(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <R>           the generic type
     * @param propertyValue the property value
     * @return LogicExpression
     */
    <R extends Number> L le(SerializableNumberSupplier<R> propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L le(SerializableNumberSupplier<R> propertyValue, Predicate<R> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    L le(SerializableStringSupplier propertyValue);

    /**
     * less equals. 小于等于.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy);
}