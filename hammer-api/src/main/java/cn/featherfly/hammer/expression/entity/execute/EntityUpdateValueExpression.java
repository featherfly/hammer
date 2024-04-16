
package cn.featherfly.hammer.expression.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityUpdateValueExpression .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateValueExpression<E, T, U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
    C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>> {

    /**
     * Sets the.
     *
     * @param value the value
     * @return the u
     */
    U set(T value);

    /**
     * Sets the.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    default U set(T value, IgnoreStrategy ignoreStrategy) {
        return set(value, ignoreStrategy::test);
    }

    /**
     * Sets the.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    U set(T value, Predicate<T> ignoreStrategy);

    /**
     * Sets the.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<EntityUpdateValueExpression<E, T, U, C, L>> consumer);
}
