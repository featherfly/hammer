
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;

/**
 * The Interface EntityQueryRelatedFetched4RRFP.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelatedFetched4RRFP<E, R1, R2, R3, R4>
        extends EntityQueryRelate4RRFXBase<E, R1, R2, R3, R4>, EntityQuery5<E, R1, R2, R3, R4, Tuple2<E, R3>> {

}
