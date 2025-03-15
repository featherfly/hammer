
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression3;

/**
 * repository query where expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression3<C extends RepositoryQueryConditionsGroupExpression3<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression3<S2, Q>, S2 extends RepositoryQuerySortedExpression3<S2, Q>,
    Q extends QueryLimitExecutor> extends RepositoryWhereExpression3<C, L> {

}
