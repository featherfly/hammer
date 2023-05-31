
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

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
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression5RRRR<E, R1, R2, R3, R4, R5,
        C extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, C, L, S, E>,
        S extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, E>,
        F extends EntityQueryRelatedFetchedExpression5RRRRF<E, R1, R2, R3, R4, R5, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, FC, FL, FS, Tuple2<E, R5>>,
        FL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, FC, FL, FS, Tuple2<E, R5>>,
        FS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R5>>>
        //        extends EntityQueryRelationExpression5<E, R1, R2, R3, R4, R5, C, L, R>, EntityQueryRelate<QR> {
        extends EntityQueryExpression6<E, R1, R2, R3, R4, R5, C, L, S, E>, EntityQueryRelate<F> {
    // TODO 加入join方法
}
