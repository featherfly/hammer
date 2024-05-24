
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcFactoryImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcFactoryImpl
 * @author: zhongj
 * @date: 2023-05-24 14:44:24
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;

/**
 * JdbcFactoryImpl.
 *
 * @author zhongj
 */
public class JdbcFactoryImpl implements JdbcFactory {

    /** The dialect. */
    protected final Dialect dialect;

    /** The sql type mapping manager. */
    protected final SqlTypeMappingManager sqlTypeMappingManager;

    /** The metadata. */
    protected final DatabaseMetadata metadata;

    /** The property accessor factory. */
    protected final PropertyAccessorFactory propertyAccessorFactory;

    /**
     * Instantiates a new jdbc factory impl.
     *
     * @param dialect the dialect
     * @param metadata the metadata
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param propertyAccessorFactory the property accessor factory
     */
    public JdbcFactoryImpl(Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager sqlTypeMappingManager,
        PropertyAccessorFactory propertyAccessorFactory) {
        super();
        this.dialect = dialect;
        this.metadata = metadata;
        this.sqlTypeMappingManager = sqlTypeMappingManager;
        this.propertyAccessorFactory = propertyAccessorFactory;
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
    public SqlTypeMappingManager getSqlTypeMappingManager() {
        return sqlTypeMappingManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jdbc create(Connection connection) {
        return new JdbcImpl(connection, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcSession createSession(DataSource dataSource) {
        return createSession(JdbcUtils.getConnection(dataSource));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcSession createSession(Connection connection) {
        return new JdbcImpl(connection, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);
    }
}
