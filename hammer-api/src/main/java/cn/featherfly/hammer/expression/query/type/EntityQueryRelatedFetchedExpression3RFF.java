package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelationFetchExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> relate from type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, Tuple3<E, R2, R3>>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, Tuple3<E, R2, R3>>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>>
        extends EntityQueryExpression4<E, R1, R2, R3, C, L, S, Tuple3<E, R2, R3>> {

}
