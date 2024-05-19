
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcQuery.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcQuery
 * @author: zhongj
 * @date: 2023-07-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.util.Map;

import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.ParamedQueryExecutor;

/**
 * JdbcQuery.
 *
 * @author zhongj
 */
public interface JdbcQuery extends JdbcQueryList, JdbcQueryEach, JdbcQuerySingle, JdbcQueryUnique, JdbcQueryValue {

    /**
     * paramed query.
     *
     * @param sql sql
     * @param args args
     * @return ParamedQueryExecutor
     */
    ParamedQueryExecutor query(String sql, Object... args);

    /**
     * paramed query.
     *
     * @param sql sql
     * @param args args
     * @return ParamedQueryExecutor
     */
    ParamedQueryExecutor query(String sql, Map<String, Object> args);

    /**
     * paramed query.
     *
     * @param sql sql
     * @param args args
     * @return ParamedQueryExecutor
     */
    default ParamedQueryExecutor query(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return query(execution.getExecution(), execution.getParams());
    }
}
