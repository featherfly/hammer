
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.StringSupplier;
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
    <T, N extends Number> L le(ReturnNumberFunction<T, N> name, N value);

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
    <T, D extends Date> L le(ReturnDateFunction<T, D> name, D value);

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
    <T> L le(ReturnLocalTimeFunction<T> name, LocalTime value);

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
    <T> L le(ReturnLocalDateFunction<T> name, LocalDate value);

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
    <T> L le(ReturnLocalDateTimeFunction<T> name, LocalDateTime value);

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
    <T> L le(ReturnStringFunction<T> name, String value);

    /**
     * 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le(DateSupplier<R> property);

    /**
     * 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le(NumberSupplier<R> property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalDateSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalTimeSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(LocalDateTimeSupplier property);

    /**
     * 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(StringSupplier property);
}