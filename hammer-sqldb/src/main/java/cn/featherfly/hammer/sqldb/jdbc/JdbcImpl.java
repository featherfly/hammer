
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

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
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
     * @param dialect    the dialect
     * @param manager    the manager
     */
    public JdbcImpl(Connection connection, Dialect dialect, DatabaseMetadata metadata, SqlTypeMappingManager manager) {
        this(connection, null, dialect, metadata, manager);
    }

    /**
     * Instantiates a new jdbc impl.
     *
     * @param connection       the connection
     * @param defaultIsolation the default isolation
     * @param dialect          the dialect
     * @param manager          the manager
     */
    public JdbcImpl(Connection connection, Isolation defaultIsolation, Dialect dialect, DatabaseMetadata metadata,
            SqlTypeMappingManager manager) {
        super(dialect, metadata, manager);
        this.connection = connection;
        if (defaultIsolation != null) {
            this.defaultIsolation = defaultIsolation;
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
    public void close() {
        JdbcUtils.close(connection);
    }
}
