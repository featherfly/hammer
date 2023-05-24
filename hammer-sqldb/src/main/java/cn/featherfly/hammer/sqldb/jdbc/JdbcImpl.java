
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

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * JdbcImpl.
 *
 * @author zhongj
 */
public class JdbcImpl extends AbstractJdbc {

    private Connection connection;

    /**
     * @param dataSource
     * @param dialect
     * @param manager
     */
    public JdbcImpl(Connection connection, Dialect dialect, SqlTypeMappingManager manager) {
        super(dialect, manager);
        this.connection = connection;
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
}
