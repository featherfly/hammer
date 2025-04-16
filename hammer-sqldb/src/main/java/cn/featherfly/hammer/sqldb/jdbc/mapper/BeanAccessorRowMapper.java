
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.bean.NoSuchPropertyException;
import cn.featherfly.common.bean.Property;
import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Asserts;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * BeanAccessorRowMapper.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public class BeanAccessorRowMapper<T> implements RowMapper<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanAccessorRowMapper.class);

    private final PropertyAccessor<T> propertyAccessor;

    private final SqlTypeMappingManager manager;

    private final JdbcClassMapping<T> classMapping;

    private final NoPropertyMatchStrategy noPropertyMatchStrategy;

    private List<Tuple3<BiConsumer<T, Serializable>, Property<T, Serializable>, Integer>> properties;

    /**
     * Instantiates a new property accessor row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     */
    public BeanAccessorRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor,
        @Nonnull SqlTypeMappingManager manager) {
        this(propertyAccessor, manager, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new property accessor row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public BeanAccessorRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        this(propertyAccessor, manager, null, noPropertyMatchStrategy);
    }

    /**
     * Instantiates a new property accessor row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     */
    public BeanAccessorRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        JdbcMappingFactory mappingFactory) {
        this(propertyAccessor, manager, mappingFactory, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new property accessor row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     * @param classMapping the class mapping
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public BeanAccessorRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        JdbcMappingFactory mappingFactory, @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super();
        this.propertyAccessor = propertyAccessor;
        this.manager = manager;
        this.noPropertyMatchStrategy = noPropertyMatchStrategy;
        if (mappingFactory != null) {
            classMapping = mappingFactory.getClassMapping(propertyAccessor.getType());
        } else {
            classMapping = null;
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

    /**
     * {@inheritDoc}
     */
    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        T mappedObject = propertyAccessor.instantiate();

        Asserts.isTrue(mappedObject.getClass() != null, "Mapped class was not specified");

        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage(LOGGER.isDebugEnabled());

        if (rowNumber == 0) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            properties = new ArrayList<>();

            for (int index = 1; index <= columnCount; index++) {
                String columnLabel = JdbcUtils.lookupColumnName(rsmd, index);

                if (columnLabel.contains(Chars.DOT)) {
                    String[] names = columnLabel.split("\\.");
                    properties.add(Tuples.of((obj, pv) -> propertyAccessor.setPropertyValue(obj, names, pv),
                        propertyAccessor.getProperty(names), index));

                    if (LOGGER.isDebugEnabled()) {
                        mappingDebugMessage.addMapping(rsmd.getColumnName(index), columnLabel, columnLabel,
                            propertyAccessor.getProperty(names).getTypeName());
                    }
                } else {
                    String field = WordUtils.parseToUpperFirst(columnLabel, '_');
                    Property<T, Serializable> property = null;
                    if (classMapping != null) {
                        JdbcPropertyMapping jpm = classMapping
                            .getPropertyMappingByPersitField(rsmd.getColumnName(index));
                        if (jpm != null) {
                            property = getProperty(jpm);
                        }
                    }
                    try {
                        if (property == null) {
                            property = propertyAccessor.getProperty(field);
                        }
                        assertProperty(property, columnLabel, field);
                        properties.add(Tuples.of(property::set, property, index));
                        if (LOGGER.isDebugEnabled()) {
                            mappingDebugMessage.addMapping(rsmd.getColumnName(index), columnLabel, property.getName(),
                                property.getTypeName());
                        }
                    } catch (NoSuchPropertyException e) {
                        // FIXME 后续来优化这里的逻辑，PropertyAccessor应该加入判断是否包含指定的属性，使用异常开销太大了
                        assertProperty(null, columnLabel, field);
                    }
                }
            }

            if (LOGGER.isDebugEnabled()) {
                StringBuilder debugMessage = new StringBuilder();
                debugMessage.append("\n---------- Map " + mappedObject.getClass().getName() + " Start ----------\n")
                    .append(mappingDebugMessage.toString())
                    .append("---------- Map " + mappedObject.getClass().getName() + " End ----------");
                LOGGER.debug(debugMessage.toString());
            }
        }

        for (Tuple3<BiConsumer<T, Serializable>, Property<T, Serializable>, Integer> propertyTuple : properties) {
            propertyTuple.get0().accept(mappedObject, manager.get(rs, propertyTuple.get2(), propertyTuple.get1()));

            // ENHANCE 这里包装异常
            // throw new DataRetrievalFailureException(
            //  "Unable to map column '" + mapping.columnAs + "' to property '" + mapping.property + "'",
            //  ex);
        }
        return mappedObject;
    }

    @SuppressWarnings("unchecked")
    private Property<T, Serializable> getProperty(JdbcPropertyMapping jpm) {
        return (Property<T, Serializable>) jpm.getProperty();
    }

    private void assertProperty(Property<?, ?> property, String column, String field) {
        if (property != null) {
            return;
        }

        String msg = "No property found in '{}' for column '{}' mapped to field '{}'";

        switch (noPropertyMatchStrategy) {
            case EXCEPTION:
                throw new JdbcException(msg, new Object[] { propertyAccessor.getType().getName(), column, field });
            case IGNORE:
                LOGGER.debug(msg, propertyAccessor.getType().getName(), column, field);
                break;
            default:
                LOGGER.debug(msg, propertyAccessor.getType().getName(), column, field);
                break;
        }
    }

    /**
     * The Enum NoMatchStrategy.
     */
    public enum NoPropertyMatchStrategy {
        /** The ignore. */
        IGNORE,
        /** The exception. */
        EXCEPTION;
    }
}
