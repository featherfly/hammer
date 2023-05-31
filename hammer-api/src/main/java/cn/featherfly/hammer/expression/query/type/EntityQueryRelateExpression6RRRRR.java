
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression7;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 * @param <R6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression6RRRRR<E, R1, R2, R3, R4, R5, R6,
        C extends EntityQueryConditionGroupExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, E>,
        S extends EntityQuerySortExpression7<E, R1, R2, R3, R4, R5, R6, E>,
        F extends EntityQueryRelatedFetchedExpression6RRRRRF<E, R1, R2, R3, R4, R5, R6, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression7<E, R1, R2, R3, R4, R5, R6, FC, FL, FS, Tuple2<E, R6>>,
        FL extends EntityQueryConditionGroupLogicExpression7<E, R1, R2, R3, R4, R5, R6, FC, FL, FS, Tuple2<E, R6>>,
        FS extends EntityQuerySortExpression7<E, R1, R2, R3, R4, R5, R6, Tuple2<E, R6>>>
        //        extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, C, L, R>, EntityQueryRelate<QR> {
        extends EntityQueryExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, E>, EntityQueryRelate<F> {
    // TODO 加入join方法
}
