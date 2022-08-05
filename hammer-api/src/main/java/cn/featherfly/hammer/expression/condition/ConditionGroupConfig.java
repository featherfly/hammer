package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * ConditionGroupConfig.
 *
 * @author zhongj
 */
public interface ConditionGroupConfig {
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
    ConditionGroupConfig setIgnorePolicy(Predicate<Object> ignorePolicy);
}
