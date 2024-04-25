
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery2;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate1P.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 */
public interface EntityQueryRelate1P<E, R1> extends EntityQueryRelate1XBase<E, R1>,
    QueryRelateExpression<EntityQueryRelatedFetched1P<E, R1>>, EntityQuery2<E, R1, E> {
}
