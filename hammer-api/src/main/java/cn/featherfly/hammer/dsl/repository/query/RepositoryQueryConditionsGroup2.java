
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group2.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroup2<S extends RepositoryQuerySortExpression2<Q>,
        Q extends QueryLimitExecutor> extends RepositoryQueryConditionsGroupExpression2<
                RepositoryQueryConditionsGroup2<S, Q>, RepositoryQueryConditionsGroupLogic2<S, Q>, S, Q> {

}
