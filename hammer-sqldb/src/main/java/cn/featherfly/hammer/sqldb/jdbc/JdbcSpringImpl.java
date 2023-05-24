
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * Jdbc Impl.
 *
 * @author zhongj
 */
public class JdbcSpringImpl extends AbstractJdbc {

    private DataSource dataSource;

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect    dialect
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect) {
        this(dataSource, dialect, new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource            dataSource
     * @param dialect               dialect
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, SqlTypeMappingManager sqlTypeMappingManager) {
        super(dialect, sqlTypeMappingManager);
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void releaseConnection(Connection connection) {
        DataSourceUtils.releaseConnection(connection, dataSource);
    }
}
