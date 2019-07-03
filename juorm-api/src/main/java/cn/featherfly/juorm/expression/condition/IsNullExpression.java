
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * IsNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface IsNullExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * is null.
     *
     * @param name
     *            参数名称
     * @return LogicExpression
     */
    L isn(String name);
}