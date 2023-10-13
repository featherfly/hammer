
package cn.featherfly.hammer.expression.entity.query;

/**
 * dsl for entity query limit executor.
 *
 * @author zhongj
 * @param <E> the query type
 */
public interface EntityQueryLimitExecutor<E> extends EntityQueryExecutor<E>, EntityQueryPageExecutor<E> {

}