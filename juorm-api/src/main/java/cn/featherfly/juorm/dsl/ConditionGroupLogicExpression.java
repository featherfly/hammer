
package cn.featherfly.juorm.dsl;

import cn.featherfly.juorm.expression.LogicGroupExpression;

/**
 * <p>
 * ConditionGroupLogicExpression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupLogicExpression<C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends LogicGroupExpression<C, L> {

}
