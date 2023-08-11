
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression7;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression7.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupLogicExpression7<E, E2, E3, E4, E5, E6, E7,
        C extends EntityQueryConditionGroupExpression7<E, E2, E3, E4, E5, E6, E7, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression7<E, E2, E3, E4, E5, E6, E7, C, L, S, R>,
        S extends EntityQuerySortExpression7<E, E2, E3, E4, E5, E6, E7, R>, R>
        extends EntityConditionGroupLogicExpression7<E, E2, E3, E4, E5, E6, E7, C, L>, Queryable<S>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R>, QueryCountExecutor {

}
