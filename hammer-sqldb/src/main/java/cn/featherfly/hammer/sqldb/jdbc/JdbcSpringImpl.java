
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;

/**
 * jdbc spring impl.
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
     * @param metadata   the metadata
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata) {
        this(dataSource, dialect, metadata, new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource            dataSource
     * @param dialect               dialect
     * @param metadata              the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
            SqlTypeMappingManager sqlTypeMappingManager) {
        super(dialect, metadata, sqlTypeMappingManager);
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
