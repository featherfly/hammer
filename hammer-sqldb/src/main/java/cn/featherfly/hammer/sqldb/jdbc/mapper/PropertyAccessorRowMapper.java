
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-27 01:14:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.bean.Property;
import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Asserts;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * PropertyAccessorMapper.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public class PropertyAccessorRowMapper<T> extends AbstractBeanRowMapper<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyAccessorRowMapper.class);

    private final PropertyAccessor<T> propertyAccessor;

    private final SqlTypeMappingManager manager;

    private final Map<String, Property<T, Object>> namePropertyMap;

    private List<Property<T, Object>> properties;

    private List<JdbcPropertyMapping> propertyMappings;

    /**
     * Instantiates a new property accessor row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     */
    @SuppressWarnings("unchecked")
    public PropertyAccessorRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor,
        @Nonnull SqlTypeMappingManager manager) {
        super();
        this.propertyAccessor = propertyAccessor;
        this.manager = manager;

        namePropertyMap = new HashMap<>(propertyAccessor.getProperties().length);

        for (Property<T, ?> property : propertyAccessor.getProperties()) {
            namePropertyMap.put(property.getName(), (Property<T, Object>) property);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapper.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        T mappedObject = propertyAccessor.instantiate();

        Asserts.isTrue(mappedObject.getClass() != null, "Mapped class was not specified");

        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage(LOGGER.isDebugEnabled());

        boolean isEntity = isEntity(propertyAccessor.getType());
        if (rowNumber == 0) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (isEntity) {
                propertyMappings = new ArrayList<>();
            } else {
                properties = new ArrayList<>();
            }

            for (int index = 1; index <= columnCount; index++) {
                //
                String column = JdbcUtils.lookupColumnName(rsmd, index);
                String field = lowerCaseName(StringUtils.deleteWhitespace(column));

                // YUFEI_TODO 未处理级联情况 user.name 这种

                Property<T, Object> property = namePropertyMap.get(field);
                if (property == null) {
                    // NOIMPL 这里加入未匹配上的策略
                    LOGGER.debug("No property found int '{}' for column '{}' mapped to field '{}'",
                        propertyAccessor.getType().getName(), column, field);
                    throw new JdbcException("这里加入未匹配上的策略");
                }
                properties.add(property);
            }

            if (LOGGER.isDebugEnabled()) {
                StringBuilder debugMessage = new StringBuilder();
                debugMessage.append("\n---------- Map " + mappedObject.getClass().getName() + " Start ----------\n")
                    .append(mappingDebugMessage.toString())
                    .append("---------- Map " + mappedObject.getClass().getName() + " End ----------");
                LOGGER.debug(debugMessage.toString());
            }
        }

        if (isEntity) {
            for (JdbcPropertyMapping propertyMapping : propertyMappings) {
                propertyMapping.getSetter().accept(mappedObject,
                    propertyMapping.getJavaTypeSqlTypeOperator().get(rs, rowNumber));
                // ENHANCE 这里包装异常
            }
        } else {
            int index = 1;
            for (Property<T, Object> property : properties) {
                property.set(mappedObject, manager.get(rs, index, property));
                index++;
                // ENHANCE 这里包装异常
                //                throw new DataRetrievalFailureException(
                //                    "Unable to map column '" + mapping.columnAs + "' to property '" + mapping.property + "'",
                //                    ex);
            }

        }
        //        if (populatedProperties != null && !populatedProperties.equals(mappedProperties)) {
        //            throw new InvalidDataAccessApiUsageException("Given ResultSet does not contain all fields "
        //                + "necessary to populate object of class [" + mappedClass.getName() + "]: " + mappedProperties);
        //        }
        return mappedObject;
    }

}
