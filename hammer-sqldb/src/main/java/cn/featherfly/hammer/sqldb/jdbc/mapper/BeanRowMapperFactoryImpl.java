
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-04-17 02:37:17
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import javax.annotation.Nonnull;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.mapper.BeanRowMapper.NoPropertyMatchStrategy;

/**
 * BeanRowMapperFactoryImpl.
 *
 * @author zhongj
 */
public class BeanRowMapperFactoryImpl implements BeanRowMapperFactory {

    protected final NoPropertyMatchStrategy noPropertyMatchStrategy;

    /**
     * Instantiates a new entity row mapper factory.
     */
    public BeanRowMapperFactoryImpl() {
        this(NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new entity row mapper factory.
     *
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public BeanRowMapperFactoryImpl(@Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super();
        this.noPropertyMatchStrategy = noPropertyMatchStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowMapper<T> createRowMapper(PropertyAccessor<T> type, SqlTypeMappingManager manager, String prefix) {
        // FIXME prefix 还没有实现prefix支持
        return new BeanRowMapper<>(type, manager, noPropertyMatchStrategy);
    }

}
