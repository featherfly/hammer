
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcSession.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcSession
 * @author: zhongj
 * @date: 2023-05-25 17:52:25
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.hammer.sqldb.jdbc.transaction.Isolation;
import cn.featherfly.hammer.sqldb.jdbc.transaction.JdbcTransaction;

/**
 * JdbcSession.
 *
 * @author zhongj
 */
public interface JdbcSession extends Jdbc, AutoCloseable {

    JdbcTransaction beginTransation();

    JdbcTransaction beginTransation(Isolation isolation);

    @Override
    void close() throws JdbcException;
}
