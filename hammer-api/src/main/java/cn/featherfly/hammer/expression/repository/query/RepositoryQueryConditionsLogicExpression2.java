/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:55:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.Queryable;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsLogicExpression2;

/**
 * repository query conditions logic expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsLogicExpression2<C extends RepositoryQueryConditionsExpression2<C, L, S, Q>,
        L extends RepositoryQueryConditionsLogicExpression2<C, L, S, Q>, S extends RepositoryQuerySortExpression2<Q>,
        Q extends QueryLimitExecutor> extends RepositoryConditionsLogicExpression2<C, L>, Queryable<S>,
        QueryCountExecutor, QueryConditionLimit<Q>, QueryLimitExecutor {
}
