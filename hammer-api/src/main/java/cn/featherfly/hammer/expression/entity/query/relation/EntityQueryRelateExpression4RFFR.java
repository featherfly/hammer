
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelateExpression4RFFR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression4RFFR<E, R1, R2, R3, R4,
        C extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, C, L, S, Tuple3<E, R2, R3>>,
        L extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, C, L, S, Tuple3<E, R2, R3>>,
        S extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>,
        F extends EntityQueryRelatedFetchedExpression4RFFF<E, R1, R2, R3, R4, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, FC, FL, FS, Tuple4<E, R2, R3, R4>>,
        FL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, FC, FL, FS, Tuple4<E, R2, R3, R4>>,
        FS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>>>
        extends EntityQueryRelateExpression4RFFXBase<E, R1, R2, R3, R4, C, L, S>, QueryRelate<F> {

}
