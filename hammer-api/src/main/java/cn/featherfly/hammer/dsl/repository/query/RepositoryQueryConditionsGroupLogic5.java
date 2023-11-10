
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group logic5.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupLogic5<S extends RepositoryQuerySortExpression5<Q>,
        Q extends QueryLimitExecutor> extends RepositoryQueryConditionsGroupLogicExpression5<
                RepositoryQueryConditionsGroup5<S, Q>, RepositoryQueryConditionsGroupLogic5<S, Q>, S, Q> {
}
