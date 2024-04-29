
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 * @param <R>  query result type
 */
public interface EntityQueryExpression2<E1, E2, C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, S, R>,
    S extends EntityQuerySortExpression2<E1, E2, R>, R>
    extends EntityQueryWhereExpression2<E1, E2, C, L, S, R>, EntityQueryListExecutor<R>, QueryCountExecutor,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, Queryable<S> {
}
