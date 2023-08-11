
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.type.GenericTypeQueryExecutor;

/**
 * dsl for entity query executor.
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface EntityQueryExecutor<E>
        extends EntityQueryListExecutor<E>, EntityQueryOneExecutor<E>, GenericTypeQueryExecutor<E> {

}
