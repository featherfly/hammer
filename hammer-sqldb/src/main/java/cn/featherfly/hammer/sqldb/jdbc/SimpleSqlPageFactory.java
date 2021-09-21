
package cn.featherfly.hammer.sqldb.jdbc;

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
    public SqlPageQuery<Object[]> toPage(Dialect dialect, String sql, int start, int limit, Object... params) {
        return new SqlPageQuery<>(dialect.getPaginationSql(sql, start, limit),
                dialect.getPaginationSqlParameter(params, start, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlPageQuery<Map<String, Object>> toPage(Dialect dialect, String sql, int start, int limit,
            Map<String, Object> params) {
        return new SqlPageQuery<>(dialect.getParamNamedPaginationSql(sql, start, limit),
                dialect.getPaginationSqlParameter(params, start, limit));
    }
}
