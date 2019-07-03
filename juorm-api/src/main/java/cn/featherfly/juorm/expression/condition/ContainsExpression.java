
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * ContainsExpression
 * </p>
 *
 * @author zhongj
 */
public interface ContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 包含value
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L co(String name, String value);
}