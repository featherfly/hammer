
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryRelateExpression5FRRRP.
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
 */
public interface EntityQueryRelateExpression5FRRRP<E, R1, R2, R3, R4, R5,
        C extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple2<E, R1>>,
        L extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple2<E, R1>>,
        S extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R1>>,
        F extends EntityQueryRelatedFetchedExpression5FRRRP<E, R1, R2, R3, R4, R5, C, L, S>>
        extends EntityQueryRelateExpression5FRRRXBase<E, R1, R2, R3, R4, R5, C, L, S>, QueryRelate<F> {

}
