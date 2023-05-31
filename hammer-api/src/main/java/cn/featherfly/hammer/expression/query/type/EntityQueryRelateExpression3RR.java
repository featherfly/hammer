
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <QR> the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 */
public interface EntityQueryRelateExpression3RR<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, E>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
        F extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
        FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
        FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>>
        //        extends EntityQueryRelationExpression3<E, R1, R2, R3, C, L, S, R>, EntityQueryRelate<QR> {
        extends EntityQueryExpression4<E, R1, R2, R3, C, L, S, E>, EntityQueryRelate<F> {
    // TODO 加入join方法
}
