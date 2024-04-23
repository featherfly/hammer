
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * repository query expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryExpression<C extends RepositoryQueryConditionsGroupExpression<C, L, S>,
    L extends RepositoryQueryConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
    extends RepositoryQueryWhereExpression<C, L, S>,
    ConfigureExpression<RepositoryQueryExpression<C, L, S>, QueryConfig, QueryConditionConfig>,
    RepositoryQueryableExpression<S, QueryLimitExecutor> {
}
