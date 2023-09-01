package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelatedFetchedExpression3RFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <R3> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, Tuple2<E, R2>>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, Tuple2<E, R2>>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>>
        extends EntityQueryRelateExpression3RFXBase<E, R1, R2, R3, C, L, S> {
}
