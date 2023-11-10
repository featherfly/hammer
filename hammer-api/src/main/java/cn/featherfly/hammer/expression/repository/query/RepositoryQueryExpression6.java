
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository query expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression6<C extends RepositoryQueryConditionsGroupExpression6<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, Q>, S extends RepositoryQuerySortExpression6<Q>,
    Q extends QueryLimitExecutor> extends RepositoryQueryWhereExpression6<C, L, S, Q>, Queryable<S>, QueryListExecutor,
    QueryConditionLimit<Q>, QueryCountExecutor {
}
