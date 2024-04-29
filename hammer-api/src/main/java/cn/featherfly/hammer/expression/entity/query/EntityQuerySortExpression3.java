
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression3;

/**
 * The Interface EntityQuerySortExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <R>  query result type
 */
public interface EntityQuerySortExpression3<E1, E2, E3, R>
    extends EntitySortExpression3<E1, E2, E3, EntityQuerySortedExpression3<E1, E2, E3, R>> {

}
