package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLType;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.NumberUtils;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.reflect.GenericClass;

/**
 * The Class SingleColumnRowMapper.
 *
 * @author zhongj
 * @param <T> the generic type
 */
/*
 * package org.springframework.jdbc.core; import java.sql.ResultSet; import
 * java.sql.ResultSetMetaData; import java.sql.SQLException; import
 * org.springframework.core.convert.ConversionService; import
 * org.springframework.core.convert.support.DefaultConversionService; import
 * org.springframework.dao.TypeMismatchDataAccessException; import
 * org.springframework.jdbc.IncorrectResultSetColumnCountException; import
 * org.springframework.jdbc.support.JdbcUtils; import
 * org.springframework.lang.Nullable; import
 * org.springframework.util.ClassUtils; import
 * org.springframework.util.NumberUtils; /** {@link RowMapper} implementation
 * that converts a single column into a single result value per row. Expects to
 * operate on a {@code java.sql.ResultSet} that just contains a single column.
 * <p>The type of the result value for each row can be specified. The value for
 * the single column will be extracted from the {@code ResultSet} and converted
 * into the specified target type.
 * @author Juergen Hoeller
 * @author Kazuki Shimizu
 * @since 1.2
 * @param <T> the result type
 * @see JdbcTemplate#queryForList(String, Class)
 * @see JdbcTemplate#queryForObject(String, Class)
 */
public class SingleColumnRowMapper<T> implements RowMapper<T>, cn.featherfly.common.repository.mapping.RowMapper<T> {

    @Nullable
    private Class<?> requiredType;

    @Nullable
    private ConversionService conversionService = DefaultConversionService.getSharedInstance();

    @Nullable
    private SqlTypeMappingManager manager;

    /**
     * Create a new {@code SingleColumnRowMapper}.
     *
     * @param requiredType the type that each result object is expected to match
     * @param manager      the manager
     */
    public SingleColumnRowMapper(Class<T> requiredType, SqlTypeMappingManager manager) {
        setRequiredType(requiredType);
        this.manager = manager;
    }

    /**
     * Set the type that each result object is expected to match.
     * <p>
     * If not specified, the column value will be exposed as returned by the
     * JDBC driver.
     *
     * @param requiredType the new required type
     */
    public void setRequiredType(Class<T> requiredType) {
        this.requiredType = ClassUtils.resolvePrimitiveIfNecessary(requiredType);
    }

    /**
     * Set a {@link ConversionService} for converting a fetched value.
     * <p>
     * Default is the {@link DefaultConversionService}.
     *
     * @param conversionService the new conversion service
     * @see DefaultConversionService#getSharedInstance
     * @since 5.0.4
     */
    public void setConversionService(@Nullable ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapping.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcMappingException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * Extract a value for the single column in the current row.
     * <p>
     * Validates that there is only one column selected, then delegates to
     * {@code getColumnValue()} and also {@code convertValueToRequiredType}, if
     * necessary.
     *
     * @param rs     the rs
     * @param rowNum the row num
     * @return the t
     * @throws SQLException the SQL exception
     * @see java.sql.ResultSetMetaData#getColumnCount()
     * @see #getColumnValue(java.sql.ResultSet, int, Class)
     * @see #convertValueToRequiredType(Object, Class)
     */
    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Validate column count.
        ResultSetMetaData rsmd = rs.getMetaData();
        int nrOfColumns = rsmd.getColumnCount();
        if (nrOfColumns != 1) {
            throw new IncorrectResultSetColumnCountException(1, nrOfColumns);
        }

        // Extract column value from JDBC ResultSet.
        Object result = getColumnValue(rs, 1, this.requiredType);
        if (result != null && this.requiredType != null && !this.requiredType.isInstance(result)) {
            // Extracted value does not match already: try to convert it.
            try {
                return (T) convertValueToRequiredType(result, this.requiredType);
            } catch (IllegalArgumentException ex) {
                throw new TypeMismatchDataAccessException("Type mismatch affecting row number " + rowNum
                        + " and column type '" + rsmd.getColumnTypeName(1) + "': " + ex.getMessage());
            }
        }
        return (T) result;
    }

