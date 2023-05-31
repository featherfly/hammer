package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression7;

/**
 * The Interface EntityQueryRelationFetchExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> relate from type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 * @param <R6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryRelatedFetchedExpression6RRRRRF<E, R1, R2, R3, R4, R5, R6,
        C extends EntityQueryConditionGroupExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, Tuple2<E, R6>>,
        L extends EntityQueryConditionGroupLogicExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, Tuple2<E, R6>>,
        S extends EntityQuerySortExpression7<E, R1, R2, R3, R4, R5, R6, Tuple2<E, R6>>>
        //        extends EntityQueryRelationExpression6<E, R1, R2, R3, R4, R5, R6, C, L, Tuple2<E, R6>> {
        extends EntityQueryExpression7<E, R1, R2, R3, R4, R5, R6, C, L, S, Tuple2<E, R6>> {

}
