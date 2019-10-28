
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L eq(String name, Object value);

    /**
     * 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L eq(SerializableFunction<T, R> name, Object value);
}