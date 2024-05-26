
package cn.featherfly.hammer.expression.query;

import java.util.Map;

import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for query page executor .
 *
 * @author zhongj
 */
public interface QueryPageExecutor {

    /**
     * query for page.
     *
     * @return PaginationResults
     */
    PaginationResults<Map<String, Object>> pagination();

    /**
     * query for page.
     *
     * @param <E> the mapping type
     * @param type the mapping type
     * @return PaginationResults
     */
    <E> PaginationResults<E> pagination(Class<E> type);

    /**
     * query for page.
     *
     * @param <E> the mapping type
     * @param rowMapper rowMapper
     * @return PaginationResults
     */
    <E> PaginationResults<E> pagination(RowMapper<E> rowMapper);
}
