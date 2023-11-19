
package cn.featherfly.hammer.expression.condition.lt;

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
 * less than expression .
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
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field field, N value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(Field field, N value, Predicate<N> ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(String name, N value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field field, D value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(Field field, D value, Predicate<D> ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(String name, D value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(Field field, LocalTime value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(String name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(Field field, LocalDate value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(String name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(Field field, LocalDateTime value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(Field field, String value) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(Field field, String value, Predicate<String> ignoreStrategy) {
        return lt(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(String name, String value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lt(name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(String name, String value, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt(AliasField field, N value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt(AliasField field, D value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalTime value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDate value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDateTime value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(AliasField field, String value) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return lt(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return lt(field.getAliasOrName(), value);
    }

    // ****************************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <N>      the number type
     * @param property bean property
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableNumberSupplier<N> property);

    /**
     * less than. 小于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            the number type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableDateSupplier<D> property);

    /**
     * less than. 小于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lt(property, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}