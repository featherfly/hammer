
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * Delete
 * </p>
 *
 * @author zhongj
 */
public interface Delete<C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
