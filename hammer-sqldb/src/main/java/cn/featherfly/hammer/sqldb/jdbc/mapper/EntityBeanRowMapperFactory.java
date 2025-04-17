
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
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.mapper.BeanRowMapper.NoPropertyMatchStrategy;

/**
 * EntityRowMapperFactory.
 *
 * @author zhongj
 */
public class EntityBeanRowMapperFactory extends BeanRowMapperFactoryImpl {

    private final JdbcMappingFactory factory;

    /**
     * Instantiates a new entity row mapper factory.
     *
     * @param factory the factory
     */
    public EntityBeanRowMapperFactory(@Nonnull JdbcMappingFactory factory) {
        this(factory, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new entity row mapper factory.
     *
     * @param factory the factory
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public EntityBeanRowMapperFactory(@Nonnull JdbcMappingFactory factory,
        @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super(noPropertyMatchStrategy);
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowMapper<T> createRowMapper(PropertyAccessor<T> type, SqlTypeMappingManager manager, String prefix) {
        JdbcClassMapping<T> cm = factory.getClassMapping(type.getType());
        if (cm != null) {
            // FIXME prefix 还没有实现prefix支持
            return new EntityBeanRowMapper<>(type, manager, cm, noPropertyMatchStrategy);
        }
        return super.createRowMapper(type, manager, prefix);
    }

}
