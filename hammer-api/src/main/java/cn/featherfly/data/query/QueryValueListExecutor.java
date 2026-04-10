
package cn.featherfly.data.query;

import java.util.List;

/**
 * query value list executor.
 *
 * @author zhongj
 */
public interface QueryValueListExecutor {

    /**
     * query for list.
     *
     * @param <E> the value type
     * @return list
     */
    <E> List<E> list();
}
