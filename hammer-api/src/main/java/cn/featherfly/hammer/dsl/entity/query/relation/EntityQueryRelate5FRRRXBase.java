
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;

/**
 * The Interface EntityQueryRelate5FRRRXBase.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 */
public interface EntityQueryRelate5FRRRXBase<E, R1, R2, R3, R4, R5>
        extends EntityQuery6<E, R1, R2, R3, R4, R5, Tuple2<E, R1>> {
    // 目前就实现5次关联（join）
}
