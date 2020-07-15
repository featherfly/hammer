
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

    private SqlTypeMappingManager manager;

    /**
     *
     */
    public JdbcImpl() {
        super();
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
        super(dataSource, dialect);
        manager = sqlTypeMappingManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Object... args) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        if (Lang.isNotEmpty(sql)) {
            sql = sql.trim();
            executeUpdate(sql, args);
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
            executeUpdate(SqlUtils.convertNamedParamSql(sql, args));
        }
        return 0;
    }

    private int executeUpdate(Execution execution) {
        return executeUpdate(execution.getExecution(), execution.getParams());
    }

    private int executeUpdate(String sql, Object... args) {
        try (Connection connection = getConnection(); PreparedStatement prep = connection.prepareStatement(sql)) {
            Constants.LOGGER.debug("sql -> {}, args -> {}", sql, ArrayUtils.toString(args));
            setParams(prep, args);
            return prep.executeUpdate();
        } catch (SQLException e) {
            throw new JdbcException();
        }
    }

    private void setParams(PreparedStatement prep, Object... args) {
        for (int i = 0; i < args.length; i++) {
            manager.set(prep, i, args[i]);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    /**
     * 设置dataSource
     *
     * @param dataSource dataSource
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 设置dialect
     *
     * @param dialect dialect
     */
    @Override
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }
}
