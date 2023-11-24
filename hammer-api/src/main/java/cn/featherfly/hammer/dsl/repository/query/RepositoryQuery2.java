
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query2.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery2<S extends RepositoryQuerySortExpression2<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression2<RepositoryQueryConditionsGroup2<S, Q>,
                RepositoryQueryConditionsGroupLogic2<S, Q>, S, Q> {
}
