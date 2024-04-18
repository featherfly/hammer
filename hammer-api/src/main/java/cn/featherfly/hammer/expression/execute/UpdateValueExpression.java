
package cn.featherfly.hammer.expression.execute;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * update value .
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <T> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface UpdateValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, N>,
    C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
    L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>, T,
    V extends UpdateValueExpression<U, C, L, Object, V, N>,
    N extends UpdateNumberValueExpression<U, C, L, Number, V, N>> {

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
}
