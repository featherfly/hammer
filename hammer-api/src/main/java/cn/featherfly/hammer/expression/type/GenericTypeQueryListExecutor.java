
package cn.featherfly.hammer.expression.type;

import java.util.List;

/**
 * dsl for generic type query list executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface GenericTypeQueryListExecutor<E> {

    /**
     * query for list.
     *
     * @return list
     */
    List<E> list();
}
