
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.orm.RowMapper;

/**
 * <p>
 * dsl for query single executor
 * </p>
 *
 * @author zhongj
 */
public interface QuerySingleExecutor {
    /**
     * query for single
     *
     * @param type
     *            wrapper type
     * @return object
     */
    <E> E single(Class<E> type);

    /**
     * query for single
     *
     * @param rowMapper
     *            rowMapper
     * @return object
     */
    <E, D> E single(RowMapper<E, D> rowMapper);
}
