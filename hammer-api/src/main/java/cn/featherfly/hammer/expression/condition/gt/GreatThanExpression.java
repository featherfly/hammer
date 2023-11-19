
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
import cn.featherfly.common.repository.AliasField;
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
    default <N extends Number> L gt(Field field, N value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field field, N value, Predicate<N> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(String name, N value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name
     * @param value
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
    default <D extends Date> L gt(Field field, D value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field field, D value, Predicate<D> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(String name, D value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name
     * @param value
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
    default L gt(Field field, LocalTime value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
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
    default L gt(Field field, LocalDate value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
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
    default L gt(Field field, LocalDateTime value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
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
    default L gt(Field field, String value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, Predicate<String> ignoreStrategy) {
        return gt(field.name(), value);
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
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, String value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, String value, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, String value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name
     * @param value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return gt(field.getAliasOrName(), value);
    }

    // ****************************************************************************************************************************

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
    default <N extends Number> L gt(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<N>) ignoreStrategy::test);
    }

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
    default <D extends Date> L gt(SerializableDateSupplier<D> property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<D>) ignoreStrategy::test);
    }

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
    default L gt(SerializableLocalTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<LocalTime>) ignoreStrategy::test);
    }

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
    default L gt(SerializableLocalDateSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<LocalDate>) ignoreStrategy::test);
    }

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
    default L gt(SerializableLocalDateTimeSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

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
    default L gt(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return gt(property, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}