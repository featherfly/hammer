
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery4<C extends RepositoryQueryConditionsGroupExpression4<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, Q>,
        S extends RepositoryQuerySortExpression4<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression4<C, L, S, Q> {
}
