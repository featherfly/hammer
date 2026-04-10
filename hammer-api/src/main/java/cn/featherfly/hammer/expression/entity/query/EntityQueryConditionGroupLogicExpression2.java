
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression2;

/**
 * The Interface EntityConditionGroupLogicExpression2.
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
public interface EntityQueryConditionGroupLogicExpression2<E1, E2,
    C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, S, S2, R>,
    S extends EntityQuerySortExpression2<E1, E2, R>, S2 extends EntityQuerySortedExpression2<E1, E2, R>, R>
    extends EntityConditionGroupLogicExpression2<E1, E2, C, L>, EntityQueryable2<E1, E2, S, S2>,
    QueryLimitSetter<QueryLimitExecutor<R>>, QueryLimitExecutor<R>, QueryCountExecutor {
}
