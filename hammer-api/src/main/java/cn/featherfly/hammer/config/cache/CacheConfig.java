
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 01:06:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.cache;

import javax.cache.Cache;

/**
 * CacheConfig.
 *
 * @author zhongj
 */
public interface CacheConfig {
    /**
     * Gets the count result cache.
     *
     * @return the count result cache
     */
    Cache<Object, Integer> getCountResultCache();
}
