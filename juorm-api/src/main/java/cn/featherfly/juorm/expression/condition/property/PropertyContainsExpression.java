
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * ContainsExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyContainsExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * 包含value
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L co(String value);
}