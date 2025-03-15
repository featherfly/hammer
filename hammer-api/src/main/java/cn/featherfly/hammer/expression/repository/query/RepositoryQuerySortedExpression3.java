
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression3;

/**
 * repository query sorted expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression3<S extends RepositoryQuerySortedExpression3<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortedExpression3<S>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
