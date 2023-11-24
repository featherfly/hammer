
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query3.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery3<S extends RepositoryQuerySortExpression3<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression3<RepositoryQueryConditionsGroup3<S, Q>,
                RepositoryQueryConditionsGroupLogic3<S, Q>, S, Q> {
}
