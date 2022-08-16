
package cn.featherfly.hammer.expression;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.RepositoryLogicGroupExpression;

/**
 * ConditionGroupLogicExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionGroupLogicExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> extends RepositoryLogicGroupExpression<C, L> {
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
     * @return the RepositoryConditionGroupLogicExpression
     */
    C setIgnorePolicy(Predicate<Object> ignorePolicy);
}
