package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * The Interface EntityQueryRelationFetchExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> relate from type
 * @param <R2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression2FF<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>>,
        S extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>>
        //    extends EntityQueryRelationExpression2<E, R1, R2, C, L, S, Tuple3<E, R1, R2>> {
        extends EntityQueryExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>> {

}
