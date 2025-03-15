
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression5;

/**
 * repository query conditions group5.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroup5<S extends RepositoryQuerySortExpression5<S2, Q>,
    S2 extends RepositoryQuerySortedExpression5<S2, Q>, Q extends QueryLimitExecutor>
    extends RepositoryQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5<S, S2, Q>,
        RepositoryQueryConditionsGroupLogic5<S, S2, Q>, S, S2, Q> {

}
