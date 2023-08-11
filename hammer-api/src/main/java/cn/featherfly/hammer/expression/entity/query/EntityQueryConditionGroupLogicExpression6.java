
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6,
        C extends EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        S extends EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>, R>
        extends EntityConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L>, Queryable<S>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R>, QueryCountExecutor {

}
