
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * entity query value one expression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueOneExpression<E, V, C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
        S extends EntityQueryValueSortExpression<E, V>> extends EntityQueryValueWhereExpression<E, V, C, L, S>,
        EntityQueryOneExecutor<V>, QueryCountExecutor, EntityQueryConditionLimit<V>, Queryable<S> {
}
