
package cn.featherfly.hammer.expression.condition.ge;

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
 * great equals expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge(Field name, N value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge(Field name, N value, Predicate<N> ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge(String name, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge(Field name, D value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge(Field name, D value, Predicate<D> ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge(String name, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge(Field name, LocalTime value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(String name, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge(Field name, LocalDate value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(String name, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge(Field name, LocalDateTime value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(String name, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge(Field name, String value) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(Field name, String value, Predicate<String> ignoreStrategy) {
        return ge(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(String name, String value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(String name, String value, Predicate<String> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L ge(SerializableNumberSupplier<N> property);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L ge(SerializableDateSupplier<D> property);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge(SerializableLocalTimeSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge(SerializableLocalDateSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge(SerializableLocalDateTimeSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ge(SerializableStringSupplier property);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}