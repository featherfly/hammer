
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * LessThanExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface PropertyLessThanExpressoin<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * 小于
     * 
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L lt(V value);
}