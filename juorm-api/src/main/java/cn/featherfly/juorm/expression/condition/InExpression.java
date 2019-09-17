
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * InExpression
 * </p>
 *
 * @author zhongj
 */
public interface InExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 包含指定，sql中的in
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in(String name, Object value);

    /**
     * 包含指定，sql中的in
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, R> L in(SerializableFunction<T, R> name, Object value);
}