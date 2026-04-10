
package cn.featherfly.data.query;

/**
 * type query single executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QuerySingleExecutor<E> {

    /**
     * query for single, return null when not found.
     *
     * @return object
     */
    E single();
}
