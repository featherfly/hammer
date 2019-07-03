
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

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