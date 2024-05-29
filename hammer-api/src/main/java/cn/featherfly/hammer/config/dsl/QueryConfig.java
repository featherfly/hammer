
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 15:52:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

/**
 * The Interface QueryConfig.
 *
 * @author zhongj
 */
public interface QueryConfig extends DslConfigBase<QueryConfig, QueryConditionConfig>, QueryConditionConfig {
    /**
     * Sets the paging optimization.
     *
     * @param pagingOptimization the paging optimization
     * @return the query config
     */
    QueryConfig setPagingOptimization(boolean pagingOptimization);

    /**
     * Checks if is paging optimization.
     *
     * @return true, if is paging optimization
     */
    boolean isPagingOptimization();
}
