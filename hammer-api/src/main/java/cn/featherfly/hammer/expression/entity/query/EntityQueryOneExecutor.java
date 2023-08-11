
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.type.GenericTypeQueryOneExecutor;

/**
 * dsl for entity query one executor .
 *
 * @author zhongj
 * @param <E> the query result type
 */
public interface EntityQueryOneExecutor<E>
        extends EntityQuerySingleExecutor<E>, EntityQueryUniqueExecutor<E>, GenericTypeQueryOneExecutor<E> {

}
