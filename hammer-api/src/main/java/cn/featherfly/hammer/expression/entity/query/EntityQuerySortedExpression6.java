
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression6;

/**
 * The Interface EntityQuerySortedExpression6.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <E6> sixth filterable entity type
 * @param <R>  query result type
 */
public interface EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, R>
    extends EntitySortedExpression6<E1, E2, E3, E4, E5, E6, EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, R>>,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntityQueryLimitExecutor<R> {

}
