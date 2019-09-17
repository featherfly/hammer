
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * IsNotNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface IsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    L inn(String name);

    /**
     * is not null
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    <T, R> L inn(SerializableFunction<T, R> name);
}