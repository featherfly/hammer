
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:52:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

import cn.featherfly.hammer.config.QueryConfig;

/**
 * The Interface QueryConfig.
 *
 * @author zhongj
 */
public interface DslQueryConfig
    extends DslConfigBase<DslQueryConfig, QueryConditionConfig>, QueryConditionConfig, QueryConfig<DslQueryConfig> {

    /**
     * Sets the paging optimization.
     *
     * @param pagingOptimization the paging optimization
     * @return the query config
     */
    DslQueryConfig setPagingOptimization(boolean pagingOptimization);

    /**
     * Checks if is paging optimization.
     *
     * @return true, if is paging optimization
     */
    boolean isPagingOptimization();

    /**
     * Checks if is cache page count.
     *
     * @return true, if is cache page count
     */
    boolean isCachePageCount();

    /**
     * Checks if is cache page results.
     *
     * @return true, if is cache page results
     */
    boolean isCachePageResults();
}
