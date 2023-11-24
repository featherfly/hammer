
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression2;

/**
 * repository query sorted expression2.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression2<Q extends QueryLimitExecutor> extends
        RepositorySortedExpression2<RepositoryQuerySortedExpression2<Q>>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
