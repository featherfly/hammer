
package cn.featherfly.hammer.expression;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;

/**
 * <p>
 * WhereExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface WhereExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> {
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
    C where(Consumer<ConditionGroupConfig> consumer);
}
