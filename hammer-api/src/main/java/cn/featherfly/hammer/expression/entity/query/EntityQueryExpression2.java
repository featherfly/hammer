
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <S2> sorted expression
 * @param <R> query result type
 */
public interface EntityQueryExpression2<E1, E2, C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, S, S2, R>,
    S extends EntityQuerySortExpression2<E1, E2, R>, S2 extends EntityQuerySortedExpression2<E1, E2, R>, R>
    extends EntityQueryWhereExpression2<E1, E2, C, L, S, S2, R>, EntityQueryListExecutor<R>, QueryCountExecutor,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntitySortable2<E1, E2, S, S2> {
}
