
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression2;

/**
 * The Interface EntityQuerySortedExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <R>  query result type
 */
public interface EntityQuerySortExpression2<E1, E2, R>
    extends EntitySortExpression2<E1, E2, EntityQuerySortedExpression2<E1, E2, R>> {

}
