
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression6;

/**
 * repository query sorted expression6.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression6<Q extends QueryLimitExecutor> extends
        RepositorySortedExpression6<RepositoryQuerySortedExpression6<Q>>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
