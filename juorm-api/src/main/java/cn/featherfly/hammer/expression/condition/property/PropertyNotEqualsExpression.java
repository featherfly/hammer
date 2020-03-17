
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * NotEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface PropertyNotEqualsExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>, V> extends ConditionExpression {

    /**
     * not equals.不等于
     *
     * @param value
     *            参数值
     * @return LogicExpression
     */
    L ne(V value);
}