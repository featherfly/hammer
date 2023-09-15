package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.annotation.Nonnull;

import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * {@link RowMapper} implementation that converts a single column into a single
 * result value per row. Expects to operate on a {@code java.sql.ResultSet} that
 * just contains a single column.
 * <p>
 * The type of the result value for each row can be specified. The value for the
 * single column will be extracted from the {@code ResultSet} and converted into
 * the specified target type.
 *
 * @author zhongj
 * @param <T> the result type
 * @see Jdbc#queryValue(String, Class, java.util.Map)
 * @see Jdbc#queryValue(String, Class, Object...)
 * @see Jdbc#queryInt(String, java.util.Map)
 * @see Jdbc#queryInt(String, Object...)
 * @see Jdbc#queryLong(String, java.util.Map)
 * @see Jdbc#queryLong(String, Object...)
 * @see Jdbc#queryDouble(String, java.util.Map)
 * @see Jdbc#queryDouble(String, Object...)
 * @see Jdbc#queryBigDecimal(String, java.util.Map)
 * @see Jdbc#queryBigDecimal(String, Object...)
 * @see Jdbc#queryString(String, java.util.Map)
 * @see Jdbc#queryString(String, Object...)
 * @since 0.5.7
 */
public class SingleColumnRowMapper<T> implements cn.featherfly.common.repository.mapping.RowMapper<T> {

    private Class<?> requiredType;

    //    @Nullable
    //    private ConversionService conversionService = DefaultConversionService.getSharedInstance();

    private SqlTypeMappingManager manager;

    private String prefix;

    /**
     * Create a new {@code SingleColumnRowMapper}.
     *
     * @param requiredType the type that each result object is expected to match
     * @param manager      the manager
     */
    public SingleColumnRowMapper(Class<T> requiredType, SqlTypeMappingManager manager) {
        this(requiredType, manager, null);
    }

    /**
     * Create a new {@code SingleColumnRowMapper}.
     *
     * @param requiredType the type that each result object is expected to match
     * @param manager      the manager
     * @param prefix       the prefix
     */
    public SingleColumnRowMapper(@Nonnull Class<T> requiredType, @Nonnull SqlTypeMappingManager manager,
            String prefix) {
        AssertIllegalArgument.isNotNull(requiredType, "requiredType");
        AssertIllegalArgument.isNotNull(manager, "sqlTypeMappingManager");
        setRequiredType(requiredType);
        this.manager = manager;
        this.prefix = prefix;
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

    //    /**
    //     * Set a {@link ConversionService} for converting a fetched value.
    //     * <p>
    //     * Default is the {@link DefaultConversionService}.
    //     *
    //     * @param conversionService the new conversion service
    //     * @see DefaultConversionService#getSharedInstance
    //     * @since 5.0.4
    //     */
    //    public void setConversionService(@Nullable ConversionService conversionService) {
    //        this.conversionService = conversionService;
    //    }

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
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Validate column count.
        ResultSetMetaData rsmd = rs.getMetaData();
        if (prefix == null) {
            int nrOfColumns = rsmd.getColumnCount();
            if (nrOfColumns != 1) {
                throw new JdbcException("Incorrect column count: expected 1, actual " + nrOfColumns);
                //            throw new IncorrectResultSetColumnCountException(1, nrOfColumns);
            }

            // Extract column value from JDBC ResultSet.
            return (T) getColumnValue(rs, 1, requiredType);
        } else {
            int matchIndex = -1;
            if (rowNum == 0) {
                int columnCount = rsmd.getColumnCount();
                String matchFiled = null;
                for (int index = 1; index <= columnCount; index++) {
                    String fieldName = JdbcUtils.getColumnName(rs, index);
                    if (fieldName.startsWith(prefix)) {
                        if (matchFiled != null) {
                            throw new JdbcException(
                                    Strings.format("there is more than one column name [{0},{1}] with prefix {2}",
                                            matchFiled, fieldName, prefix));
                        }
                        matchFiled = fieldName;
                        matchIndex = index;
                    }
                }
            }

            if (matchIndex == -1) {
                throw new JdbcException("there is no column name with prefix " + prefix);
            }
            // TODO 未测试
            return (T) getColumnValue(rs, matchIndex, requiredType);
        }
        //        Object result = getColumnValue(rs, 1, this.requiredType);
        //        if (result != null && this.requiredType != null && !this.requiredType.isInstance(result)) {
        //            // Extracted value does not match already: try to convert it.
        //            try {
        //                return (T) convertValueToRequiredType(result, this.requiredType);
        //            } catch (IllegalArgumentException ex) {
        //                throw new TypeMismatchDataAccessException("Type mismatch affecting row number " + rowNum
        //                        + " and column type '" + rsmd.getColumnTypeName(1) + "': " + ex.getMessage());
        //            }
        //        }
        //        return (T) result;
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
     */
    @Nullable
    protected Object getColumnValue(ResultSet rs, int index, @Nullable Class<?> requiredType) {
        return manager.get(rs, index, requiredType);
        // requiredType 不会为null
        //        if (requiredType != null) {
        //            return manager.get(rs, index, requiredType);
        //        } else {
        //            SQLType sqlType = JDBCType.valueOf(rs.getMetaData().getColumnType(index));
        //            Class<?> type = manager.getJavaType(sqlType);
        //            if (type != null) {
        //                return manager.get(rs, index, type);
        //            } else {
        //                return JdbcUtils.getResultSetValue(rs, index);
        //            }
        //        }
    }
}
