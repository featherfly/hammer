
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression4;

/**
 * repository query sort expression4.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression4<Q extends QueryLimitExecutor>
        extends RepositorySortExpression4<RepositoryQuerySortedExpression4<Q>> {

}
