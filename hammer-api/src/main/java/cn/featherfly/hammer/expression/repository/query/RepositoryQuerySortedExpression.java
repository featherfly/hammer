
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * repository query sorted expression.
 *
 * @author zhongj
 */
public interface RepositoryQuerySortedExpression extends RepositorySortedExpression<RepositoryQuerySortedExpression>,
        QueryConditionLimit<QueryLimitExecutor>, QueryLimitExecutor {

}
