
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 01:08:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.cache;

import javax.cache.Cache;

/**
 * CacheConfigImpl.
 *
 * @author zhongj
 */
public class CacheConfigImpl implements CacheConfig {

    private Cache<Object, Integer> countResultCache;

    /**
     * set countResultCache value.
     *
     * @param countResultCache countResultCache
     * @return the cache config impl
     */
    public CacheConfigImpl setCountResultCache(Cache<Object, Integer> countResultCache) {
        this.countResultCache = countResultCache;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cache<Object, Integer> getCountResultCache() {
        return countResultCache;
    }

}
