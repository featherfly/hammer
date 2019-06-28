
package cn.featherfly.juorm.dsl;

import cn.featherfly.juorm.expression.ConditionExpression;
import cn.featherfly.juorm.expression.LogicExpression;

/***
 * <p>
 * ConditionLogicExpression
 * </p>
 * 
 * @author zhongj
 */
public interface ConditionLogicExpression<C extends ConditionExpression, L extends ConditionLogicExpression<C, L>>
        extends LogicExpression<C, L> {

}
