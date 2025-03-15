
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression5;

/**
 * repository query sorted expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression5<S extends RepositoryQuerySortedExpression5<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortedExpression5<S>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
