
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;

/**
 * SqlPageFactory.
 *
 * @author zhongj
 */
public interface SqlPageFactory {

    /**
     * The Class SqlPageQuery.
     *
     * @param <E> the element type
     */
    public class SqlPageQuery<E> {

        /** The sql. */
        private String sql;

        /** The params. */
        private E params;

        /**
         * Instantiates a new sql page query.
         *
         * @param sql the sql
         * @param params the params
         */
        public SqlPageQuery(String sql, E params) {
            super();
            this.sql = sql;
            this.params = params;
        }

        /**
         * 返回sql.
         *
         * @return sql
         */
        public String getSql() {
            return sql;
        }

        /**
         * 返回params.
         *
         * @return params
         */
        public E getParams() {
            return params;
        }
    }

    /**
     * To page.
     *
     * @param dialect the dialect
     * @param sql the sql
     * @param page the page
     * @param params the params
     * @return the sql page query
     */
    default SqlPageQuery<Serializable[]> toPage(@Nonnull Dialect dialect, @Nonnull String sql, @Nonnull Page page,
        Serializable... params) {
        Limit limit = new Limit(page);
        return toPage(dialect, sql, limit.getOffset(), limit.getLimit(), params);
    }

    /**
     * To page.
     *
     * @param dialect the dialect
     * @param sql the sql
     * @param start the start
     * @param limit the limit
     * @param params the params
     * @return the sql page query
     */
    SqlPageQuery<Serializable[]> toPage(@Nonnull Dialect dialect, @Nonnull String sql, int start, int limit,
        Serializable... params);

    /**
     * To page.
     *
     * @param dialect the dialect
     * @param sql the sql
     * @param page the page
     * @param params the params
     * @return the sql page query
     */
    default SqlPageQuery<Map<String, Serializable>> toPage(@Nonnull Dialect dialect, @Nonnull String sql,
        @Nonnull Page page, Map<String, Serializable> params) {
        Limit limit = new Limit(page);
        return toPage(dialect, sql, limit.getOffset(), limit.getLimit(), params);
    }

    /**
     * To page.
     *
     * @param dialect the dialect
     * @param sql the sql
     * @param start the start
     * @param limit the limit
     * @param params the params
     * @return the sql page query
     */
    SqlPageQuery<Map<String, Serializable>> toPage(@Nonnull Dialect dialect, @Nonnull String sql, int start, int limit,
        Map<String, Serializable> params);
}
