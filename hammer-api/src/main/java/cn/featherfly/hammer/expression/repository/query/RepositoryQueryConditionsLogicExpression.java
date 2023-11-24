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
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsLogicExpression;

/**
 * repository query conditions logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryConditionsLogicExpression<C extends RepositoryQueryConditionsExpression<C, L, S>,
        L extends RepositoryQueryConditionsLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
        extends RepositoryConditionsLogicExpression<C, L>, Queryable<S>, QueryConditionLimit<QueryLimitExecutor>,
        QueryLimitExecutor, QueryCountExecutor {
}
