
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
    <T, N extends Number> L lt(ReturnNumberFunction<T, N> name, N value);

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
    <T, D extends Date> L lt(ReturnDateFunction<T, D> name, D value);

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
    <T> L lt(ReturnLocalTimeFunction<T> name, LocalTime value);

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
    <T> L lt(ReturnLocalDateFunction<T> name, LocalDate value);

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
    <T> L lt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value);

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
    <T> L lt(ReturnStringFunction<T> name, String value);

    /**
     * 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt(DateSupplier<R> property);

    /**
     * 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt(NumberSupplier<R> property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalDateSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalTimeSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(LocalDateTimeSupplier property);

    /**
     * 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(StringSupplier property);
}