
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.LogicGroupExpression;

/**
 * ConditionGroupLogicExpression.
 *
 * @author zhongj
 */
public interface ConditionGroupLogicExpression<C extends ConditionsGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends LogicGroupExpression<C, L> {

}
