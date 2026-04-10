
package cn.featherfly.data.query;

/**
 * type query executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QueryExecutor<E> extends QueryListExecutor<E>, QueryEachExecutor<E>, QueryOneExecutor<E> {

}
