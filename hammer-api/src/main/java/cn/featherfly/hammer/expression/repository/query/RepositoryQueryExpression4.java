
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

/**
 * repository query expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression4<C extends RepositoryQueryConditionsGroupExpression4<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression4<S2, Q>, S2 extends RepositoryQuerySortedExpression4<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>>
    extends ConfigureExpression<RepositoryQueryExpression4<C, L, S, S2, Q>, DslQueryConfig, QueryConditionConfig>,
    RepositoryQueryWhereExpression4<C, L, S, S2, Q>, RepositoryQueryable4<S, S2, Q> {
}
