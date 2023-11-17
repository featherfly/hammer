
package cn.featherfly.hammer.expression.condition.gt;

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
 * great than expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field name, N value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field name, N value, Predicate<N> ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field name, D value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field name, D value, Predicate<D> ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field name, LocalTime value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field name, LocalDate value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field name, LocalDateTime value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field name, String value) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field name, String value, Predicate<String> ignoreStrategy) {
        return gt(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, String value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, String value, Predicate<String> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableNumberSupplier<N> property);

    /**
     * great than. 大于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableDateSupplier<D> property);

    /**
     * great than. 大于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt(SerializableLocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt(SerializableLocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt(SerializableLocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L gt(SerializableStringSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}