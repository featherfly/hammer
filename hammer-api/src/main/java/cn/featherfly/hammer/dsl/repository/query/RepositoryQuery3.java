
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression3;

/**
 * repository query3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery3<C extends RepositoryQueryConditionsGroupExpression3<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression3<S2, Q>, S2 extends RepositoryQuerySortedExpression3<S2, Q>,
    Q extends QueryLimitExecutor> extends RepositoryQueryExpression3<C, L, S, S2, Q> {
}
