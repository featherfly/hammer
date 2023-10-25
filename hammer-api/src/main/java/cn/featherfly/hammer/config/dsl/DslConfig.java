
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:52:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

import java.util.function.Predicate;

/**
 * The Interface DslConfigs.
 *
 * @author zhongj
 */
public interface DslConfig {

    /**
     * Sets the ignore strategy.
     *
     * @param ignoreStrategy the new ignore strategy
     * @return the ConditionGroupConfig
     */
    default DslConfig setIgnoreStrategy(Predicate<Object> ignoreStrategy) {
        getQueryConfig().setIgnoreStrategy(ignoreStrategy);
        getUpdateConfig().setIgnoreStrategy(ignoreStrategy);
        getDeleteConfig().setIgnoreStrategy(ignoreStrategy);
        return this;
    }

    /**
     * Sets the empty condition strategy.
     *
     * @param emptyConditionStrategy the empty condition strategy
     * @return the dsl config
     */
    default DslConfig setEmptyConditionStrategy(EmptyConditionStrategy emptyConditionStrategy) {
        getUpdateConfig().setEmptyConditionStrategy(emptyConditionStrategy);
        getDeleteConfig().setEmptyConditionStrategy(emptyConditionStrategy);
        return this;
    }

    /**
     * Gets the query config.
     *
     * @return the query config
     */
    QueryConfig getQueryConfig();

    /**
     * Gets the update config.
     *
     * @return the update config
     */
    UpdateConfig getUpdateConfig();

    /**
     * Gets the delete config.
     *
     * @return the delete config
     */
    DeleteConfig getDeleteConfig();
}
