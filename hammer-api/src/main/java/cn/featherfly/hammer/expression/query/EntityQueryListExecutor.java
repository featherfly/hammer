
package cn.featherfly.hammer.expression.query;

import java.util.List;

/**
 * dsl for query list executor.
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface EntityQueryListExecutor<E> {

    /**
     * query for list.
     *
     * @return list
     */
    List<E> list();
}
