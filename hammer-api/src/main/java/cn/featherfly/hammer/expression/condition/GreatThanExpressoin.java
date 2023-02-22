
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
 * GreatThanExpressoin .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
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
    <T, N extends Number> L gt(ReturnNumberFunction<T, N> name, N value);

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
    <T, D extends Date> L gt(ReturnDateFunction<T, D> name, D value);

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
    <T> L gt(ReturnLocalTimeFunction<T> name, LocalTime value);

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
    <T> L gt(ReturnLocalDateFunction<T> name, LocalDate value);

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
    <T> L gt(ReturnLocalDateTimeFunction<T> name, LocalDateTime value);

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
    <T> L gt(ReturnStringFunction<T> name, String value);

    /**
     * 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt(NumberSupplier<R> property);

    /**
     * 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt(DateSupplier<R> property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalDateSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalTimeSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(LocalDateTimeSupplier property);

    /**
     * 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt(StringSupplier property);
}