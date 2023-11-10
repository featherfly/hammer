
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery5<C extends RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>,
        S extends RepositoryQuerySortExpression5<Q>, Q extends QueryLimitExecutor>
        extends RepositoryQueryExpression5<C, L, S, Q> {
}
