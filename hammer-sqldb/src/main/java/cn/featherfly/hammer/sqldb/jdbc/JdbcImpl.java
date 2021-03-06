
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.hammer.sqldb.Constants;

/**
 * <p>
 * Jdbc
 * </p>
 *
 * @author zhongj
 */
public class JdbcImpl extends SpringJdbcTemplateImpl {

    /**
     *
     */
    public JdbcImpl() {
        super(new SqlTypeMappingManager());
    }

    /**
     * @param dataSource dataSource
     * @param dialect    dialect
     */
    public JdbcImpl(DataSource dataSource, Dialect dialect) {
        this(dataSource, dialect, new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource            dataSource
     * @param dialect               dialect
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public JdbcImpl(DataSource dataSource, Dialect dialect, SqlTypeMappingManager sqlTypeMappingManager) {
        super(dataSource, dialect, sqlTypeMappingManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Object... args) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(sql, args);
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Map<String, Object> args) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            return executeUpdate(SqlUtils.convertNamedParamSql(sql, args));
        }
        return 0;
    }

    private int executeUpdate(Execution execution) {
        return executeUpdate(execution.getExecution(), execution.getParams());
    }

    private int executeUpdate(String sql, Object... args) {
        Connection connection = getConnection();
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            Constants.LOGGER.debug("sql -> {}, args -> {}", sql, ArrayUtils.toString(args));
            setParams(prep, args);
            return prep.executeUpdate();
        } catch (SQLException e) {
            DataSourceUtils.releaseConnection(connection, getDataSource());
            throw new JdbcException();
        } finally {
            DataSourceUtils.releaseConnection(connection, getDataSource());
        }
    }

    @Override
    protected void setParams(PreparedStatement prep, Object... args) {
        for (int i = 0; i < args.length; i++) {
            manager.set(prep, i + 1, args[i]);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
}
