
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Delete
 * </p>
 *
 * @author zhongj
 */
public interface DeleteExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
