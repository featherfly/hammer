
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression4;

/**
 * repository query4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery4<C extends RepositoryQueryConditionsGroupExpression4<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression4<S2, Q>, S2 extends RepositoryQuerySortedExpression4<S2, Q>,
    Q extends QueryLimitExecutor> extends RepositoryQueryExpression4<C, L, S, S2, Q> {
}
