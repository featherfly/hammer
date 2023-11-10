
package cn.featherfly.hammer.expression.query;

import java.util.List;

/**
 * query type list executor.
 *
 * @author zhongj
 */
public interface QueryTypeListExecutor {

    /**
     * query for list
     *
     * @param <E>  the element type
     * @param type the type
     * @return list
     */
    <E> List<E> list(Class<E> type);
}
