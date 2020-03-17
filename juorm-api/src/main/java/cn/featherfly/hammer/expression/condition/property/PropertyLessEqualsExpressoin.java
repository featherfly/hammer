
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * LessEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface PropertyLessEqualsExpressoin<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * 小于等于
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L le(V value);
}