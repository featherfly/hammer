
package cn.featherfly.juorm.expression;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * ConditionLogicExpression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionLogicExpression<C extends ConditionExpression, L extends ConditionLogicExpression<C, L>>
        extends LogicExpression<C, L> {

}
