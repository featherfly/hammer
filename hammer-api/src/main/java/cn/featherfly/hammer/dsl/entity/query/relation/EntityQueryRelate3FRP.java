
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate3FRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3FRP<E, R1, R2, R3> extends EntityQueryRelate3FRXBase<E, R1, R2, R3>,
        QueryRelate<EntityQueryRelatedFetched3FRP<E, R1, R2, R3>>, EntityQuery4<E, R1, R2, R3, Tuple2<E, R1>> {

}
