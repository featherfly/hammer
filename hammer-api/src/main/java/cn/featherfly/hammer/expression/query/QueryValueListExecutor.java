
package cn.featherfly.hammer.expression.query;

import java.util.List;

/**
 * query value list executor.
 *
 * @author zhongj
 */
public interface QueryValueListExecutor extends QueryTypeListExecutor {

    /**
     * query for list
     *
     * @param <E>  wrapper type
     * @param type wrapper type
     * @return list
     */
    <E> List<E> list();
}
