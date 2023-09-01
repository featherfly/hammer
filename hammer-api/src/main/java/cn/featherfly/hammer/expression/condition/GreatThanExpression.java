
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
 * GreatThanExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field name, N value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L gt(SerializableToNumberFunction<T, N> name, N value);

    /**
     * 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field name, D value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L gt(SerializableToDateFunction<T, D> name, D value);

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L gt(Field name, LocalTime value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalTime value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L gt(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L gt(Field name, LocalDate value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalDate value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L gt(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L gt(Field name, LocalDateTime value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L gt(Field name, String value) {
        return gt(name.name(), value);
    }

    /**
     * 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt(String name, String value);

    /**
     * 大于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L gt(SerializableToStringFunction<T> name, String value);

    /**
     * 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt(SerializableNumberSupplier<R> property);

    /**
     * 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt(SerializableDateSupplier<R> property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(SerializableLocalDateSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(SerializableLocalTimeSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(SerializableLocalDateTimeSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(SerializableStringSupplier property);
}