
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate4RFRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public interface EntityQueryRelate4RFRP<E, R1, R2, R3, R4> extends EntityQueryRelate4RFRXBase<E, R1, R2, R3, R4>,
        QueryRelate<EntityQueryRelatedFetched4RFRP<E, R1, R2, R3, R4>>, EntityQuery5<E, R1, R2, R3, R4, Tuple2<E, R2>> {

}