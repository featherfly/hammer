
package cn.featherfly.hammer.expression.query.type;

/**
 * dsl for query single executor .
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface EntityQuerySingleExecutor<E> {

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
