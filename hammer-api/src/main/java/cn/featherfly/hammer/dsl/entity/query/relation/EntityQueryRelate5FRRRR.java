
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate5FRRRR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public interface EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5>
        extends EntityQueryRelate5FRRRXBase<E, R1, R2, R3, R4, R5>,
        QueryRelateExpression<EntityQueryRelatedFetched5FRRRF<E, R1, R2, R3, R4, R5>> {

}
