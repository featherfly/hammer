
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate5RRRFR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public interface EntityQueryRelate5RRRFR<E, R1, R2, R3, R4, R5>
        extends QueryRelateExpression<EntityQueryRelatedFetched5RRRFF<E, R1, R2, R3, R4, R5>>,
        EntityQuery6<E, R1, R2, R3, R4, R5, Tuple2<E, R4>> {

}
