
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression4;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <R>  query result type
 */
public interface EntityQuerySortedExpression4<E1, E2, E3, E4, R>
    extends EntitySortedExpression4<E1, E2, E3, E4, EntityQuerySortedExpression4<E1, E2, E3, E4, R>>,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntityQueryLimitExecutor<R> {

}
