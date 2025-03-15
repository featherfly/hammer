
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression6;

/**
 * repository query where expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression6<C extends RepositoryQueryConditionsGroupExpression6<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression6<S2, Q>, S2 extends RepositoryQuerySortedExpression6<S2, Q>,
    Q extends QueryLimitExecutor> extends RepositoryWhereExpression6<C, L> {

}
