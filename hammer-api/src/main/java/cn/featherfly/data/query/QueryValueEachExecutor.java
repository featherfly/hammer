
package cn.featherfly.data.query;

import cn.featherfly.common.repository.RowIterable;

/**
 * query value each executor.
 *
 * @author zhongj
 */
public interface QueryValueEachExecutor {

    /**
     * query for each.
     *
     * @param <E> the value type
     * @return each iterable
     */
    <E> RowIterable<E> each();
}