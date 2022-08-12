
package cn.featherfly.hammer.expression.query;

import java.util.List;

/**
 * dsl for query list executor.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface GenericTypeQueryListExecutor<E> {

    /**
     * query for list.
     *
     * @return list
     */
    List<E> list();
}
