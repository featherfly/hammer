
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression5;

/**
 * repository query sorted expression5.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression5<Q extends QueryLimitExecutor> extends
        RepositorySortedExpression5<RepositoryQuerySortedExpression5<Q>>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
