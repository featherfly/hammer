
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * StartWithExpression
 * </p>
 *
 * @author zhongj
 */
public interface StartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 以value开始
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L sw(String name, String value);
}