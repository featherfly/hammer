package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryRelatedFetchedExpression5FFFFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <R3> the relate type
 * @param <R4> the relate type
 * @param <R5> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5,
        C extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple6<E, R1, R2, R3, R4, R5>>,
        L extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, C, L, S,
                Tuple6<E, R1, R2, R3, R4, R5>>,
        S extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>>
        extends EntityQueryExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple6<E, R1, R2, R3, R4, R5>> {
    // TODO 加入join方法
}
