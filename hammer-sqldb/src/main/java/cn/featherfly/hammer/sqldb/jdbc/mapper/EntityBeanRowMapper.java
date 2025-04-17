
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-27 01:14:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Nonnull;

import cn.featherfly.common.bean.Property;
import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * EntityBeanRowMapper.
 *
 * @author zhongj
 * @param <T> the entity type
 */
public class EntityBeanRowMapper<T> extends BeanRowMapper<T> {

    private final JdbcClassMapping<T> classMapping;

    /**
     * Instantiates a new entity bean row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     * @param classMapping the class mapping
     */
    public EntityBeanRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        JdbcClassMapping<T> classMapping) {
        this(propertyAccessor, manager, classMapping, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new entity bean row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     * @param classMapping the class mapping
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public EntityBeanRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        @Nonnull JdbcClassMapping<T> classMapping, @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super(propertyAccessor, manager, noPropertyMatchStrategy);
        this.classMapping = classMapping;
    }

    @Override
    protected void initProperty(ResultSet rs, final int columnIndex, String columnName, String columnLabel,
        String field, MappingDebugMessage mappingDebugMessage) throws SQLException {
        JdbcPropertyMapping jpm = classMapping.getPropertyMappingByPersitField(columnName);
        Property<T, Serializable> property = getProperty(jpm);
        if (assertProperty(property, columnLabel, field)) {
            if (jpm.getParent() == null) {
                properties.add(Tuples.of(property::set,
                    () -> (Serializable) jpm.getJavaTypeSqlTypeOperator().get(rs, columnIndex)));
            } else {
                String[] names = jpm.getPropertyFullName().split("\\.");
                properties.add(Tuples.of((obj, pv) -> propertyAccessor.setPropertyValue(obj, names, pv),
                    () -> manager.get(rs, columnIndex, propertyAccessor.getProperty(names))));
            }
            if (logger.isDebugEnabled()) {
                mappingDebugMessage.addMapping(columnName, columnLabel, jpm.getPropertyFullName(),
                    property.getTypeName());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Property<T, Serializable> getProperty(JdbcPropertyMapping jpm) {
        if (jpm == null) {
            return null;
        }
        return (Property<T, Serializable>) jpm.getProperty();
    }
}
