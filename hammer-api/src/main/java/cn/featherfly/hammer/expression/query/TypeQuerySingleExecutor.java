
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
     * query for single.
     *
     * @param <E> the element type
     * @return object
     */
    <E> E single();
}
