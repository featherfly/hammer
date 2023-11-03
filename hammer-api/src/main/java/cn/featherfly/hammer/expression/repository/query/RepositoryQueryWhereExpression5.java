
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression5;

/**
 * repository query where expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression5<C extends RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>,
        S extends RepositoryQuerySortExpression5<Q>, Q extends QueryLimitExecutor>
        extends RepositoryWhereExpression5<C, L> {

}
