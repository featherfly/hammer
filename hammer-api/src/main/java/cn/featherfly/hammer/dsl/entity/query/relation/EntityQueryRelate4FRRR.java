
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate4FRRR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelate4FRRR<E, R1, R2, R3, R4> extends EntityQueryRelate4FRRXBase<E, R1, R2, R3, R4>,
        QueryRelateExpression<EntityQueryRelatedFetched4FRRF<E, R1, R2, R3, R4>>, EntityQuery5<E, R1, R2, R3, R4, Tuple2<E, R1>> {

}
