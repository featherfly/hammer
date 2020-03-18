
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * GreatEqualsExpressoin
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

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
     * @param <R>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L ge(SerializableFunction<T, R> name, N value);

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
     * @param <R>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L ge(SerializableFunction<T, R> name, D value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> name, LocalTime value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> name, LocalDate value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> name, LocalDateTime value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ge(SerializableFunction<T, R> name, String value);
}