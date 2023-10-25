
package cn.featherfly.hammer.expression.api;

import java.util.function.Consumer;

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
    C where(Consumer<C> consumer);
}
