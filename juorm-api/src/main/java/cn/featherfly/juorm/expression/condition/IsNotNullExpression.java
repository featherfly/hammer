
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * IsNotNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface IsNotNullExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * is not null
     *
     * @param name
     *            参数名称
     * @return LogicExpression
     */
    L inn(String name);
}