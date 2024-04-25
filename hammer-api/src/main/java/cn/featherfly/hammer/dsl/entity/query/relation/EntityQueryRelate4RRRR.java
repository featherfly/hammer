
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate4RRRR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelate4RRRR<E, R1, R2, R3, R4> extends EntityQueryRelate4RRRXBase<E, R1, R2, R3, R4>,
        QueryRelateExpression<EntityQueryRelatedFetched4RRRF<E, R1, R2, R3, R4>>, EntityQuery5<E, R1, R2, R3, R4, E> {

}
