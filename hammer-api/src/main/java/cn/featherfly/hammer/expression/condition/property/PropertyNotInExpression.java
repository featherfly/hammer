
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * NotInExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyNotInExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * 不包含指定，sql中的not in
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L nin(V value);
}