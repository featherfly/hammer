
package cn.featherfly.hammer.expression.query;

/**
 * dsl for query single executor.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface GenericTypeQuerySingleExecutor<E> {

    /**
     * query for single, return null when not found.
     *
     * @return object
     */
    E single();

    /**
     * query for unique, throw exception when not found.
     *
     * @return object
     */
    E unique();
}
