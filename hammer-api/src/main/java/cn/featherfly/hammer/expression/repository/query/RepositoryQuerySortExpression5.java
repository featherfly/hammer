
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression5;

/**
 * repository query sort expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression5<S extends RepositoryQuerySortedExpression5<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortExpression5<S> {

}
