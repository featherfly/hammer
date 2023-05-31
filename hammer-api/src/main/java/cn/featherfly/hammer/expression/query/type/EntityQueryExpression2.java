
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression2;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression2.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression2<E, E2, C extends EntityQueryConditionGroupExpression2<E, E2, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, S, R>,
        S extends EntityQuerySortExpression2<E, E2, R>, R> extends EntityQueryWhereExpression2<E, E2, C, L, S, R>,
        EntityQueryListExecutor<R>, QueryCountExecutor, EntityQueryConditionLimit<R>, Queryable<S> {
}
