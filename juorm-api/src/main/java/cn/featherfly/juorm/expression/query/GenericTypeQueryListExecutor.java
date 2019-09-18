
package cn.featherfly.juorm.expression.query;

import java.util.List;

/**
 * <p>
 * dsl for query list executor
 * </p>
 *
 * @author zhongj
 */
public interface GenericTypeQueryListExecutor<E> {

    /**
     * query for list
     *
     * @return list
     */
    List<E> list();
}
