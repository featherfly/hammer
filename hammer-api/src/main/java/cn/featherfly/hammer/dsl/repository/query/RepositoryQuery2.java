
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery2<C extends RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>,
        S extends RepositoryQuerySortExpression2<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression2<C, L, S, Q> {
}
