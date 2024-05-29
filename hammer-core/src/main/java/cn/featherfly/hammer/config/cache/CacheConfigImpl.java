
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 01:08:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.cache;

import javax.cache.Cache;

import cn.featherfly.common.repository.QueryPageResults;

/**
 * CacheConfigImpl.
 *
 * @author zhongj
 */
public class CacheConfigImpl implements CacheConfig {

    private Cache<Object, QueryPageResults> countResultCache;

    /**
     * set countResultCache value.
     *
     * @param countResultCache countResultCache
     * @return the cache config impl
     */
    public CacheConfigImpl setCountResultCache(Cache<Object, QueryPageResults> countResultCache) {
        this.countResultCache = countResultCache;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cache<Object, QueryPageResults> getCountResultCache() {
        return countResultCache;
    }

}
