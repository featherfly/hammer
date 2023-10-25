
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
 * The Interface UpdateConfig.
 *
 * @author zhongj
 */
public interface UpdateConfig extends DslConfigBase<UpdateConfig, UpdateConditionConfig>, UpdateConditionConfig {

    /**
     * Sets the set value ignore strategy.
     *
     * @param setValueIgnoreStrategy the set value ignore strategy
     * @return the update config
     */
    UpdateConfig setSetValueIgnoreStrategy(Predicate<Object> setValueIgnoreStrategy);

    /**
     * Gets the sets the value ignore strategy.
     *
     * @return the sets the value ignore strategy
     */
    Predicate<Object> getSetValueIgnoreStrategy();
}
