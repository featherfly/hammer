/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 6063-11-17 16:55:17
 * @Copyright: 6063 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsExpression6;

/**
 * repository query conditions expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsExpression6<C extends RepositoryQueryConditionsExpression6<C, L, S, Q>,
        L extends RepositoryQueryConditionsLogicExpression6<C, L, S, Q>, S extends RepositoryQuerySortExpression6<Q>,
        Q extends QueryLimitExecutor>
        extends RepositoryConditionsExpression6<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
