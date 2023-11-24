
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression2;

/**
 * repository query sort expression2.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression2<Q extends QueryLimitExecutor>
        extends RepositorySortExpression2<RepositoryQuerySortedExpression2<Q>> {
}
