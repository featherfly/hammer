
package cn.featherfly.data.query;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for generic type query page executor .
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface QueryPageExecutor<E> {

    /**
     * query for page.
     *
     * @return PaginationResults
     */
    PaginationResults<E> pagination();
}
