
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery6<C extends RepositoryQueryConditionsGroupExpression6<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, Q>,
        S extends RepositoryQuerySortExpression6<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression6<C, L, S, Q> {
}
