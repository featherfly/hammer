
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * condition expression.
 *
 * @author zhongj
 */
public interface ConditionsGroupExpression<C extends ConditionsGroupExpression<C, L>, L extends LogicExpression<C, L>>
        extends ConditionsExpression<C, L>, GroupExpression<C, L> {

}
