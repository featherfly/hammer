
package cn.featherfly.data.query;

import java.util.List;

/**
 * type query list executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QueryListExecutor<E> {

    /**
     * query for list.
     *
     * @return list
     */
    List<E> list();
}
