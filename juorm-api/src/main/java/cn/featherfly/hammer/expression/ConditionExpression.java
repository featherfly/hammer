
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionsExpression;

/**
 * <p>
 * Condition Expression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionExpression<C extends ConditionExpression<C, L>, L extends ConditionLogicExpression<C, L>>
        extends ConditionsExpression<C, L> {
}
