
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcSimpleImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcSimpleImpl
 * @author: zhongj
 * @date: 2023-05-24 14:45:24
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.hammer.sqldb.jdbc.AbstractJdbc;

/**
 * JdbcSimpleImpl.
 *
 * @author zhongj
 */
public class JdbcTransactionImpl extends AbstractJdbc implements JdbcTransaction {

    private Connection connection;

    private Savepoint savepoint;

    /**
     * Instantiates a new jdbc transaction impl.
     *
     * @param savepoint  the savepoint
     * @param connection the connection
     * @param dialect    the dialect
     * @param manager    the manager
     */
    public JdbcTransactionImpl(Savepoint savepoint, Connection connection, Dialect dialect,
            SqlTypeMappingManager manager) {
        super(dialect, manager);
        this.connection = connection;
        this.savepoint = savepoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void releaseConnection(Connection connection) {
        // 手动管理数据库连接，这里不做处理，由传入程序来处理
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
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rollback() {
        try {
            connection.rollback(savepoint);
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
