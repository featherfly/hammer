
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate4FRFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public interface EntityQueryRelate4FRFP<E, R1, R2, R3, R4> extends EntityQueryRelate4FRFXBase<E, R1, R2, R3, R4>,
        QueryRelate<EntityQueryRelatedFetched4FRFP<E, R1, R2, R3, R4>>,
        EntityQuery5<E, R1, R2, R3, R4, Tuple3<E, R1, R3>> {

}
