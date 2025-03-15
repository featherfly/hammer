
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression4;

/**
 * repository query sort expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression4<S extends RepositoryQuerySortedExpression4<S, Q>,
    Q extends QueryLimitExecutor> extends RepositorySortExpression4<S> {

}
