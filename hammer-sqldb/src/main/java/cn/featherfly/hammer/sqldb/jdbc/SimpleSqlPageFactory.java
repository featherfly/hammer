
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.db.dialect.Dialect;

/**
 * SimpleSqlPageFactory.
 *
 * @author zhongj
 */
public class SimpleSqlPageFactory implements SqlPageFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlPageQuery<Serializable[]> toPage(Dialect dialect, String sql, int start, int limit,
        Serializable... params) {
        return new SqlPageQuery<>(dialect.getPaginationSql(sql, start, limit),
            dialect.getPaginationSqlParameter(params, start, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlPageQuery<Map<String, Serializable>> toPage(Dialect dialect, String sql, int start, int limit,
        Map<String, Serializable> params) {
        return new SqlPageQuery<>(dialect.getNamedParamPaginationSql(sql, start, limit),
            dialect.getPaginationSqlParameter(params, start, limit));
    }
}
