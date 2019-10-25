
package cn.featherfly.juorm.expression.query;

import java.util.List;

/**
 * <p>
 * dsl for query list executor
 * </p>
 * .
 *
 * @author zhongj
 */
public interface TypeQueryListExecutor {

    /**
     * query for list.
     *
     * @param <E> the element type
     * @return list
     */
    <E> List<E> list();
}
