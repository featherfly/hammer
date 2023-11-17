
package cn.featherfly.hammer.expression.type;

/**
 * dsl for generic type query limit executor.
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface GenericTypeQueryLimitExecutor<E> extends GenericTypeQueryExecutor<E>, GenericTypeQueryPageExecutor<E> {

}
