
package cn.featherfly.hammer.expression.query;

/**
 * <p>
 * dsl for query single executor
 * </p>
 * .
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
     * query for unique, throw JdbcException when not found.
     *
     * @return object
     */
    E unique();
}
