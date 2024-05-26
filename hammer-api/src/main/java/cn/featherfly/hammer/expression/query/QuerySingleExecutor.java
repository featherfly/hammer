
package cn.featherfly.hammer.expression.query;

import java.util.Map;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * dsl for query single executor .
 *
 * @author zhongj
 */
public interface QuerySingleExecutor {

    /**
     * query for single, return null when not found.
     *
     * @return map
     */
    Map<String, Object> single();

    /**
     * query for unique, throw exception when not found.
     *
     * @return map
     */
    Map<String, Object> unique();

    /**
     * query for single, return null when not found.
     *
     * @param <E> wrapper type
     * @param type wrapper type
     * @return object
     */
    <E> E single(Class<E> type);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E> the element type
     * @param type the type
     * @return the e
     */
    <E> E unique(Class<E> type);

    /**
     * query for single, return null when not found.
     *
     * @param <E> wrapper type
     * @param rowMapper rowMapper
     * @return object
     */
    <E> E single(RowMapper<E> rowMapper);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E> the element type
     * @param rowMapper the row mapper
     * @return the e
     */
    <E> E unique(RowMapper<E> rowMapper);
}
