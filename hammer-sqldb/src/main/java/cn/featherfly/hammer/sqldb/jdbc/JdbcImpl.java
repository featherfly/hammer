
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcSimpleImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcSimpleImpl
 * @author: zhongj
 * @date: 2023-05-24 14:45:24
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.mapper.BeanRowMapperFactory;
import cn.featherfly.hammer.sqldb.jdbc.transaction.Isolation;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransactionImpl;

/**
 * JdbcImpl.
 *
 * @author zhongj
 */
public class JdbcImpl extends AbstractJdbc implements JdbcSession {

    private Connection connection;

    private Isolation defaultIsolation = Isolation.READ_COMMITTED;

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory, BeanRowMapperFactory beanRowMapperFactory) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory, beanRowMapperFactory);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory, List<JdbcExecutionInterceptor> interceptors) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory, null, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory, BeanRowMapperFactory beanRowMapperFactory,
        List<JdbcExecutionInterceptor> interceptors) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory, JdbcExecutionInterceptor... interceptors) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager,
        PropertyAccessorFactory propertyAccessorFactory, BeanRowMapperFactory beanRowMapperFactory,
        JdbcExecutionInterceptor... interceptors) {
        this(connection, null, dialect, metadata, manager, propertyAccessorFactory, beanRowMapperFactory, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory) {
        this(connection, defaultIsolation, dialect, metadata, manager, propertyAccessorFactory,
            Collections.emptyList());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory,
        BeanRowMapperFactory beanRowMapperFactory) {
        this(connection, defaultIsolation, dialect, metadata, manager, propertyAccessorFactory, beanRowMapperFactory,
            Collections.emptyList());
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory,
        JdbcExecutionInterceptor... interceptors) {
        this(connection, defaultIsolation, dialect, metadata, manager, propertyAccessorFactory, null, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory,
        BeanRowMapperFactory beanRowMapperFactory, JdbcExecutionInterceptor... interceptors) {
        super(dialect, metadata, manager, propertyAccessorFactory, beanRowMapperFactory, interceptors);
        this.connection = connection;
        if (defaultIsolation != null) {
            this.defaultIsolation = defaultIsolation;
        }
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory,
        List<JdbcExecutionInterceptor> interceptors) {
        this(connection, defaultIsolation, dialect, metadata, manager, propertyAccessorFactory, null, interceptors);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection the connection
     * @param defaultIsolation the default isolation
     * @param dialect the dialect
     * @param metadata the metadata
     * @param manager the manager
     * @param propertyAccessorFactory the property accessor factory
     * @param beanRowMapperFactory the bean row mapper factory
     * @param interceptors the interceptors
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
        SqlTypeMappingManager manager, PropertyAccessorFactory propertyAccessorFactory,
        BeanRowMapperFactory beanRowMapperFactory, List<JdbcExecutionInterceptor> interceptors) {
        super(dialect, metadata, manager, propertyAccessorFactory, beanRowMapperFactory, interceptors);
        this.connection = connection;
        if (defaultIsolation != null) {
            this.defaultIsolation = defaultIsolation;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T execute(ConnectionCallback<T> callback) {
        try {
            return callback.doInConnection(getConnection(), manager);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void releaseConnection(Connection connection) {
        // 手动管理数据库连接，这里不做处理，由调用的外部程序来处理
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Connection getConnection() {
        return connection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcTransaction beginTransation() {
        return beginTransation(defaultIsolation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcTransaction beginTransation(Isolation isolation) {
        try {
            //设置隔离级别
            connection.setTransactionIsolation(isolation.value());
            //启用事务
            connection.setAutoCommit(false);
            return new JdbcTransactionImpl(connection.setSavepoint(), connection);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws JdbcException {
        JdbcUtils.close(connection);
    }
}
