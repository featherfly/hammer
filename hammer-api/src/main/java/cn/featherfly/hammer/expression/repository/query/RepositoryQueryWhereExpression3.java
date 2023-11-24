
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
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression3<C extends RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>,
        S extends RepositoryQuerySortExpression3<Q>, Q extends QueryLimitExecutor>
        extends RepositoryWhereExpression3<C, L> {

}
