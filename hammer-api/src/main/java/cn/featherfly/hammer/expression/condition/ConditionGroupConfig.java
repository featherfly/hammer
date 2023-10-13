package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * ConditionGroupConfig.
 *
 * @author zhongj
 */
public interface ConditionGroupConfig<C> {
    /**
     * Gets the ignore strategy.
     *
     * @return the ignore strategy
     */
    Predicate<?> getIgnoreStrategy();

    /**
     * Sets the ignore strategy.
     *
     * @param ignoreStrategy the new ignore strategy
     * @return the ConditionGroupConfig
     */
    C setIgnoreStrategy(Predicate<?> ignoreStrategy);
}
