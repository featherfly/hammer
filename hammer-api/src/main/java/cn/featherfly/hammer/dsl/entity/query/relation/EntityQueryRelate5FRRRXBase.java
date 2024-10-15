
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;

/**
 * The Interface EntityQueryRelate5FRRRXBase.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public interface EntityQueryRelate5FRRRXBase<E, R1, R2, R3, R4, R5>
    extends EntityQuery6<E, R1, R2, R3, R4, R5, Tuple2<E, R1>> {
    // 目前就实现5次关联（join）
}
