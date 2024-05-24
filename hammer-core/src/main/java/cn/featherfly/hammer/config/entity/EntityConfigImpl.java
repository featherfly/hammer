
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 15:18:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * EntityConfigImpl.
 *
 * @author zhongj
 */
public class EntityConfigImpl implements EntityConfig {

    private int batchSize = 2000;

    private final OperatorConfig insert = new OperatorConfigImpl(batchSize);
    private final OperatorConfig update = new OperatorConfigImpl(batchSize);
    private final OperatorConfig delete = new OperatorConfigImpl(batchSize);
    private final Set<String> basePackages = new HashSet<>(0);

    /**
     */
    public EntityConfigImpl() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityConfig setBasePackages(Set<String> basePackages) {
        this.basePackages.clear();
        this.basePackages.addAll(basePackages);
        return this;
    }

    /**
     * get basePackages value
     *
     * @return basePackages
     */
    @Override
    public String[] getBasePackages() {
        return basePackages.toArray(new String[basePackages.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityConfig setBatchSize(int batchSize) {
        this.batchSize = batchSize;
        insert.setBatchSize(batchSize);
        update.setBatchSize(batchSize);
        delete.setBatchSize(batchSize);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatorConfig getInsert() {
        return insert;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatorConfig getUpdate() {
        return update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatorConfig getDelete() {
        return delete;
    }
}
