
package cn.featherfly.juorm.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * LessEqualsExpressoin
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessEqualsExpressoin<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

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
     * @param <R>   the generic type
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R, N extends Number> L le(SerializableFunction<T, R> name, N value);

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
     * @param <R>   the generic type
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R, D extends Date> L le(SerializableFunction<T, R> name, D value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> name, LocalTime value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> name, LocalDate value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> name, LocalDateTime value);

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
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L le(SerializableFunction<T, R> name, String value);
}