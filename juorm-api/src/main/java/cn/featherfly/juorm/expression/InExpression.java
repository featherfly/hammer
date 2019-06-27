
package cn.featherfly.juorm.expression;

/**
 * <p>
 * InExpression
 * </p>
 *
 * @author zhongj
 */
public interface InExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 包含指定，sql中的in
     *
     * @param name
     *            参数名称
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L in(String name, Object value);
}