
package cn.featherfly.hammer.expression.type;

/**
 * dsl for generic type query single executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface GenericTypeQuerySingleExecutor<E> {

    /**
     * query for single, return null when not found.
     *
     * @return object
     */
    E single();
}
