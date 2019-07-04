
package cn.featherfly.juorm.expression;

import cn.featherfly.juorm.expression.condition.ConditionsGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * *ConditionGroupLogicExpression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupLogicExpression<C extends ConditionsGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends LogicGroupExpression<C, L> {

}
