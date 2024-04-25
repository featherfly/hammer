
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate3FRP.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public interface EntityQueryRelate3FRP<E, R1, R2, R3> extends EntityQueryRelate3FRXBase<E, R1, R2, R3>,
    QueryRelateExpression<EntityQueryRelatedFetched3FRP<E, R1, R2, R3>>, EntityQuery4<E, R1, R2, R3, Tuple2<E, R1>> {

}
