
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-30 22:39:30
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

/**
 * QueryConfig.
 *
 * @author zhongj
 */
public interface QueryConfig<Q extends QueryConfig<Q>> {

    /**
     * Sets the cache page count.
     *
     * @param cachePageCount the cache page count
     * @return the query config
     */
    Q setCachePageCount(boolean cachePageCount);

    /**
     * Sets the cache page results.
     *
     * @param cachePageResults the cache page results
     * @return the query config
     */
    Q setCachePageResults(boolean cachePageResults);
}
