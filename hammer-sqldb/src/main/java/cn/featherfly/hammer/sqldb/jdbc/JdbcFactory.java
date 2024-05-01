
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

import javax.sql.DataSource;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

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
     * Creates jdbc. <br>
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
     * Creates jdbc session. <br>
     * the jdbc session object can start transation with beginTransation method.
     *
     * @param dataSource the data source
     * @return the jdbc transaction
     */
    JdbcSession createSession(DataSource dataSource);

    /**
     * Creates jdbc session. <br>
     * the jdbc session object can start transation with beginTransation method.
     *
     * @param connection the connection
     * @return the jdbc transaction
     */
    JdbcSession createSession(Connection connection);
}
