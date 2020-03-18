
package cn.featherfly.hammer.expression.query;

/**
 * <p>
 * dsl for query single executor
 * </p>
 *
 * @author zhongj
 */
public interface GenericTypeQuerySingleExecutor<E> {
    /**
     * query for single
     *
     * @return object
     */
    E single();
}
