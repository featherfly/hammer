
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for entity query page executor .
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface EntityQueryPageExecutor<E> {

    /**
     * query for page.
     *
     * @return PaginationResults
     */
    PaginationResults<E> pagination();
}
