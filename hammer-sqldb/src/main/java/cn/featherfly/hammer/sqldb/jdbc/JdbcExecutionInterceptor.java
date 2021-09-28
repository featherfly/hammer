
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.repository.Execution;

/**
 * JdbcExecutionInterceptor.
 *
 * @author zhongj
 */
public interface JdbcExecutionInterceptor {

    //    @Override
    //    public void afterCompletion(HttpServletRequest request,
    //            HttpServletResponse response, Object handler, Exception ex)
    //            throws Exception {
    //
    //    }

    void postHandle(Execution execution) throws JdbcException;

    void preHandle(Execution execution) throws JdbcException;

}
