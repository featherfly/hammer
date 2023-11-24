/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 3033-11-17 16:55:17
 * @Copyright: 3033 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression3;

/**
 * repository query conditions group expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupExpression3<
        C extends RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>,
        S extends RepositoryQuerySortExpression3<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryConditionsExpression3<C, L, S, Q>, RepositoryConditionsGroupExpression3<C, L> {

}
