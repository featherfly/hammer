
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression4;

/**
 * repository query sorted expression4.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression4<Q extends QueryLimitExecutor> extends
        RepositorySortedExpression4<RepositoryQuerySortedExpression4<Q>>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
