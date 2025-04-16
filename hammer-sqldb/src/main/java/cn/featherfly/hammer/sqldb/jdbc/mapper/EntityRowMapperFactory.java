
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
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.mapper.BeanAccessorRowMapper.NoPropertyMatchStrategy;

/**
 * EntityRowMapperFactory.
 *
 * @author zhongj
 */
public class EntityRowMapperFactory implements BeanRowMapperFactory {

    private final JdbcMappingFactory factory;

    private final NoPropertyMatchStrategy noPropertyMatchStrategy;

    /**
     * Instantiates a new entity row mapper factory.
     *
     * @param factory the factory
     */
    public EntityRowMapperFactory(@Nonnull JdbcMappingFactory factory) {
        this(factory, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new entity row mapper factory.
     *
     * @param factory the factory
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public EntityRowMapperFactory(@Nonnull JdbcMappingFactory factory,
        @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super();
        this.factory = factory;
        this.noPropertyMatchStrategy = noPropertyMatchStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowMapper<T> createRowMapper(PropertyAccessor<T> type, SqlTypeMappingManager manager, String prefix) {
        return new BeanAccessorRowMapper<>(type, manager, factory, noPropertyMatchStrategy);
    }

}
