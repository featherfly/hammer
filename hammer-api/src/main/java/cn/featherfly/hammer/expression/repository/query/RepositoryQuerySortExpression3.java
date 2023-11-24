
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression3;

/**
 * repository query sort expression3.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression3<Q extends QueryLimitExecutor>
        extends RepositorySortExpression3<RepositoryQuerySortedExpression3<Q>> {

}
