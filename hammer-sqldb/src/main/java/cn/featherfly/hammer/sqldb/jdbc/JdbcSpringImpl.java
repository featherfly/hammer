
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import cn.featherfly.common.bean.InstantiatorFactory;
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
     * @param dialect dialect
     * @param metadata the metadata
     * @param instantiatorFactory the instantiator factory
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        InstantiatorFactory instantiatorFactory) {
        this(dataSource, dialect, metadata, new SqlTypeMappingManager(), instantiatorFactory);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param instantiatorFactory the instantiator factory
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager sqlTypeMappingManager, InstantiatorFactory instantiatorFactory) {
        super(dialect, metadata, sqlTypeMappingManager, instantiatorFactory);
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
