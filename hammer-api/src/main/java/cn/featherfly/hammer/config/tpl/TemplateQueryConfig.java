
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-30 22:59:30
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.tpl;

import cn.featherfly.hammer.config.QueryConfig;

/**
 * TemplateQueryConfig.
 *
 * @author zhongj
 */
public interface TemplateQueryConfig extends QueryConfig {

    /**
     * get cachePageResults value
     *
     * @return cachePageResults
     */
    boolean isCachePageResults();

    /**
     * get cachePageCount value.
     *
     * @return cachePageCount
     */
    boolean isCachePageCount();

}
