
package cn.featherfly.hammer.expression.query;

import java.util.Map;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.mapping.RowMapper;

/**
 * <p>
 * dsl for query page executor
 * </p>
 *
 * @author zhongj
 */
public interface QueryPageExecutor {
    /**
     * query for page
     *
     * @return list
     */
    PaginationResults<Map<String, Object>> pagination();

    /**
     * query for page
     *
     * @param <E>  wrapper type
     * @param type wrapper type
     * @return list
     */
    <E> PaginationResults<E> pagination(Class<E> type);

    /**
     * query for page
     *
     * @param <E>       wrapper type
     * @param rowMapper rowMapper
     * @return list
     */
    <E> PaginationResults<E> pagination(RowMapper<E> rowMapper);
}
