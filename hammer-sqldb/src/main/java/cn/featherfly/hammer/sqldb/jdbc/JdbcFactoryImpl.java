
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
import java.sql.SQLException;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.hammer.sqldb.jdbc.transaction.Isolation;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransactionImpl;

/**
 * JdbcFactoryImpl.
 *
 * @author zhongj
 */
public class JdbcFactoryImpl implements JdbcFactory {

    /** The dialect. */
    protected Dialect dialect;

    /** The sql type mapping manager. */
    protected SqlTypeMappingManager sqlTypeMappingManager;

    /**
     * Instantiates a new jdbc factory impl.
     *
     * @param dialect               the dialect
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public JdbcFactoryImpl(Dialect dialect, SqlTypeMappingManager sqlTypeMappingManager) {
        super();
        this.dialect = dialect;
        this.sqlTypeMappingManager = sqlTypeMappingManager;
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
        return new JdbcSimpleImpl(connection, dialect, sqlTypeMappingManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcTransaction beginTransation(Connection connection, Isolation isolation) {
        try {
            //设置隔离级别
            connection.setTransactionIsolation(isolation.value());
            //启用事务
            connection.setAutoCommit(false);
            return new JdbcTransactionImpl(connection.setSavepoint(), connection, dialect, sqlTypeMappingManager);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
