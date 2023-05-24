
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcSession.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcSession
 * @author: zhongj
 * @date: 2023-05-24 14:57:24
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.transaction;

import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * JdbcSession.
 *
 * @author zhongj
 */
public interface JdbcTransaction extends Jdbc {

    /**
     * Commit.
     */
    void commit();

    /**
     * Rollback.
     */
    void rollback();

    /**
     * Close.
     */
    void close();
}
