
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * PropertyLikeExpression.
 *
 * @author zhongj
 */
public interface PropertyLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L lk(String value);
}