
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:48:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.config.dsl.QueryConfig;

/**
 * QueryConfigImpl.
 *
 * @author zhongj
 */
public class QueryConfigImpl implements QueryConfig, Cloneable {

    private boolean clone;

    private boolean optimizationPage = true;  // default true

    private Predicate<Object> ignoreStrategy = IgnoreStrategy.EMPTY;

    /**
     * Instantiates a new query config impl.
     */
    public QueryConfigImpl() {
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
    public QueryConfig setPagingOptimization(boolean optimizationPage) {
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
    public QueryConfig clone() {
        if (clone) {
            return this;
        } else {
            QueryConfigImpl config = new QueryConfigImpl();
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

}
