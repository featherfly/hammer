
package cn.featherfly.data.query;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * query value page executor.
 *
 * @author zhongj
 */
public interface QueryValuePageExecutor {

    /**
     * query for page.
     *
     * @param <E> the value type
     * @return PaginationResults
     */
    <E> PaginationResults<E> pagination();
}
