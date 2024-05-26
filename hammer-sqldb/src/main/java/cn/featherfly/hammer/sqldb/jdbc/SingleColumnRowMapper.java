package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.annotation.Nonnull;

import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.mapper.RowMapper;

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
 * @see Jdbc#queryValue(String, java.util.Map)
 * @see Jdbc#queryValue(String, Object...)
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
public class SingleColumnRowMapper<T> implements cn.featherfly.common.repository.mapper.RowMapper<T> {

    private Class<?> requiredType;

    private SqlTypeMappingManager manager;

    private String prefix;

    private int matchIndex = 1;

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

    @SuppressWarnings("unchecked")
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Validate column count.
        if (rowNum == 0) {
            check(rs);

            setType(rs);
        }

        return (T) getColumnValue(rs, matchIndex, requiredType);
    }

    private void check(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        if (prefix == null) {
            int nrOfColumns = rsmd.getColumnCount();
            if (nrOfColumns != 1) {
                throw new JdbcException("Incorrect column count: expected 1, actual " + nrOfColumns);
                //            throw new IncorrectResultSetColumnCountException(1, nrOfColumns);
            }
            matchIndex = 1;
        } else {
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
            if (matchIndex == -1) {
                throw new JdbcException("there is no column name with prefix " + prefix);
            }
            // TODO 未测试
        }
    }

    private void setType(ResultSet rs) {
        if (requiredType == Object.class) {
            Class<?> type = manager.getJavaType(JdbcUtils.getResultSetType(rs, matchIndex));
            if (type != null) {
                requiredType = type;
            }
        }
    }

    /**
     * Retrieve a JDBC object value for the specified column.
     * <p>
     * The default implementation calls
     * {@link SqlTypeMappingManager#get(ResultSet, int, Class)}.
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
    }
}
