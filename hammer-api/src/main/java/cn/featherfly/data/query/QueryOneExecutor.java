
package cn.featherfly.data.query;

/**
 * type query one executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface QueryOneExecutor<E> extends QuerySingleExecutor<E>, QueryUniqueExecutor<E> {

}
