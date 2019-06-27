
package cn.featherfly.juorm.expression;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface EqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L eq(String name, Object value);
}