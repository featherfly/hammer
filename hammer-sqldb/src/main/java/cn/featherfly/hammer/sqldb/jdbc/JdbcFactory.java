
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcFactory.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcFactory
 * @author: zhongj
 * @date: 2023-05-24 14:41:24
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.hammer.sqldb.jdbc.transaction.Isolation;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;

/**
 * JdbcFactory.
 *
 * @author zhongj
 */
public interface JdbcFactory {

    /**
     * Gets the dialect.
     *
     * @return the dialect
     */
    Dialect getDialect();

    /**
     * Gets the sql type mapping manager.
     *
     * @return the sql type mapping manager
     */
    SqlTypeMappingManager getSqlTypeMappingManager();

    /**
     * Creates jdbc. <br/>
     * note:
     * <ul>
     * <li>manage transaction with invoker on connection.
     * <li>manage connection state with invoker such as connection.close().
     * </ul>
     *
     * @param connection the connection
     * @return the jdbc
     */
    Jdbc create(Connection connection);

    /**
     * Begin transation. easy manage transaction with return JdbcTransaction
     * object. <br/>
     * note:
     * <ul>
     * <li>the return object method commit() will invoke param connection
     * commit() method.
     * <li>the return object method rollback() will invoke param connection
     * rollback(savepoint) method.
     * <li>the return object method close() will invoke param connection close()
     * method.
     * </ul>
     *
     * @param connection the connection
     * @param isolation  the isolation
     * @return the jdbc transaction
     */
    JdbcTransaction beginTransation(Connection connection, Isolation isolation);
}
