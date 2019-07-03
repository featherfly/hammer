
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * StartWithExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyStartWithExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 以value开始
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L sw(String value);
}