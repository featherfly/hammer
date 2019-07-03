
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * IsNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyIsNullExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends ConditionExpression {

    /**
     * is not null
     *
     * @return LogicExpression
     */
    L isn();
}