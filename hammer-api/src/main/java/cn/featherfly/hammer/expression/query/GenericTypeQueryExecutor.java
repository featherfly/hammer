
package cn.featherfly.hammer.expression.query;

/**
 * dsl for query executor.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface GenericTypeQueryExecutor<E>
        extends GenericTypeQueryListExecutor<E>, GenericTypeQuerySingleExecutor<E> {

}
