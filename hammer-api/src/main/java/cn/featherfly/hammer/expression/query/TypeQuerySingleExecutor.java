
package cn.featherfly.hammer.expression.query;

/**
 * <p>
 * dsl for query single executor
 * </p>
 *
 * @author zhongj
 */
public interface TypeQuerySingleExecutor {

    /**
     * query for single, return null when not found.
     *
     * @param <E> the element type
     * @return object
     */
    <E> E single();

    /**
     * query for unique, throw JdbcException when not found.
     *
     * @param <E> the element type
     * @return object
     */
    <E> E unique();
}
