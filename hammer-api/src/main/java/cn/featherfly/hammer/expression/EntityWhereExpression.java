
package cn.featherfly.hammer.expression;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;

/**
 * The Interface EntityWhereExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityWhereExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> {
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
    C where(Consumer<ConditionGroupConfig<C>> consumer);
}
