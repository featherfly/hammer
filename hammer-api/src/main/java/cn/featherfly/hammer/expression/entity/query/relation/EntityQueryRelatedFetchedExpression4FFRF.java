package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelatedFetchedExpression4FFRF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <R3> the relate type
 * @param <R4> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression4FFRF<E, R1, R2, R3, R4,
        C extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R2, R4>>,
        L extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R2, R4>>,
        S extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R2, R4>>>
        extends EntityQueryExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R2, R4>> {
    // TODO 加入join方法
}
