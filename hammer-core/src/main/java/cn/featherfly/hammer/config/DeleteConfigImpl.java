
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
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.config.dsl.EmptyConditionStrategy;

/**
 * The Class DeleteConfigImpl.
 *
 * @author zhongj
 */
public class DeleteConfigImpl implements DeleteConfig, Cloneable {

    private boolean clone;

    private Predicate<Object> ignoreStrategy = IgnoreStrategy.EMPTY;

    private EmptyConditionStrategy emptyConditionStrategy = EmptyConditionStrategy.NON_EXECUTION;

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
    public DeleteConditionConfig setIgnoreStrategy(Predicate<Object> ignoreStrategy) {
        this.ignoreStrategy = ignoreStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmptyConditionStrategy getEmptyConditionStrategy() {
        return emptyConditionStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteConditionConfig setEmptyConditionStrategy(EmptyConditionStrategy emptyConditionStrategy) {
        this.emptyConditionStrategy = emptyConditionStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteConfig clone() {
        if (clone) {
            return this;
        } else {
            DeleteConfigImpl config = new DeleteConfigImpl();
            config.setEmptyConditionStrategy(emptyConditionStrategy);
            config.setIgnoreStrategy(ignoreStrategy);
            config.clone = true;
            return config;
        }
    }

    @Override
    public String toString() {
        return "DeleteConfigImpl [clone=" + clone + ", ignoreStrategy=" + ignoreStrategy + ", emptyConditionStrategy="
                + emptyConditionStrategy + "] " + super.toString();
    }
}
