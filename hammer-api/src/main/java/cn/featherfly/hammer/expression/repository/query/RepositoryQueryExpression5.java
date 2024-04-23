
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * repository query expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression5<C extends RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>, S extends RepositoryQuerySortExpression5<Q>,
    Q extends QueryLimitExecutor>
    extends ConfigureExpression<RepositoryQueryExpression5<C, L, S, Q>, QueryConfig, QueryConditionConfig>,
    RepositoryQueryWhereExpression5<C, L, S, Q>, RepositoryQueryableExpression<S, Q> {
}
