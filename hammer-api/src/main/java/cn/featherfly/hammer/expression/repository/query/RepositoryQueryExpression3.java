
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * repository query expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression3<C extends RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>, S extends RepositoryQuerySortExpression3<Q>,
    Q extends QueryLimitExecutor>
    extends ConfigureExpression<RepositoryQueryExpression3<C, L, S, Q>, DslQueryConfig, QueryConditionConfig>,
    RepositoryQueryWhereExpression3<C, L, S, Q>, RepositoryQueryableExpression<S, Q> {
}
