
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression2;

/**
 * repository query where expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression2<C extends RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>,
        S extends RepositoryQuerySortExpression2<Q>, Q extends QueryLimitExecutor>
        extends RepositoryWhereExpression2<C, L> {

}
