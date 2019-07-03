
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * GreatEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface PropertyGreatEqualsExpressoin<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * 大于等于
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ge(V value);
}