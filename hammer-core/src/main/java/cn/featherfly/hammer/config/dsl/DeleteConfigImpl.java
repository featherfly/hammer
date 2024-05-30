
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
 * The Class DeleteConfigImpl.
 *
 * @author zhongj
 */
public class DeleteConfigImpl implements DeleteConfig, Cloneable {

    private boolean clone;

    private Predicate<Object> ignoreStrategy = IgnoreStrategy.EMPTY;

    private EmptyConditionStrategy emptyConditionStrategy = EmptyConditionStrategy.NON_EXECUTION;

    /**
     * Instantiates a new delete config impl.
     */
    public DeleteConfigImpl() {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "DeleteConfigImpl [clone=" + clone + ", ignoreStrategy=" + ignoreStrategy + ", emptyConditionStrategy="
            + emptyConditionStrategy + "] " + super.toString();
    }
}
