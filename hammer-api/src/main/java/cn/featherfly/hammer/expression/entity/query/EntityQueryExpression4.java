
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 * @param <R>  query result type
 */
public interface EntityQueryExpression4<E1, E2, E3, E4,
    C extends EntityQueryConditionGroupExpression4<E1, E2, E3, E4, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, S, R>,
    S extends EntityQuerySortExpression4<E1, E2, E3, E4, R>, R>
    extends EntityQueryWhereExpression4<E1, E2, E3, E4, C, L, S, R>, EntityQueryListExecutor<R>, QueryCountExecutor,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, Queryable<S> {
}
