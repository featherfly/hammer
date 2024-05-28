
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
import cn.featherfly.hammer.config.dsl.EmptyConditionStrategy;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;

/**
 * The Class UpdateConfigImpl.
 *
 * @author zhongj
 */
public class UpdateConfigImpl implements UpdateConfig, Cloneable {

    private boolean clone;

    private Predicate<Object> ignoreStrategy = IgnoreStrategy.EMPTY;

    private Predicate<Object> setValueIgnoreStrategy = IgnoreStrategy.NONE;

    private EmptyConditionStrategy emptyConditionStrategy = EmptyConditionStrategy.NON_EXECUTION;

    /**
     * Instantiates a new query config impl.
     */
    public UpdateConfigImpl() {
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
    public UpdateConditionConfig setIgnoreStrategy(Predicate<Object> ignoreStrategy) {
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
    public UpdateConditionConfig setEmptyConditionStrategy(EmptyConditionStrategy emptyConditionStrategy) {
        this.emptyConditionStrategy = emptyConditionStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateConfig setSetValueIgnoreStrategy(Predicate<Object> setValueIgnoreStrategy) {
        this.setValueIgnoreStrategy = setValueIgnoreStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getSetValueIgnoreStrategy() {
        return setValueIgnoreStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateConfig clone() {
        if (clone) {
            return this;
        } else {
            UpdateConfigImpl config = new UpdateConfigImpl();
            config.setEmptyConditionStrategy(emptyConditionStrategy);
            config.setIgnoreStrategy(ignoreStrategy);
            config.setSetValueIgnoreStrategy(setValueIgnoreStrategy);
            config.clone = true;
            return config;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UpdateConfigImpl [clone=" + clone + ", ignoreStrategy=" + ignoreStrategy + ", setValueIgnoreStrategy="
            + setValueIgnoreStrategy + ", emptyConditionStrategy=" + emptyConditionStrategy + "] " + super.toString();
    }
}
