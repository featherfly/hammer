
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for entity query limit executor.
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface EntityQueryValueLimitExecutor<E, V> extends EntityQueryLimitExecutor<E> //
        , EntityQueryValueExecutor<V> {
    /**
     * query value for page.
     *
     * @return PaginationResults
     */
    PaginationResults<V> valuePagination();
}
