
package cn.featherfly.juorm.expression.query;

/**
 * <p>
 * dsl for query single executor
 * </p>
 *
 * @author zhongj
 */
public interface TypeQuerySingleExecutor<E> {
    /**
     * query for single
     *
     * @param type wrapper type
     * @return object
     */
    E single();
}
