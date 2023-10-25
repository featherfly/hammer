
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:50:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

import java.util.function.Predicate;

/**
 * ConditionConfig.
 *
 * @author zhongj
 * @param <C> the generic type
 */
public interface ConditionConfig<C extends ConditionConfig<C>> {
    /**
     * Gets the ignore strategy.
     *
     * @return the ignore strategy
     */
    Predicate<Object> getIgnoreStrategy();

    /**
     * Sets the ignore strategy.
     *
     * @param ignoreStrategy the new ignore strategy
     * @return the ConditionGroupConfig
     */
    C setIgnoreStrategy(Predicate<Object> ignoreStrategy);
}
