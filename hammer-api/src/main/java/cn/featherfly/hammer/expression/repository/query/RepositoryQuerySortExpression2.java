
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression2;

/**
 * repository query sort expression2.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression2<S extends RepositoryQuerySortedExpression2<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortExpression2<S> {
}
