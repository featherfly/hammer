
package cn.featherfly.hammer.expression.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EntityUpdateValueExpression .
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateValueExpression<T, U, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * set value.
     *
     * @param value the value
     * @return the u
     */
    U set(T value);

    /**
     * set value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    default U set(T value, IgnoreStrategy ignoreStrategy) {
        return set(value, ignoreStrategy::test);
    }

    /**
     * set value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    U set(T value, Predicate<T> ignoreStrategy);

    /**
     * set value.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<EntityUpdateValueExpression<T, U, C, L>> consumer);
}
