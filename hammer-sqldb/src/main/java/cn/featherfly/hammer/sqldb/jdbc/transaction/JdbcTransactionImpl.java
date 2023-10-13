
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
import java.sql.Savepoint;

import cn.featherfly.common.db.JdbcUtils;

/**
 * JdbcSimpleImpl.
 *
 * @author zhongj
 */
public class JdbcTransactionImpl implements JdbcTransaction {

    private Connection connection;

    private Savepoint savepoint;

    /**
     * Instantiates a new jdbc transaction impl.
     *
     * @param savepoint  the savepoint
     * @param connection the connection
     */
    public JdbcTransactionImpl(Savepoint savepoint, Connection connection) {
        this.connection = connection;
        this.savepoint = savepoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void commit() {
        JdbcUtils.commit(connection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rollback() {
        JdbcUtils.rollback(connection, savepoint);
    }
}
