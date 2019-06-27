
package cn.featherfly.juorm.dsl;

import cn.featherfly.juorm.expression.ConditionsExpression;

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