    /**
     * Retrieve a JDBC object value for the specified column.
     * <p>
     * The default implementation calls
     * {@link JdbcUtils#getResultSetValue(java.sql.ResultSet, int, Class)}. If
     * no required type has been specified, this method delegates to
     * {@code getColumnValue(rs, index)}, which basically calls
     * {@code ResultSet.getObject(index)} but applies some additional default
     * conversion to appropriate value types.
     *
     * @param rs           is the ResultSet holding the data
     * @param index        is the column index
     * @param requiredType the type that each result object is expected to match
     *                     (or {@code null} if none specified)
     * @return the Object value
     * @throws SQLException in case of extraction failure
     * @see org.springframework.jdbc.support.JdbcUtils#getResultSetValue(java.sql.ResultSet,
     *      int, Class)
     * @see #getColumnValue(java.sql.ResultSet, int)
     */
    @Nullable
    protected Object getColumnValue(ResultSet rs, int index, @Nullable Class<?> requiredType) throws SQLException {
        if (requiredType != null) {
            return manager.get(rs, index, new GenericClass<>(requiredType));
        } else {
            SQLType sqlType = JDBCType.valueOf(rs.getMetaData().getColumnType(index));
            Class<?> type = manager.getJavaType(sqlType);
            if (type != null) {
                return manager.get(rs, index, new GenericClass<>(type));
            } else {
                // No required type specified -> perform default extraction.
                return getColumnValue(rs, index);
            }
        }
    }

    /**
     * Retrieve a JDBC object value for the specified column, using the most
     * appropriate value type. Called if no required type has been specified.
     * <p>
     * The default implementation delegates to
     * {@code JdbcUtils.getResultSetValue()}, which uses the
     * {@code ResultSet.getObject(index)} method. Additionally, it includes a
     * "hack" to get around Oracle returning a non-standard object for their
     * TIMESTAMP datatype. See the {@code JdbcUtils#getResultSetValue()} javadoc
     * for details.
     *
     * @param rs    is the ResultSet holding the data
     * @param index is the column index
     * @return the Object value
     * @throws SQLException in case of extraction failure
     * @see org.springframework.jdbc.support.JdbcUtils#getResultSetValue(java.sql.ResultSet,
     *      int)
     */
    @Nullable
    protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
        return JdbcUtils.getResultSetValue(rs, index);
    }

    /**
     * Convert the given column value to the specified required type. Only
     * called if the extracted column value does not match already.
     * <p>
     * If the required type is String, the value will simply get stringified via
     * {@code toString()}. In case of a Number, the value will be converted into
     * a Number, either through number conversion or through String parsing
     * (depending on the value type). Otherwise, the value will be converted to
     * a required type using the {@link ConversionService}.
     *
     * @param value        the column value as extracted from
     *                     {@code getColumnValue()} (never {@code null})
     * @param requiredType the type that each result object is expected to match
     *                     (never {@code null})
     * @return the converted value
     * @see #getColumnValue(java.sql.ResultSet, int, Class)
     */
    @SuppressWarnings("unchecked")
    @Nullable
    protected Object convertValueToRequiredType(Object value, Class<?> requiredType) {
        if (String.class == requiredType) {
            return value.toString();
        } else if (Number.class.isAssignableFrom(requiredType)) {
            if (value instanceof Number) {
                // Convert original Number to target Number class.
                return NumberUtils.convertNumberToTargetClass((Number) value, (Class<Number>) requiredType);
            } else {
                // Convert stringified value to target Number class.
                return NumberUtils.parseNumber(value.toString(), (Class<Number>) requiredType);
            }
        } else if (this.conversionService != null
                && this.conversionService.canConvert(value.getClass(), requiredType)) {
            return this.conversionService.convert(value, requiredType);
        } else {
            throw new IllegalArgumentException("Value [" + value + "] is of type [" + value.getClass().getName()
                    + "] and cannot be converted to required type [" + requiredType.getName() + "]");
        }
    }
}
