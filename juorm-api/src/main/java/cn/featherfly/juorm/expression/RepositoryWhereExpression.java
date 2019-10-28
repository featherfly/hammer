
package cn.featherfly.juorm.expression;

import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * WhereExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryWhereExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> {
    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
