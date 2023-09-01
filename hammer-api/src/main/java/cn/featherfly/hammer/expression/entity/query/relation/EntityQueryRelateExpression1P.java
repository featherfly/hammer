
package cn.featherfly.hammer.expression.entity.query.relation;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

/**
 * The Interface EntityQueryRelateExpression1P.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 */
public interface EntityQueryRelateExpression1P<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>, F extends EntityQueryRelatedFetchedExpression1P<E, R1, C, L, S>>
        extends EntityQueryRelateExpression1XBase<E, R1, C, L, S>, QueryRelate<F> {

}
