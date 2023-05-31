package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression8;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression8;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression8;

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
 * @param <R7> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression7RRRRRRF<E, R1, R2, R3, R4, R5, R6, R7,
        C extends EntityQueryConditionGroupExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, Tuple2<E, R7>>,
        L extends EntityQueryConditionGroupLogicExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, Tuple2<E, R7>>,
        S extends EntityQuerySortExpression8<E, R1, R2, R3, R4, R5, R6, R7, Tuple2<E, R7>>> extends
        //        EntityQueryRelationExpression7<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, Tuple8<E, R1, R2, R3, R4, R5, R6, R7>> {
        EntityQueryExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, Tuple2<E, R7>> {

}
