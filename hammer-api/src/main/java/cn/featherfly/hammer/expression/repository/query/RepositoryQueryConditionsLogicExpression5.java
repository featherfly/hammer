/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 5053-11-17 16:55:17
 * @Copyright: 5053 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.Queryable;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsLogicExpression5;

/**
 * repository query conditions logic expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsLogicExpression5<C extends RepositoryQueryConditionsExpression5<C, L, S, Q>,
        L extends RepositoryQueryConditionsLogicExpression5<C, L, S, Q>, S extends RepositoryQuerySortExpression5<Q>,
        Q extends QueryLimitExecutor> extends RepositoryConditionsLogicExpression5<C, L>, Queryable<S>,
        QueryCountExecutor, QueryConditionLimit<Q>, QueryLimitExecutor {
}
