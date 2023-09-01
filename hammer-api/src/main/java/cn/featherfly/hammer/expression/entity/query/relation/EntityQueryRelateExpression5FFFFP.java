
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryRelateExpression5FFFFP.
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
public interface EntityQueryRelateExpression5FFFFP<E, R1, R2, R3, R4, R5,
        C extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple5<E, R1, R2, R3, R4>>,
        L extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple5<E, R1, R2, R3, R4>>,
        S extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R2, R3, R4>>,
        F extends EntityQueryRelatedFetchedExpression5FFFFP<E, R1, R2, R3, R4, R5, C, L, S>>
        extends EntityQueryExpression6<E, R1, R2, R3, R4, R5, C, L, S, Tuple5<E, R1, R2, R3, R4>>, QueryRelate<F> {
    // 目前就实现5次关联（join）
}
