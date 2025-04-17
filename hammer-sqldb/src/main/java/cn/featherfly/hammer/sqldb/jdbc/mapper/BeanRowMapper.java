
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
import java.util.function.Supplier;

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
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Asserts;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.AbstractRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * BeanRowMapper.
 *
 * @author zhongj
 * @param <T> the mapped type
 */
public class BeanRowMapper<T> extends AbstractRowMapper<T> {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final PropertyAccessor<T> propertyAccessor;

    protected final SqlTypeMappingManager manager;

    protected final NoPropertyMatchStrategy noPropertyMatchStrategy;

    /** The properties. */
    //    private List<Tuple3<BiConsumer<T, Serializable>, Property<T, Serializable>, Integer>> properties;
    protected final List<Tuple2<BiConsumer<T, Serializable>, Supplier<Serializable>>> properties;

    /**
     * Instantiates a new bean row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     */
    public BeanRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager) {
        this(propertyAccessor, manager, NoPropertyMatchStrategy.IGNORE);
    }

    /**
     * Instantiates a new bean row mapper.
     *
     * @param propertyAccessor the property accessor
     * @param manager the manager
     * @param noPropertyMatchStrategy the no property match strategy
     */
    public BeanRowMapper(@Nonnull PropertyAccessor<T> propertyAccessor, @Nonnull SqlTypeMappingManager manager,
        @Nonnull NoPropertyMatchStrategy noPropertyMatchStrategy) {
        super();
        this.propertyAccessor = propertyAccessor;
        this.manager = manager;
        this.noPropertyMatchStrategy = noPropertyMatchStrategy;
        properties = new ArrayList<>();
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
    @Override
    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        T mappedObject = propertyAccessor.instantiate();

        Asserts.isTrue(mappedObject.getClass() != null, "Mapped class was not specified");

        if (rowNumber == 0) {
            initProperties(mappedObject, rs);
        }

        for (Tuple2<BiConsumer<T, Serializable>, Supplier<Serializable>> propertyTuple : properties) {
            propertyTuple.get0().accept(mappedObject, propertyTuple.get1().get());

            // ENHANCE 这里包装异常
            // throw new DataRetrievalFailureException(
            //  "Unable to map column '" + mapping.columnAs + "' to property '" + mapping.property + "'",
            //  ex);
        }
        return mappedObject;
    }

    /**
     * Inits the properties.
     *
     * @param mappedObject the mapped object
     * @param rs the rs
     * @throws SQLException the SQL exception
     */
    protected void initProperties(T mappedObject, final ResultSet rs) throws SQLException {
        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage(logger.isDebugEnabled());

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int index = 1; index <= columnCount; index++) {
            String columnLabel = JdbcUtils.lookupColumnName(rsmd, index);
            final int columnIndex = index;

            if (Lang.isNotEmpty(columnLabel) && columnLabel.contains(Chars.DOT)) {
                String[] names = columnLabel.split("\\.");
                Property<?, Serializable> p = propertyAccessor.getProperty(names);
                if (assertProperty(p, columnLabel, columnLabel)) {
                    properties.add(Tuples.of((obj, pv) -> propertyAccessor.setPropertyValue(obj, names, pv),
                        () -> manager.get(rs, columnIndex, propertyAccessor.getProperty(names))));
                    if (logger.isDebugEnabled()) {
                        mappingDebugMessage.addMapping(rsmd.getColumnName(index), columnLabel, columnLabel,
                            propertyAccessor.getProperty(names).getTypeName());
                    }
                }
            } else {
                String field = WordUtils.parseToUpperFirst(columnLabel, Chars.UNDER_LINE_CHAR);
                try {
                    initProperty(rs, columnIndex, rsmd.getColumnName(index), columnLabel, field, mappingDebugMessage);
                } catch (NoSuchPropertyException e) {
                    // FIXME 后续来优化这里的逻辑，PropertyAccessor应该加入判断是否包含指定的属性，使用异常开销太大了
                    assertProperty(null, columnLabel, field);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage.append("\n---------- Map " + mappedObject.getClass().getName() + " Start ----------\n")
                .append(mappingDebugMessage.toString())
                .append("---------- Map " + mappedObject.getClass().getName() + " End ----------");
            logger.debug(debugMessage.toString());
        }
    }

    /**
     * Inits the property.
     *
     * @param rs the rs
     * @param rsmd the rsmd
     * @param columnIndex the column index
     * @param columnLabel the column label
     * @param field the field
     * @param mappingDebugMessage the mapping debug message
     * @throws SQLException the SQL exception
     */
    protected void initProperty(ResultSet rs, final int columnIndex, String columnName, String columnLabel,
        String field, MappingDebugMessage mappingDebugMessage) throws SQLException {
        //        Property<T, Serializable> property = getProperty(rsmd.getColumnName(index), field);
        Property<T, Serializable> property = propertyAccessor.getProperty(field);
        if (assertProperty(property, columnLabel, field)) {
            properties.add(Tuples.of(property::set, () -> manager.get(rs, columnIndex, property)));
            if (logger.isDebugEnabled()) {
                mappingDebugMessage.addMapping(columnName, columnLabel, property.getName(), property.getTypeName());
            }
        }
    }

    /**
     * Assert property.
     *
     * @param property the property
     * @param column the column
     * @param field the field
     */
    protected boolean assertProperty(Property<?, ?> property, String column, String field) {
        if (property != null) {
            return true;
        }

        String msg = "No property found in '{}' for column '{}' mapped to field '{}'";

        switch (noPropertyMatchStrategy) {
            case EXCEPTION:
                throw new JdbcException(msg, new Object[] { propertyAccessor.getType().getName(), column, field });
            case IGNORE:
                logger.debug(msg, propertyAccessor.getType().getName(), column, field);
                return false;
            default:
                logger.debug(msg, propertyAccessor.getType().getName(), column, field);
                return true;
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
