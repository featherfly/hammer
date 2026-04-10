
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

/**
 * repository query expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryExpression3<C extends RepositoryQueryConditionsGroupExpression3<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression3<S2, Q>, S2 extends RepositoryQuerySortedExpression3<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>>
    extends ConfigureExpression<RepositoryQueryExpression3<C, L, S, S2, Q>, DslQueryConfig, QueryConditionConfig>,
    RepositoryQueryWhereExpression3<C, L, S, S2, Q>, RepositoryQueryable3<S, S2, Q> {
}
