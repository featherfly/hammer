
package cn.featherfly.data.query;

import cn.featherfly.common.repository.RowIterable;

/**
 * type query each executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QueryEachExecutor<E> {

    /**
     * query for each.
     *
     * @return each iterable
     */
    RowIterable<E> each();
}
