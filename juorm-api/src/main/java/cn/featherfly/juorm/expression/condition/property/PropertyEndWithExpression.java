
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * EndWithExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyEndWithExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 以value结尾
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ew(String value);
}