
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * repository query expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression2<C extends RepositoryQueryConditionsGroupExpression2<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression2<S2, Q>, S2 extends RepositoryQuerySortedExpression2<S2, Q>,
    Q extends QueryLimitExecutor>
    extends ConfigureExpression<RepositoryQueryExpression2<C, L, S, S2, Q>, DslQueryConfig, QueryConditionConfig>,
    RepositoryQueryWhereExpression2<C, L, S, S2, Q>, RepositoryQueryable2<S, S2, Q> {

}
