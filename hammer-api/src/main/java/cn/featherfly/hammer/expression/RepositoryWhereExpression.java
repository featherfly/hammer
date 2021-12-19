
package cn.featherfly.hammer.expression;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * RepositoryWhereExpression.
 *
 * @author zhongj
 */
public interface RepositoryWhereExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> {
    /**
     * 进入条件表达式.
     *
     * @return QueryCondition
     */
    C where();

    /**
     * 进入条件表达式.
     *
     * @param consumer the consumer
     * @return QueryCondition
     */
    C where(Consumer<C> consumer);
}
