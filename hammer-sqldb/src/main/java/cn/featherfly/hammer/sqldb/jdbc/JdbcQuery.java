
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

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.ParamedQueryExecutor;
import cn.featherfly.common.repository.Params;

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
    ParamedQueryExecutor query(String sql, Serializable... args);

    /**
     * paramed query.
     *
     * @param sql sql
     * @param params the params
     * @return ParamedQueryExecutor
     */
    default ParamedQueryExecutor query(String sql, Params params) {
        return query(sql, (Map<String, Serializable>) params);
    }

    /**
     * paramed query.
     *
     * @param sql sql
     * @param args args
     * @return ParamedQueryExecutor
     */
    ParamedQueryExecutor query(String sql, Map<String, Serializable> args);

    /**
     * paramed query.
     *
     * @param sql sql
     * @param params the params
     * @return ParamedQueryExecutor
     */
    default ParamedQueryExecutor query(NamedParamSql sql, Params params) {
        return query(sql, (Map<String, Serializable>) params);
    }

    /**
     * paramed query.
     *
     * @param sql sql
     * @param args args
     * @return ParamedQueryExecutor
     */
    default ParamedQueryExecutor query(NamedParamSql sql, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return query(execution.getExecution(), execution.getParams());
    }
}
