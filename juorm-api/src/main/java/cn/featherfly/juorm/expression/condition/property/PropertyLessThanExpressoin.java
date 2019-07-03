
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

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