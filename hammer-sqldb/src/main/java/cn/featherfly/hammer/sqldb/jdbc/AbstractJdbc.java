
package cn.featherfly.hammer.sqldb.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * AbstractJdbc.
 *
 * @author zhongj
 */
public abstract class AbstractJdbc implements Jdbc {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The data source. */
    protected DataSource dataSource;

    /** The dialect. */
    protected Dialect dialect;

    /** The manager. */
    protected SqlTypeMappingManager manager;

    /**
     * Instantiates a new abstract jdbc.
     */
    public AbstractJdbc() {
        this(new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new spring jdbc template impl.
     *
     * @param manager the manager
     */
    public AbstractJdbc(SqlTypeMappingManager manager) {
        super();
        this.manager = manager;
    }

    /**
     * Instantiates a new abstract jdbc.
     *
     * @param dataSource the data source
     * @param dialect    the dialect
     */
    public AbstractJdbc(DataSource dataSource, Dialect dialect) {
        this(dataSource, dialect, new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new abstract jdbc.
     *
     * @param dataSource the data source
     * @param dialect    the dialect
     * @param manager    the manager
     */
    public AbstractJdbc(DataSource dataSource, Dialect dialect, SqlTypeMappingManager manager) {
        super();
        setDataSource(dataSource);
        this.dialect = dialect;
        this.manager = manager;
    }

    /**
     * set dataSource.
     *
     * @param dataSource dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T execute(ConnectionCallback<T> action) {
        AssertIllegalArgument.isNotNull(action, "connectionCallback");
        Connection con = getConnection();
        try {
            // Create close-suppressing Connection proxy, also preparing returned Statements.
            //            Connection conToUse = createConnectionProxy(con);
            return action.doInConnection(con, manager);
        } catch (SQLException ex) {
            releaseConnection(con, getDataSource());
            con = null;
            throw new JdbcException("ConnectionCallback", ex);
        } finally {
            releaseConnection(con, getDataSource());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return update(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Object... args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, args);
        }
        return 0;
    }

    private int executeUpdate(String sql, Object... args) {
        Connection connection = getConnection();
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            logger.debug("sql -> {}, args -> {}", sql, ArrayUtils.toString(args));
            setParams(prep, args);
            return prep.executeUpdate();
        } catch (SQLException e) {
            releaseConnection(connection, getDataSource());
            throw new JdbcException(Strings.format("executeUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                    e);
        } finally {
            releaseConnection(connection, getDataSource());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> query(String sql, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> query(String sql, Object... args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            Connection con = getConnection();
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("execute sql -> {} , params -> {}", sql, ArrayUtils.toString(args));
                }
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    return JdbcUtils.getResultSetMaps(rs, manager);
                }
            } catch (SQLException e) {
                releaseConnection(con, getDataSource());
                con = null;
                throw new JdbcException(Strings.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
            } finally {
                releaseConnection(con, getDataSource());
            }
        }
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, Class<T> elementType, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}, elementType -> {}", sql, args, elementType);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return query(execution.getExecution(), elementType, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, Class<T> elementType, Object... args) {
        SQLType sqlType = manager.getSqlType(elementType);
        RowMapper<T> rowMapper = null;
        if (sqlType == null) {
            rowMapper = new NestedBeanPropertyRowMapper<>(elementType, manager);
        } else {
            rowMapper = new SingleColumnRowMapper<>(elementType, manager);
        }
        return query(sql, rowMapper, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> list = new ArrayList<>();
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            Connection con = getConnection();
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("execute sql -> {} , params -> {}", sql, ArrayUtils.toString(args));
                }
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    int i = 0;
                    while (rs.next()) {
                        list.add(rowMapper.mapRow(new SqlResultSet(rs), i++));
                    }
                    return list;
                }
            } catch (SQLException e) {
                releaseConnection(con, getDataSource());
                con = null;
                throw new JdbcException(Strings.format("query: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)), e);
            } finally {
                releaseConnection(con, getDataSource());
            }
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> querySingle(String sql, Map<String, Object> args) {
        return singleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> querySingle(String sql, Object... args) {
        return singleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Object... args) {
        return singleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        return singleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Map<String, Object> args) {
        return singleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Class<T> elementType, Object... args) {
        return singleResult(query(sql, elementType, args));
    }

    private <T> T singleResult(Collection<T> results) {
        if (results == null || results.size() <= 0) {
            return null;
        } else if (results.size() > 1) {
            // TODO 优化错误消息
            throw new JdbcException(Strings.format("results size must be 1, but is {0}", results.size()));
        }
        return results.iterator().next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> queryUnique(String sql, Map<String, Object> args) {
        return nullableSingleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> queryUnique(String sql, Object... args) {
        return nullableSingleResult(query(sql, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Object... args) {
        return nullableSingleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        return nullableSingleResult(query(sql, rowMapper, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Map<String, Object> args) {
        return nullableSingleResult(query(sql, elementType, args));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryUnique(String sql, Class<T> elementType, Object... args) {
        return nullableSingleResult(query(sql, elementType, args));
    }

    private <T> T nullableSingleResult(Collection<T> results) {
        if (Lang.isEmpty(results)) {
            // TODO 优化错误消息
            throw new JdbcException("results is empty");
        }
        if (results.size() > 1) {
            // TODO 优化错误消息
            throw new JdbcException(Strings.format("results size must be 1, but is {0}", results.size()));
        }
        return results.iterator().next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer queryInt(String sql, Object... args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer queryInt(String sql, Map<String, Object> args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long queryLong(String sql, Object... args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long queryLong(String sql, Map<String, Object> args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal queryBigDecimal(String sql, Object... args) {
        return queryValue(sql, BigDecimal.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal queryBigDecimal(String sql, Map<String, Object> args) {
        return queryValue(sql, BigDecimal.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double queryDouble(String sql, Object... args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double queryDouble(String sql, Map<String, Object> args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String queryString(String sql, Object... args) {
        return queryValue(sql, String.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String queryString(String sql, Map<String, Object> args) {
        return queryValue(sql, String.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Map<String, Object> args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Class<T> valueType, Object... args) {
        return queryValue(sql, new SingleColumnRowMapper<>(valueType, manager), args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return queryValue(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> results = query(sql, rowMapper, args);
        return nullableSingleResult(results);
    }

    /**
     * Sets the params.
     *
     * @param prep the prep
     * @param args the args
     */
    protected void setParams(PreparedStatement prep, Object... args) {
        for (int i = 0; i < args.length; i++) {
            manager.set(prep, i + 1, args[i]);
        }
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     * @param dataSource the data source
     */
    protected abstract void releaseConnection(Connection connection, DataSource dataSource);

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    protected abstract Connection getConnection();
}
