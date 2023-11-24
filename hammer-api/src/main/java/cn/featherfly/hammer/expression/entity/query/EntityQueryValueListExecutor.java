
package cn.featherfly.hammer.expression.entity.query;

import java.util.List;

/**
 * dsl for entity query list value executor.
 *
 * @author zhongj
 */
public interface EntityQueryValueListExecutor<V> {

    /**
     * query for value.
     *
     * @return value
     */
    List<V> valueList();
}
