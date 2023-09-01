
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
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
     * 小于等于.
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
     * 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le(String name, N value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L le(SerializableToNumberFunction<T, N> name, N value);

    /**
     * 小于等于.
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
     * 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le(String name, D value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L le(SerializableToDateFunction<T, D> name, D value);

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalTime value) {
        return le(name.name(), value);
    }

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalTime value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalDate value) {
        return le(name.name(), value);
    }

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalDate value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, LocalDateTime value) {
        return le(name.name(), value);
    }

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, LocalDateTime value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le(Field name, String value) {
        return le(name.name(), value);
    }

    /**
     * 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le(String name, String value);

    /**
     * 小于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L le(SerializableToStringFunction<T> name, String value);

    /**
     * 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le(SerializableDateSupplier<R> property);

    /**
     * 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le(SerializableNumberSupplier<R> property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalDateSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalTimeSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableLocalDateTimeSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(SerializableStringSupplier property);
}