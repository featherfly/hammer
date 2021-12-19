
package cn.featherfly.hammer.expression;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionsGroupExpression;

/**
 * <p>
 * ConditionGroupExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionGroupExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends ConditionsGroupExpression<C, L> {

    /**
     * Gets the ignore policy.
     *
     * @return the ignore policy
     */
    Predicate<Object> getIgnorePolicy();

    /**
     * Sets the ignore policy.
     *
     * @param ignorePolicy the new ignore policy
     * @return the ConditionGroupExpression
     */
    C setIgnorePolicy(Predicate<Object> ignorePolicy);
}
