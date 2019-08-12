
package cn.featherfly.juorm.expression.query;

import java.util.Map;

import cn.featherfly.juorm.mapping.RowMapper;

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
     * @return map
     */
    Map<String, Object> single();

    /**
     * query for single
     *
     * @param <E>
     *            wrapper type
     * @param type
     *            wrapper type
     * @return object
     */
    <E> E single(Class<E> type);

    /**
     * query for single
     * 
     * @param <E>
     *            wrapper type
     * @param rowMapper
     *            rowMapper
     * @return object
     */
    <E> E single(RowMapper<E> rowMapper);
}
