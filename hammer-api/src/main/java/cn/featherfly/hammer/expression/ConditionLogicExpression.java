
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * ConditionLogicExpression.
 *
 * @author zhongj
 */
public interface ConditionLogicExpression<C extends ConditionExpression, L extends ConditionLogicExpression<C, L>>
        extends LogicExpression<C, L> {

}
