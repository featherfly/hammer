
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate4FFFR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelate4FFFR<E, R1, R2, R3, R4> extends EntityQueryRelate4FFFXBase<E, R1, R2, R3, R4>,
    QueryRelateExpression<EntityQueryRelatedFetched4FFFF<E, R1, R2, R3, R4>>,
    EntityQuery5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R3>> {

}
