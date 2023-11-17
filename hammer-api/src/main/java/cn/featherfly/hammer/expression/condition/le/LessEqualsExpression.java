
package cn.featherfly.hammer.expression.condition.le;

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
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * less equals expression .
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
     * @param name  the name
     * @param value the value
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
    default <N extends Number> L le(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
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
     * @param name  the name
     * @param value the value
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
    <N extends Number> L le(String name, N value, IgnoreStrategy ignoreStrategy);

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

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
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
    default <D extends Date> L le(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
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
     * @param name  the name
     * @param value the value
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
    <D extends Date> L le(String name, D value, IgnoreStrategy ignoreStrategy);

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

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name  the name
     * @param value the value
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
    default L le(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
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
     * @param name  the name
     * @param value the value
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
    L le(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name  the name
     * @param value the value
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
    default L le(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
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
     * @param name  the name
     * @param value the value
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
    L le(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name  the name
     * @param value the value
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
    default L le(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(name.name(), value, ignoreStrategy);
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
     * @param name  the name
     * @param value the value
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
    L le(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name  the name
     * @param value the value
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
    default L le(Field name, String value, IgnoreStrategy ignoreStrategy) {
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
        return le(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name  the name
     * @param value the value
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
    L le(String name, String value, IgnoreStrategy ignoreStrategy);

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
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}