
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
 * LessThanExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 小于.
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
     * 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L lt(String name, N value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value);

    /**
     * 小于.
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
     * 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L lt(String name, D value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value);

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalTime value) {
        return lt(name.name(), value);
    }

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalTime value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalDate value) {
        return lt(name.name(), value);
    }

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDate value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, LocalDateTime value) {
        return lt(name.name(), value);
    }

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, LocalDateTime value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lt(Field name, String value) {
        return lt(name.name(), value);
    }

    /**
     * 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt(String name, String value);

    /**
     * 小于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value);

    /**
     * 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt(SerializableDateSupplier<R> property);

    /**
     * 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt(SerializableNumberSupplier<R> property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalDateSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalTimeSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableLocalDateTimeSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(SerializableStringSupplier property);
}