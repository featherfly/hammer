
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:48:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.dsl;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * QueryConfigImpl.
 *
 * @author zhongj
 */
public class DslQueryConfigImpl implements DslQueryConfig, Cloneable {

    private boolean clone;

    private boolean optimizationPage = true;  // default true

    private boolean cachePageResults = true;  // default true

    private boolean cachePageCount = true;  // default true

    private Predicate<Object> ignoreStrategy = IgnoreStrategy.EMPTY;

    /**
     * Instantiates a new query config impl.
     */
    public DslQueryConfigImpl() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        return ignoreStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionConfig setIgnoreStrategy(Predicate<Object> ignoreStrategy) {
        this.ignoreStrategy = ignoreStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslQueryConfig setPagingOptimization(boolean optimizationPage) {
        this.optimizationPage = optimizationPage;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPagingOptimization() {
        return optimizationPage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslQueryConfig clone() {
        if (clone) {
            return this;
        } else {
            DslQueryConfigImpl config = new DslQueryConfigImpl();
            config.setIgnoreStrategy(ignoreStrategy);
            config.setPagingOptimization(optimizationPage);
            config.clone = true;
            return config;
        }
    }

    @Override
    public String toString() {
        return "QueryConfigImpl [clone=" + clone + ", optimizationPage=" + optimizationPage + ", ignoreStrategy="
            + ignoreStrategy + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslQueryConfig setCachePageCount(boolean cachePageCount) {
        this.cachePageCount = cachePageCount;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCachePageCount() {
        return cachePageCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslQueryConfig setCachePageResults(boolean cachePageResults) {
        this.cachePageResults = cachePageResults;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCachePageResults() {
        return cachePageResults;
    }
}
