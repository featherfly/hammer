
package cn.featherfly.hammer.expression.type;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for generic type query page executor .
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface GenericTypeQueryPageExecutor<E> {

    /**
     * query for page.
     *
     * @return PaginationResults
     */
    PaginationResults<E> pagination();
}
