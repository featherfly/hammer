
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:52:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

/**
 * The Interface ExecuteConditionConfig.
 *
 * @author zhongj
 * @param <C> the generic type
 */
public interface ExecutableConditionConfig<C extends ExecutableConditionConfig<C>> extends ConditionConfig<C> {

    /**
     * Gets the empty condition strategy.
     *
     * @return the empty condition strategy
     */
    EmptyConditionStrategy getEmptyConditionStrategy();

    /**
     * Sets the empty condition strategy.
     *
     * @param emptyConditionStrategy the empty condition strategy
     * @return the c
     */
    C setEmptyConditionStrategy(EmptyConditionStrategy emptyConditionStrategy);
}
