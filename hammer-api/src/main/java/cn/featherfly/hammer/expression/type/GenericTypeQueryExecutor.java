
package cn.featherfly.hammer.expression.type;

/**
 * dsl for generic type query executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface GenericTypeQueryExecutor<E> extends GenericTypeQueryListExecutor<E>, GenericTypeQueryOneExecutor<E> {

}
