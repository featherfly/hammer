
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 01:08:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.cache;

import javax.cache.Cache;

import cn.featherfly.common.repository.QueryPageResult;

/**
 * CacheConfigImpl.
 *
 * @author zhongj
 */
public class CacheConfigImpl implements CacheConfig {

    private Cache<Object, QueryPageResult> queryPageResultCache;

    /**
     * Sets the query page result cache.
     *
     * @param queryPageResultCache the query page result cache
     * @return the cache config impl
     */
    public CacheConfigImpl setQueryPageResultCache(Cache<Object, QueryPageResult> queryPageResultCache) {
        this.queryPageResultCache = queryPageResultCache;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cache<Object, QueryPageResult> getQueryPageResultCache() {
        return queryPageResultCache;
    }

}
