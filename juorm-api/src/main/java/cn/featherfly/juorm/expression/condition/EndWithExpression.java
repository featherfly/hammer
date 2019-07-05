
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * EndWithExpression
 * </p>
 *
 * @author zhongj
 */
public interface EndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 以value结尾
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ew(String name, String value);
}