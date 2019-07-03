
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface SetExecutableUpdateExpression<U extends SetExecutableUpdateExpression<U, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends SetUpdateExpression<U, C, L>, Executor {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
