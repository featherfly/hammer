
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-30 23:00:30
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.tpl;

/**
 * TemplateQueryConfigImpl.
 *
 * @author zhongj
 */
public class TemplateQueryConfigImpl implements TemplateQueryConfig {

    private boolean cachePageResults = true;  // default true

    private boolean cachePageCount = true;  // default true

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateQueryConfig setCachePageCount(boolean cachePageCount) {
        this.cachePageCount = cachePageCount;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateQueryConfig setCachePageResults(boolean cachePageResults) {
        this.cachePageResults = cachePageResults;
        return this;
    }

    @Override
    public boolean isCachePageResults() {
        return cachePageResults;
    }

    @Override
    public boolean isCachePageCount() {
        return cachePageCount;
    }

}
