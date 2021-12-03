/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractJdbc.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2021年12月3日 下午9:07:01
 * @version V1.0
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
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

    protected final List<JdbcExecutionInterceptor> interceptors = new ArrayList<>(0);

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
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keySupplier, Object... args) {
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, keySupplier, args);
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> keySupplier,
            Map<String, Object> args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        Execution execution = SqlUtils.convertNamedParamSql(sql, args);
        return update(execution.getExecution(), keySupplier, execution.getParams());
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
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, args);
        }
        return 0;
    }

    private <T extends Serializable> int executeUpdate(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            Object... args) {
        logger.debug("sql -> {}, args -> {}", sql, args);
        JdbcExecution execution = preHandle(sql, args);
        sql = execution.getExecution();
        args = execution.getParams();
        Connection connection = getConnection();
        try (PreparedStatement prep = generatedKeyHolder == null ? connection.prepareStatement(sql)
                : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParams(prep, args);
            int result = prep.executeUpdate();
            // 不是查询操作，没有查询结果
            postHandle(execution, sql, args);
            if (generatedKeyHolder != null) {
                try (ResultSet res = prep.getGeneratedKeys()) {
                    int row = 0;
                    while (res.next()) {
                        T value = manager.get(res, 1, generatedKeyHolder.getType());
                        //                    Object value = JdbcUtils.getResultSetValue(res, 1, pm.getPropertyType());
                        generatedKeyHolder.acceptKey(value, row++);
                        logger.debug("auto generated key: ", value);
                    }
                }
            }
            return result;
        } catch (SQLException e) {
            releaseConnection(connection, getDataSource());
            throw new JdbcException(Strings.format("executeUpdate: \nsql: {0} \nargs: {1}", sql, Arrays.toString(args)),
                    e);
        } finally {
            releaseConnection(connection, getDataSource());
        }
    }

    private int executeUpdate(String sql, Object... args) {
        return executeUpdate(sql, null, args);
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
            JdbcExecution execution = preHandle(sql, args);
            sql = execution.getExecution();
            args = execution.getParams();
            Connection con = getConnection();
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("execute sql -> {} , params -> {}", sql, ArrayUtils.toString(args));
                }
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    return postHandle(execution.setOriginalResult(JdbcUtils.getResultSetMaps(rs, manager)), sql, args);
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
            JdbcExecution execution = preHandle(sql, args);
            sql = execution.getExecution();
            args = execution.getParams();
            if (logger.isDebugEnabled()) { // TODO 后续移动到对应Intercepor中去
                logger.debug("execute sql -> {} , params -> {}", sql, args);
            }
            Connection con = getConnection();
            try (PreparedStatement prep = con.prepareStatement(sql)) {
                setParams(prep, args);
                try (ResultSet rs = prep.executeQuery()) {
                    int i = 0;
                    while (rs.next()) {
                        list.add(rowMapper.mapRow(new SqlResultSet(rs), i++));
                    }
                    return postHandle(execution.setOriginalResult(list), sql, args);
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

    public void addInterceptor(JdbcExecutionInterceptor interceptor) {
        if (interceptor != null) {
            interceptors.add(interceptor);
        }

    }

    public void addInterceptor(List<JdbcExecutionInterceptor> interceptors) {
        if (interceptors != null) {
            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
                addInterceptor(jdbcExecutionInterceptor);
            }
        }
    }

    public void addInterceptor(JdbcExecutionInterceptor... interceptors) {
        if (interceptors != null) {
            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
                addInterceptor(jdbcExecutionInterceptor);
            }
        }
    }

    private JdbcExecution preHandle(String sql, Object... params) {
        JdbcExecution jdbcExecution = new JdbcExecution(this, sql, params);
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.preHandle(jdbcExecution);
        }
        return jdbcExecution;
    }

    @SuppressWarnings("unchecked")
    private <O> O postHandle(JdbcExecution jdbcExecution, String sql, Object... params) {
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.postHandle(jdbcExecution);
        }
        return (O) jdbcExecution.getResult();
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
