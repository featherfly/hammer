
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * PropertyConditionExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyConditionsExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        extends PropertyExpression<C, L> {

}
