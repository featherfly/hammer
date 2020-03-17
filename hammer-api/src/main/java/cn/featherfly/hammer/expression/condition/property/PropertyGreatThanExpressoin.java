
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * GreatThanExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface PropertyGreatThanExpressoin<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * 大于
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L gt(V value);
}