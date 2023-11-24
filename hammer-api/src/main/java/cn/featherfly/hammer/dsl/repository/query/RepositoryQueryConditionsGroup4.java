
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroup4<S extends RepositoryQuerySortExpression4<Q>,
        Q extends QueryLimitExecutor> extends RepositoryQueryConditionsGroupExpression4<
                RepositoryQueryConditionsGroup4<S, Q>, RepositoryQueryConditionsGroupLogic4<S, Q>, S, Q> {

}
