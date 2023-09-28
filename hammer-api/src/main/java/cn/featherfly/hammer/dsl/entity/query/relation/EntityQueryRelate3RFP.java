
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate3RFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3RFP<E, R1, R2, R3> extends EntityQueryRelate3RFXBase<E, R1, R2, R3>,
        QueryRelate<EntityQueryRelatedFetched3RFP<E, R1, R2, R3>>, EntityQuery4<E, R1, R2, R3, Tuple2<E, R2>> {

}
