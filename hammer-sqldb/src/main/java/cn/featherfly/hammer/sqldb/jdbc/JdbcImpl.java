
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
public class JdbcImpl extends AbstractJdbc {

    /**
     * Instantiates a new jdbc impl.
     */
    public JdbcImpl() {
        super(new SqlTypeMappingManager());
    }

    /**
     * Instantiates a new jdbc impl.
     *
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
    protected Connection getConnection(DataSource dataSource) {
        return DataSourceUtils.getConnection(dataSource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void releaseConnection(Connection connection, DataSource dataSource) {
        DataSourceUtils.releaseConnection(connection, dataSource);
    }
}
