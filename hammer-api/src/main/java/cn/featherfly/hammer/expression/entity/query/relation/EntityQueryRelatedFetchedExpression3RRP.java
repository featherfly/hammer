package cn.featherfly.hammer.expression.entity.query.relation;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelatedFetchedExpression3RRP.
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

public interface EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, E>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, E>>
        extends EntityQueryRelateExpression3RRXBase<E, R1, R2, R3, C, L, S> {

}
