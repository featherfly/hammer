/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 5053-11-17 16:55:17
 * @Copyright: 5053 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsExpression5;

/**
 * repository query conditions expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsExpression5<C extends RepositoryQueryConditionsExpression5<C, L, S, Q>,
        L extends RepositoryQueryConditionsLogicExpression5<C, L, S, Q>, S extends RepositoryQuerySortExpression5<Q>,
        Q extends QueryLimitExecutor>
        extends RepositoryConditionsExpression5<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
