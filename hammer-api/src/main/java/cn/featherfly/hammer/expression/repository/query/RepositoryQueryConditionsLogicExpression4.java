/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 4043-11-17 16:55:17
 * @Copyright: 4043 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.Queryable;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsLogicExpression4;

/**
 * repository query conditions logic expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsLogicExpression4<C extends RepositoryQueryConditionsExpression4<C, L, S, Q>,
        L extends RepositoryQueryConditionsLogicExpression4<C, L, S, Q>, S extends RepositoryQuerySortExpression4<Q>,
        Q extends QueryLimitExecutor> extends RepositoryConditionsLogicExpression4<C, L>, Queryable<S>,
        QueryCountExecutor, QueryConditionLimit<Q>, QueryLimitExecutor {
}
