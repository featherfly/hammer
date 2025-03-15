
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression2;

/**
 * repository query sorted expression2.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression2<S extends RepositoryQuerySortedExpression2<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortedExpression2<S>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
