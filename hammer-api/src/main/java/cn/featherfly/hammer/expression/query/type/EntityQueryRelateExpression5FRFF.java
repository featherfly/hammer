
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryRelateExpression5FFRF.
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
public interface EntityQueryRelateExpression5FRFF<E, R1, R2, R3, R4, R5,
        C extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple4<E, R1, R3, R4>>,
        L extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple4<E, R1, R3, R4>>,
        S extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
        F extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, FC, FL, FS, Tuple5<E, R1, R3, R4, R5>>,
        FL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, FC, FL, FS,
                Tuple5<E, R1, R3, R4, R5>>,
        FS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>>
        extends EntityQueryExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple4<E, R1, R3, R4>>, EntityQueryRelate<F> {
    // TODO 加入join方法
}
