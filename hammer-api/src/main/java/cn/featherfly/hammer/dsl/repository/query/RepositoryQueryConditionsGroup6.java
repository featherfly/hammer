
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroup6<S extends RepositoryQuerySortExpression6<Q>,
        Q extends QueryLimitExecutor> extends RepositoryQueryConditionsGroupExpression6<
                RepositoryQueryConditionsGroup6<S, Q>, RepositoryQueryConditionsGroupLogic6<S, Q>, S, Q> {

}
