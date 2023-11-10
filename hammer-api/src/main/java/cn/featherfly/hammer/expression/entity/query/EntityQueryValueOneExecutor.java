
package cn.featherfly.hammer.expression.entity.query;

/**
 * dsl for entity query value executor.
 *
 * @author zhongj
 */
public interface EntityQueryValueOneExecutor<V> {

    /**
     * query for value.
     *
     * @return value
     */
    V value();
}
