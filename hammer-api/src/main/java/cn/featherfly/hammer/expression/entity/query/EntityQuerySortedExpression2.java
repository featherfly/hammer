
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression2;

/**
 * The Interface EntityQuerySortedExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <R> query result type
 */
public interface EntityQuerySortedExpression2<E1, E2, R>
    extends EntitySortedExpression2<E1, E2, EntityQuerySortedExpression2<E1, E2, R>>,
    QueryLimitSetter<QueryLimitExecutor<R>>, QueryLimitExecutor<R> {

}
