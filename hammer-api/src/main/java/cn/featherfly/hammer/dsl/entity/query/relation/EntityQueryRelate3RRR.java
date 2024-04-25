
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate3RRR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public interface EntityQueryRelate3RRR<E, R1, R2, R3> extends EntityQueryRelate3RRXBase<E, R1, R2, R3>,
    QueryRelateExpression<EntityQueryRelatedFetched3RRF<E, R1, R2, R3>>, EntityQuery4<E, R1, R2, R3, E> {

}
