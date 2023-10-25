
package cn.featherfly.hammer.expression.execute;

import java.util.function.Predicate;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * update number value .
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <T> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface UpdateNumberValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, N>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>, T extends Number,
        V extends UpdateValueExpression<U, C, L, Object, V, N>,
        N extends UpdateNumberValueExpression<U, C, L, Number, V, N>> extends UpdateValueExpression<U, C, L, T, V, N> {

    /**
     * Increase.
     *
     * @param value the value
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(T value);

    /**
     * Increase.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(T value, Predicate<T> ignoreStrategy);
}
