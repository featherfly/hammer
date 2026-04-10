
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

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
    ConfigureExpression<RepositoryQueryExpression<C, L, S>, DslQueryConfig, QueryConditionConfig>,
    RepositoryQueryableExpression<S, LimitAwareQuery1<Map<String, Serializable>>> {
}
