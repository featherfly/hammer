
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression4.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression4<E, E2, E3, E4,
        C extends EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L, S, R>,
        S extends EntityQuerySortExpression4<E, E2, E3, E4, R>, R>
        extends EntityQueryWhereExpression4<E, E2, E3, E4, C, L, S, R>, EntityQueryListExecutor<R>, QueryCountExecutor,
        EntityQueryConditionLimit<R>, Queryable<S> {
}
