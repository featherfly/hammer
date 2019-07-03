
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * NotEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface NotEqualsExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * not equals.不等于
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ne(String name, Object value);
}