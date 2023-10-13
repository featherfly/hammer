
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * The Interface EntityQueryRelate2FP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2FP<E, R1, R2> extends EntityQueryRelate2FXBase<E, R1, R2>,
        QueryRelate<EntityQueryRelatedFetched2FP<E, R1, R2>>, EntityQuery3<E, R1, R2, Tuple2<E, R1>> {

}
