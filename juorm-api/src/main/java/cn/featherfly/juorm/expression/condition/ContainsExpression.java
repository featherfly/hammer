
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * ContainsExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L co(String name, String value);

    /**
     * 包含value.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L co(SerializableFunction<T, R> name, String value);
}