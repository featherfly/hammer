
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression4;

/**
 * repository query sorted expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression4<S extends RepositoryQuerySortedExpression4<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortedExpression4<S>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
