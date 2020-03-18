
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * NotEqualsExpressoin
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not equals.不等于
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne(String name, Object value);

    /**
     * not equals.不等于
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L ne(SerializableFunction<T, R> name, Object value);
}