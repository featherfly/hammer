
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E> the query type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryWhereExpression<E, C, L, S>, EntityQueryListExecutor<E>, QueryCountExecutor,
        EntityQueryConditionLimit<E>, Queryable<S> {
}
