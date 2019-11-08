
package cn.featherfly.juorm.expression.query;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * <p>
 * dsl for query page executor
 * </p>
 * .
 *
 * @author zhongj
 */
public interface TypeQueryPageExecutor {

    /**
     * query for page.
     *
     * @param <E> the element type
     * @return PaginationResults
     */
    <E> PaginationResults<E> pagination();
}
