
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression3;

/**
 * repository query sorted expression3.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression3<Q extends QueryLimitExecutor> extends
        RepositorySortedExpression3<RepositoryQuerySortedExpression3<Q>>, QueryConditionLimit<Q>, QueryLimitExecutor {

}
