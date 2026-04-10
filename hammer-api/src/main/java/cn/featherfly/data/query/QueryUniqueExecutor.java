
package cn.featherfly.data.query;

/**
 * type query unique executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QueryUniqueExecutor<E> {

    /**
     * query for unique, throw exception when not found.
     *
     * @return object
     */
    E unique();
}
