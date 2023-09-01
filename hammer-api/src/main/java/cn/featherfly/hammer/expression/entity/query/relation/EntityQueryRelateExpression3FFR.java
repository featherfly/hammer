
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelateExpression3FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression3FFR<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, Tuple3<E, R1, R2>>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, Tuple3<E, R1, R2>>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
        F extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple4<E, R1, R2, R3>>,
        FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple4<E, R1, R2, R3>>,
        FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>>
        extends EntityQueryRelateExpression3FFXBase<E, R1, R2, R3, C, L, S>, QueryRelate<F> {
}
