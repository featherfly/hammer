
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression3;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <R>  query result type
 */
public interface EntityQuerySortedExpression3<E1, E2, E3, R>
    extends EntitySortedExpression3<E1, E2, E3, EntityQuerySortedExpression3<E1, E2, E3, R>>,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntityQueryLimitExecutor<R> {

}
