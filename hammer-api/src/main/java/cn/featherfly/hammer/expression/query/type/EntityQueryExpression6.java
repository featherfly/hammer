
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression6;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression6.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression6<E, E2, E3, E4, E5, E6,
        C extends EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        S extends EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>, R>
        extends EntityQueryWhereExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>, EntityQueryListExecutor<R>,
        QueryCountExecutor, EntityQueryConditionLimit<R>, Queryable<S> {
}
