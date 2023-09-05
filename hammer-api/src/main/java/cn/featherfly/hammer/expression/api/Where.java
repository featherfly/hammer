
package cn.featherfly.hammer.expression.api;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;

/**
 * WhereExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 */
public interface Where<C> {
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
