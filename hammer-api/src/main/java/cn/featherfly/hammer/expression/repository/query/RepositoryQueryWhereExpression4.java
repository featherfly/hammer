
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression4;

/**
 * repository query where expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression4<C extends RepositoryQueryConditionsGroupExpression4<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, Q>,
        S extends RepositoryQuerySortExpression4<Q>, Q extends QueryLimitExecutor>
        extends RepositoryWhereExpression4<C, L> {

}
