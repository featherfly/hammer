
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate5FFFFR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public interface EntityQueryRelate5FFFFR<E, R1, R2, R3, R4, R5>
        extends QueryRelateExpression<EntityQueryRelatedFetched5FFFFF<E, R1, R2, R3, R4, R5>>,
        EntityQuery6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>> {

}
