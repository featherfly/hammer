
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.repository.ExecutionInterceptor;

/**
 * JdbcExecutionInterceptor.
 *
 * @author zhongj
 */
public interface JdbcExecutionInterceptor extends ExecutionInterceptor<JdbcExecution> {

    /**
     * Pre handle.
     *
     * @param execution the execution
     * @throws JdbcException the jdbc exception
     */
    @Override
    void preHandle(JdbcExecution execution) throws JdbcException;

    /**
     * Post handle.
     *
     * @param execution the execution
     * @param result    the result
     * @throws JdbcException the jdbc exception
     */
    @Override
    void postHandle(JdbcExecution execution) throws JdbcException;

}
