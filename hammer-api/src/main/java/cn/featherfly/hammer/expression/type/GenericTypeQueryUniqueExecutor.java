
package cn.featherfly.hammer.expression.type;

/**
 * dsl for generic type query unique executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface GenericTypeQueryUniqueExecutor<E> {

    /**
     * query for unique, throw exception when not found.
     *
     * @return object
     */
    E unique();
}
