
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityConditionGroupLogicExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupLogicExpression5<E, E2, E3, E4, E5,
        C extends EntityQueryConditionGroupExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        S extends EntityQuerySortExpression5<E, E2, E3, E4, E5, R>, R>
        extends EntityConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L>, Queryable<S>,
        EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntityQueryLimitExecutor<R>, QueryCountExecutor {

}
