
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface IExecutableUpdate<C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> extends IUpdate, Executor {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
