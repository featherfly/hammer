
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.JdbcException;
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
     * @param propertyAccessorFactory the instantiator factory
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        PropertyAccessorFactory propertyAccessorFactory) {
        this(dataSource, dialect, metadata, new SqlTypeMappingManager(), propertyAccessorFactory);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param propertyAccessorFactory the instantiator factory
     * @param interceptors the interceptors
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        PropertyAccessorFactory propertyAccessorFactory, JdbcExecutionInterceptor... interceptors) {
        this(dataSource, dialect, metadata, new SqlTypeMappingManager(), propertyAccessorFactory, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param propertyAccessorFactory the instantiator factory
     * @param interceptors the interceptors
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        PropertyAccessorFactory propertyAccessorFactory, List<JdbcExecutionInterceptor> interceptors) {
        this(dataSource, dialect, metadata, new SqlTypeMappingManager(), propertyAccessorFactory, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param propertyAccessorFactory the instantiator factory
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager sqlTypeMappingManager, PropertyAccessorFactory propertyAccessorFactory) {
        this(dataSource, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory, Collections.emptyList());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param propertyAccessorFactory the instantiator factory
     * @param interceptors the interceptors
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager sqlTypeMappingManager, PropertyAccessorFactory propertyAccessorFactory,
        List<JdbcExecutionInterceptor> interceptors) {
        super(dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory, interceptors);
        this.dataSource = dataSource;
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param dataSource dataSource
     * @param dialect dialect
     * @param metadata the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param propertyAccessorFactory the instantiator factory
     * @param interceptors the interceptors
     */
    public JdbcSpringImpl(DataSource dataSource, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager sqlTypeMappingManager, PropertyAccessorFactory propertyAccessorFactory,
        JdbcExecutionInterceptor... interceptors) {
        super(dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory, interceptors);
        this.dataSource = dataSource;
    }

    @Override
    public <T> T execute(ConnectionCallback<T> callback) {
        Connection conn = null;
        try {
            conn = new ConnectionProxy(getConnection()) {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public void close() throws SQLException {
                    // 防止外部回调手动调用connection.close()
                    releaseConnection(proxy);
                }
            };
            return callback.doInConnection(conn, manager);
        } catch (SQLException e) {
            throw new JdbcException(e);
        } finally {
            releaseConnection(conn);
        }
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
