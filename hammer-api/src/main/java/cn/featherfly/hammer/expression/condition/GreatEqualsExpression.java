
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.repository.Field;

/**
 * GreatEqualsExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <N extends Number> L ge(Field name, N value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L ge(String name, N value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value);

    /**
     * 大于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <D extends Date> L ge(Field name, D value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L ge(String name, D value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value);

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ge(Field name, LocalTime value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(String name, LocalTime value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ge(Field name, LocalDate value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(String name, LocalDate value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ge(Field name, LocalDateTime value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(String name, LocalDateTime value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ge(Field name, String value) {
        return ge(name.name(), value);
    }

    /**
     * 大于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ge(String name, String value);

    /**
     * 大于等于.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T> L ge(SerializableToStringFunction<T> name, String value);

    /**
     * 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ge(SerializableDateSupplier<R> property);

    /**
     * 大于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ge(SerializableNumberSupplier<R> property);

    /**
     * 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(SerializableLocalDateSupplier property);

    /**
     * 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(SerializableLocalTimeSupplier property);

    /**
     * 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(SerializableLocalDateTimeSupplier property);

    /**
     * 大于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(SerializableStringSupplier property);
}