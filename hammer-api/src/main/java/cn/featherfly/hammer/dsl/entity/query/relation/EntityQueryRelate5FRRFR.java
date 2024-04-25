
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate5FRRFR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public interface EntityQueryRelate5FRRFR<E, R1, R2, R3, R4, R5>
        extends QueryRelateExpression<EntityQueryRelatedFetched5FRRFF<E, R1, R2, R3, R4, R5>>,
        EntityQuery6<E, R1, R2, R3, R4, R5, Tuple3<E, R1, R4>> {

}
