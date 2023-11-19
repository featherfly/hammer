
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
import cn.featherfly.common.repository.AliasField;
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
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L le(Field field, N value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(Field field, N value, Predicate<N> ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(String name, N value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L le(Field field, D value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(Field field, D value, Predicate<D> ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(String name, D value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(Field field, LocalTime value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(Field field, LocalDate value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(Field field, LocalDateTime value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(field.name(), value, ignoreStrategy);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(Field field, String value) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return le(field.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(Field field, String value, Predicate<String> ignoreStrategy) {
        return le(field.name(), value);
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
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(String name, String value, IgnoreStrategy ignoreStrategy) {
        return le(name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(String name, String value, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L le(AliasField field, N value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L le(AliasField field, D value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(AliasField field, LocalTime value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDate value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDateTime value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L le(AliasField field, String value) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return le(field.getAliasOrName(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return le(field.getAliasOrName(), value);
    }

    // ****************************************************************************************************************************

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
    default <N extends Number> L le(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<N>) ignoreStrategy::test);
    }

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
    default <D extends Date> L le(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<D>) ignoreStrategy::test);
    }

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
    default L le(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

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
    default L le(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

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
    default L le(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

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
    default L le(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return le(property, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less equals. 小于等于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}