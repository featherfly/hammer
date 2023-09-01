
package cn.featherfly.hammer.expression.entity.query.relation;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelateExpression4RRRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R4,
        C extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, C, L, S, E>,
        S extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
        F extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, C, L, S>>
        extends EntityQueryRelateExpression4RRRXBase<E, R1, R2, R3, R4, C, L, S>, QueryRelate<F> {

}
